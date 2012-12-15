
package WebServiceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the WebServiceClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidateCreditCardResponse_QNAME = new QName("http://BankService/", "validateCreditCardResponse");
    private final static QName _ValidateCreditCard_QNAME = new QName("http://BankService/", "validateCreditCard");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: WebServiceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateCreditCard }
     * 
     */
    public ValidateCreditCard createValidateCreditCard() {
        return new ValidateCreditCard();
    }

    /**
     * Create an instance of {@link ValidateCreditCardResponse }
     * 
     */
    public ValidateCreditCardResponse createValidateCreditCardResponse() {
        return new ValidateCreditCardResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCreditCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "validateCreditCardResponse")
    public JAXBElement<ValidateCreditCardResponse> createValidateCreditCardResponse(ValidateCreditCardResponse value) {
        return new JAXBElement<ValidateCreditCardResponse>(_ValidateCreditCardResponse_QNAME, ValidateCreditCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BankService/", name = "validateCreditCard")
    public JAXBElement<ValidateCreditCard> createValidateCreditCard(ValidateCreditCard value) {
        return new JAXBElement<ValidateCreditCard>(_ValidateCreditCard_QNAME, ValidateCreditCard.class, null, value);
    }

}
