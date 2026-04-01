const { test, expect } = require('@playwright/test');

test.describe('Product Catalog API', () => {
  test('GET /api/products returns a list', async ({ request }) => {
    const response = await request.get('/api/products');

    expect(response.ok()).toBeTruthy();
    const products = await response.json();

    expect(Array.isArray(products)).toBeTruthy();
    expect(products.length).toBeGreaterThan(0);
    expect(products[0]).toHaveProperty('id');
    expect(products[0]).toHaveProperty('name');
    expect(products[0]).toHaveProperty('price');
  });

  test('POST then GET by id then DELETE then GET missing', async ({ request }) => {
    const uniqueName = `Playwright Product ${Date.now()}`;
    const payload = { name: uniqueName, price: 2222 };

    const createResponse = await request.post('/api/products', {
      data: payload
    });

    expect(createResponse.status()).toBe(201);

    const location = createResponse.headers()['location'];
    expect(location).toBeTruthy();

    const idMatch = location.match(/\/(\d+)$/);
    expect(idMatch).toBeTruthy();
    const productId = idMatch[1];

    const getResponse = await request.get(`/api/products/${productId}`);
    expect(getResponse.status()).toBe(200);

    const createdProduct = await getResponse.json();
    expect(createdProduct.name).toBe(uniqueName);
    expect(createdProduct.price).toBe(payload.price);

    const deleteResponse = await request.delete(`/api/products/${productId}`);
    expect(deleteResponse.status()).toBe(204);

    const getMissingResponse = await request.get(`/api/products/${productId}`);
    expect(getMissingResponse.status()).toBe(404);
  });

  test('DELETE non-existing product returns 404', async ({ request }) => {
    const response = await request.delete('/api/products/999999999');
    expect(response.status()).toBe(404);
  });
});
