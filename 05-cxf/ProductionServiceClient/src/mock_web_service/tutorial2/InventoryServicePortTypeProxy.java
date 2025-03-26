package mock_web_service.tutorial2;

public class InventoryServicePortTypeProxy implements mock_web_service.tutorial2.InventoryServicePortType {
  private String _endpoint = null;
  private mock_web_service.tutorial2.InventoryServicePortType inventoryServicePortType = null;
  
  public InventoryServicePortTypeProxy() {
    _initInventoryServicePortTypeProxy();
  }
  
  public InventoryServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initInventoryServicePortTypeProxy();
  }
  
  private void _initInventoryServicePortTypeProxy() {
    try {
      inventoryServicePortType = (new mock_web_service.tutorial2.InventoryServiceLocator()).getInventoryServicePort();
      if (inventoryServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)inventoryServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)inventoryServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (inventoryServicePortType != null)
      ((javax.xml.rpc.Stub)inventoryServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mock_web_service.tutorial2.InventoryServicePortType getInventoryServicePortType() {
    if (inventoryServicePortType == null)
      _initInventoryServicePortTypeProxy();
    return inventoryServicePortType;
  }
  
  public mock_web_service.tutorial2.GetInventoryStatusResponse getInventoryStatus(mock_web_service.tutorial2.GetInventoryStatus parameters) throws java.rmi.RemoteException{
    if (inventoryServicePortType == null)
      _initInventoryServicePortTypeProxy();
    return inventoryServicePortType.getInventoryStatus(parameters);
  }
  
  
}