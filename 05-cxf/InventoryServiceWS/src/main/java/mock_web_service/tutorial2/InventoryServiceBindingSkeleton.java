/**
 * InventoryServiceBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mock_web_service.tutorial2;

public class InventoryServiceBindingSkeleton implements mock_web_service.tutorial2.InventoryServicePortType, org.apache.axis.wsdl.Skeleton {
    private mock_web_service.tutorial2.InventoryServicePortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tutorial2.mock_web_service", "getInventoryStatus"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tutorial2.mock_web_service", ">getInventoryStatus"), mock_web_service.tutorial2.GetInventoryStatus.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getInventoryStatus", _params, new javax.xml.namespace.QName("http://tutorial2.mock_web_service", "getInventoryStatusResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://tutorial2.mock_web_service", ">getInventoryStatusResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tutorial2.mock_web_service", "getInventoryStatus"));
        _oper.setSoapAction("http://tutorial2.mock_web_service/getInventoryStatus");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getInventoryStatus") == null) {
            _myOperations.put("getInventoryStatus", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getInventoryStatus")).add(_oper);
    }

    public InventoryServiceBindingSkeleton() {
        this.impl = new mock_web_service.tutorial2.InventoryServiceBindingImpl();
    }

    public InventoryServiceBindingSkeleton(mock_web_service.tutorial2.InventoryServicePortType impl) {
        this.impl = impl;
    }
    public mock_web_service.tutorial2.GetInventoryStatusResponse getInventoryStatus(mock_web_service.tutorial2.GetInventoryStatus parameters) throws java.rmi.RemoteException
    {
        mock_web_service.tutorial2.GetInventoryStatusResponse ret = impl.getInventoryStatus(parameters);
        return ret;
    }

}
