package client;

import java.util.HashMap;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

import org.apache.wss4j.dom.handler.WSHandlerConstants;

public class InventoryClient {

    public static void main(String[] args) {

        InventoryService service = new InventoryService();
        InventoryServicePortType port = service.getInventoryServicePort();

        Client client = ClientProxy.getClient(port);
        Map<String, Object> props = new HashMap<>();

        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.USER, "Hello");
        props.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
        props.put(WSHandlerConstants.PW_CALLBACK_CLASS, PasswordCallback.class.getName());

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
        client.getOutInterceptors().add(wssOut);

        String status = port.getInventoryStatus(1);
        System.out.println("Product state: " + status);
    }
}