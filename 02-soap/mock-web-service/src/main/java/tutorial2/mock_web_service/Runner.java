package tutorial2.mock_web_service;

import jakarta.xml.ws.Endpoint;

public class Runner {
	public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8000/ProductionService", new ProductionServiceImpl());
        Endpoint.publish("http://127.0.0.1:8001/InventoryService", new InventoryServiceImpl());
    }
}
