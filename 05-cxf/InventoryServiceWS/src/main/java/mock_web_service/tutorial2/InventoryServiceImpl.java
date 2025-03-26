package mock_web_service.tutorial2;

import javax.jws.WebService;

@WebService(endpointInterface = "tutorial2.mock_web_service.InventoryServicePortType")
public class InventoryServiceImpl {

    public String getInventoryStatus(int productId) {
        if (productId == 1) return "In stock";
        if (productId == 2) return "Sold out";
        return "Unknown";
    }
}