package tutorial2.mock_web_service;

import jakarta.jws.WebService;

@WebService(endpointInterface = "tutorial2.mock_web_service.InventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Override
    public String getInventoryStatus(int productId) {
        return "Inventory status for product ID " + productId + ": In stock";
    }
}