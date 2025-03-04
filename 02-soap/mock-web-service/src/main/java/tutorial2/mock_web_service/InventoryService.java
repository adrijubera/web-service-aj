package tutorial2.mock_web_service;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;

@WebService
public interface InventoryService {
	@WebMethod
    public String getInventoryStatus(int productId);

}
