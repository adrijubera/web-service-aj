/**
 * InventoryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mock_web_service.tutorial2;

public interface InventoryService extends javax.xml.rpc.Service {
    public java.lang.String getInventoryServicePortAddress();

    public mock_web_service.tutorial2.InventoryServicePortType getInventoryServicePort() throws javax.xml.rpc.ServiceException;

    public mock_web_service.tutorial2.InventoryServicePortType getInventoryServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
