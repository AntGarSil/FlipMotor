
package BankService.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "validateCreditCardResponse", namespace = "http://BankService/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateCreditCardResponse", namespace = "http://BankService/")
public class ValidateCreditCardResponse {

    @XmlElement(name = "return", namespace = "")
    private Integer _return;

    /**
     * 
     * @return
     *     returns Integer
     */
    public Integer getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Integer _return) {
        this._return = _return;
    }

}
