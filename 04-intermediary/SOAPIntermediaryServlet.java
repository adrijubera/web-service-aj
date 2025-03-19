import javax.xml.soap.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet("/SOAPIntermediary")
public class SOAPIntermediaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            SOAPConnectionFactory soapCF = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapCF.createConnection();

            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage(null, request.getInputStream());

            SOAPBody requestBody = soapMessage.getSOAPBody();
            SOAPHeader requestHeader = soapMessage.getSOAPHeader();
            Iterator<?> headerElements = requestHeader.getChildElements();
            boolean priorityHigh = false;

            while (headerElements.hasNext()) {
                SOAPElement element = (SOAPElement) headerElements.next();
                if (element.getNodeName().equals("priority") && element.getValue().equals("High")) {
                    priorityHigh = true;
                    break;
                }
            }

            Iterator<?> bodyElements = requestBody.getChildElements();
            while (bodyElements.hasNext()) {
                SOAPElement element = (SOAPElement) bodyElements.next();
                if (element.getNodeName().equals("orderId") && priorityHigh) {
                    int orderId = Integer.parseInt(element.getValue());
                    element.setValue(String.valueOf(orderId * 2)); 
                }
            }
            
            soapMessage.saveChanges();

            String endpoint = "http://127.0.0.1:8000/ProductionService";
            SOAPMessage serviceResponse = soapConnection.call(soapMessage, endpoint);

            SOAPHeader responseHeader = serviceResponse.getSOAPHeader();
            QName processedBy = new QName("http://tutorial2.mock_web_service", "processedBy");
            SOAPElement processedElement = responseHeader.addChildElement(processedBy);
            processedElement.addTextNode("Processed by SOAP Intermediary");
            serviceResponse.saveChanges();

            serviceResponse.writeTo(response.getOutputStream());
            soapConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
