package tutorial2.mock_web_service;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;

@WebService
public interface ProductionService {
	@WebMethod
    public String planProductionOrder(int orderId, String productType);

}
