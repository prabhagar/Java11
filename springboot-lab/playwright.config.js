const { defineConfig } = require('@playwright/test');

module.exports = defineConfig({
  testDir: './tests/api',
  timeout: 30_000,
  fullyParallel: false,
  workers: 1,
  reporter: [['list'], ['html', { open: 'never' }]],
  use: {
    baseURL: 'http://127.0.0.1:8081'
  },
  webServer: {
    command: 'mvn -f pom.xml spring-boot:run',
    url: 'http://127.0.0.1:8081/api/products',
    timeout: 120_000,
    reuseExistingServer: true
  }
});
