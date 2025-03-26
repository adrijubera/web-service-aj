/**
 * InventoryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mock_web_service.tutorial2;

public class InventoryServiceLocator extends org.apache.axis.client.Service implements mock_web_service.tutorial2.InventoryService {

    public InventoryServiceLocator() {
    }


    public InventoryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InventoryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for InventoryServicePort
    private java.lang.String InventoryServicePort_address = "http://127.0.0.1:8001/InventoryService";

    public java.lang.String getInventoryServicePortAddress() {
        return InventoryServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String InventoryServicePortWSDDServiceName = "InventoryServicePort";

    public java.lang.String getInventoryServicePortWSDDServiceName() {
        return InventoryServicePortWSDDServiceName;
    }

    public void setInventoryServicePortWSDDServiceName(java.lang.String name) {
        InventoryServicePortWSDDServiceName = name;
    }

    public mock_web_service.tutorial2.InventoryServicePortType getInventoryServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(InventoryServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getInventoryServicePort(endpoint);
    }

    public mock_web_service.tutorial2.InventoryServicePortType getInventoryServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mock_web_service.tutorial2.InventoryServiceBindingStub _stub = new mock_web_service.tutorial2.InventoryServiceBindingStub(portAddress, this);
            _stub.setPortName(getInventoryServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setInventoryServicePortEndpointAddress(java.lang.String address) {
        InventoryServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mock_web_service.tutorial2.InventoryServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                mock_web_service.tutorial2.InventoryServiceBindingStub _stub = new mock_web_service.tutorial2.InventoryServiceBindingStub(new java.net.URL(InventoryServicePort_address), this);
                _stub.setPortName(getInventoryServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("InventoryServicePort".equals(inputPortName)) {
            return getInventoryServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tutorial2.mock_web_service", "InventoryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tutorial2.mock_web_service", "InventoryServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("InventoryServicePort".equals(portName)) {
            setInventoryServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
