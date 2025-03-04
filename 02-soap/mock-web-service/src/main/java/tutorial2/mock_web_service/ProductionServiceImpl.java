package tutorial2.mock_web_service;

import jakarta.jws.WebService;

@WebService(endpointInterface = "tutorial2.mock_web_service.ProductionService")
public class ProductionServiceImpl implements ProductionService {
	@Override
    public String planProductionOrder(int orderId, String productType) {
        return "Production plan for order " + orderId + " of " + productType + " has been generated.";
    }

}
