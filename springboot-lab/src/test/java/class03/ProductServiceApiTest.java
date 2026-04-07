package class03;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

class ProductServiceApiTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;

        if (!isServiceUp()) {
            Thread serverThread = new Thread(() -> {
                try {
                    Class<?> serviceClass = Class.forName("class03.ProductService");
                    serviceClass.getMethod("main", String[].class).invoke(null, (Object) new String[0]);
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException(e);
                }
            });
            serverThread.setDaemon(true);
            serverThread.start();
            waitUntilServiceIsUp();
        }
    }

    @Test
    void healthEndpointShouldReturnUp() {
        given()
            .when()
            .get("/health")
            .then()
            .statusCode(200)
            .body("status", is("UP"));
    }

    @Test
    void listProductsShouldReturnSeededData() {
        given()
            .when()
            .get("/products")
            .then()
            .statusCode(200)
            .body("", hasSize(greaterThanOrEqualTo(2)));
    }

    @Test
    void getProductByIdShouldReturnProduct() {
        given()
            .queryParam("id", 1)
            .when()
            .get("/products")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    void createProductShouldReturnCreatedProduct() {
        given()
            .queryParam("name", "Webcam")
            .queryParam("price", 2499)
            .when()
            .post("/products")
            .then()
            .statusCode(201)
            .body("name", is("Webcam"))
            .body("price", is(2499));
    }

    @Test
    void getProductByInvalidIdShouldReturnBadRequest() {
        given()
            .queryParam("id", "abc")
            .when()
            .get("/products")
            .then()
            .statusCode(400)
            .body("error", is("Invalid id"));
    }

    @Test
    void missingFieldsOnCreateShouldReturnBadRequest() {
        given()
            .queryParam("name", "")
            .when()
            .post("/products")
            .then()
            .statusCode(400)
            .body("error", is("name and price are required"));
    }

    private static boolean isServiceUp() {
        try {
            given()
                .when()
                .get("/health")
                .then()
                .statusCode(200);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private static void waitUntilServiceIsUp() {
        Instant deadline = Instant.now().plus(Duration.ofSeconds(10));
        while (Instant.now().isBefore(deadline)) {
            if (isServiceUp()) {
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for ProductService to start", e);
            }
        }
        throw new IllegalStateException("ProductService did not start within 10 seconds");
    }
}
