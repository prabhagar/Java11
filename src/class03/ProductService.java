package class03;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private static final List<Product> PRODUCTS = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) throws IOException {
        seedData();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/health", ProductService::handleHealth);
        server.createContext("/products", ProductService::handleProducts);
        server.setExecutor(null);
        server.start();

        System.out.println("Class 3 Microservice Lab");
        System.out.println("Service running at http://localhost:8080");
        System.out.println("Try these:");
        System.out.println("GET  /health");
        System.out.println("GET  /products");
        System.out.println("GET  /products?id=1");
        System.out.println("POST /products?name=Mouse&price=499");
        System.out.println("Exercise: implement DELETE /products?id=...");
    }

    private static void seedData() {
        PRODUCTS.add(new Product(nextId++, "Keyboard", 1499));
        PRODUCTS.add(new Product(nextId++, "Monitor", 8999));
    }

    private static void handleHealth(HttpExchange exchange) throws IOException {
        if (!"GET".equals(exchange.getRequestMethod())) {
            sendJson(exchange, 405, "{\"error\":\"Method not allowed\"}");
            return;
        }
        sendJson(exchange, 200, "{\"status\":\"UP\"}");
    }

    private static void handleProducts(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        Map<String, String> query = parseQuery(exchange.getRequestURI().getRawQuery());

        if ("GET".equals(method)) {
            if (query.containsKey("id")) {
                getProductById(exchange, query.get("id"));
            } else {
                listProducts(exchange);
            }
            return;
        }

        if ("POST".equals(method)) {
            createProduct(exchange, query);
            return;
        }

        // Class exercise: implement DELETE /products?id=...
        if ("DELETE".equals(method)) {
            sendJson(exchange, 501, "{\"message\":\"Exercise: implement DELETE endpoint\"}");
            return;
        }

        sendJson(exchange, 405, "{\"error\":\"Method not allowed\"}");
    }

    private static void listProducts(HttpExchange exchange) throws IOException {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < PRODUCTS.size(); i++) {
            if (i > 0) {
                json.append(',');
            }
            json.append(PRODUCTS.get(i).toJson());
        }
        json.append(']');
        sendJson(exchange, 200, json.toString());
    }

    private static void getProductById(HttpExchange exchange, String idText) throws IOException {
        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException ex) {
            sendJson(exchange, 400, "{\"error\":\"Invalid id\"}");
            return;
        }

        for (Product product : PRODUCTS) {
            if (product.id == id) {
                sendJson(exchange, 200, product.toJson());
                return;
            }
        }

        sendJson(exchange, 404, "{\"error\":\"Product not found\"}");
    }

    private static void createProduct(HttpExchange exchange, Map<String, String> query) throws IOException {
        String name = query.get("name");
        String priceText = query.get("price");

        if (name == null || name.isBlank() || priceText == null || priceText.isBlank()) {
            sendJson(exchange, 400, "{\"error\":\"name and price are required\"}");
            return;
        }

        int price;
        try {
            price = Integer.parseInt(priceText);
        } catch (NumberFormatException ex) {
            sendJson(exchange, 400, "{\"error\":\"price must be an integer\"}");
            return;
        }

        Product created = new Product(nextId++, name.strip(), price);
        PRODUCTS.add(created);
        sendJson(exchange, 201, created.toJson());
    }

    private static Map<String, String> parseQuery(String rawQuery) {
        Map<String, String> result = new HashMap<>();
        if (rawQuery == null || rawQuery.isBlank()) {
            return result;
        }

        String[] pairs = rawQuery.split("&");
        for (String pair : pairs) {
            String[] parts = pair.split("=", 2);
            String key = decode(parts[0]);
            String value = parts.length > 1 ? decode(parts[1]) : "";
            result.put(key, value);
        }
        return result;
    }

    private static String decode(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    private static void sendJson(HttpExchange exchange, int statusCode, String body) throws IOException {
        byte[] payload = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.sendResponseHeaders(statusCode, payload.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(payload);
        }
    }

    private static class Product {
        private final int id;
        private final String name;
        private final int price;

        private Product(int id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        private String toJson() {
            return "{\"id\":" + id + ",\"name\":\"" + escape(name) + "\",\"price\":" + price + "}";
        }
    }

    private static String escape(String text) {
        return text.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}