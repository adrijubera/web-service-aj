package tutorial2.mock_web_service;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.net.URL;

public class SOAPClient {
    public static void main(String[] args) {
        try {
            SOAPConnectionFactory soapCF = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapCF.createConnection();

            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPBody body = envelope.getBody();

            QName qname = new QName("http://tutorial2.mock_web_service", "planProductionOrder");
            SOAPElement soapElement = body.addBodyElement(qname);
            soapElement.addChildElement("orderId").addTextNode("123");
            soapElement.addChildElement("productType").addTextNode("Electronics");

            soapMessage.saveChanges();

            String endpoint = "http://127.0.0.1:8000/ProductionService";
            SOAPMessage response = soapConnection.call(soapMessage, endpoint);

            SOAPBody responseBody = response.getSOAPBody();
            if (responseBody.hasFault()) {
                System.out.println("Error: " + responseBody.getFault().getFaultString());
            } else {
                System.out.println("Respuesta: " + responseBody.getTextContent());
            }

            soapConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
