
package BankService.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "validateCreditCard", namespace = "http://BankService/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateCreditCard", namespace = "http://BankService/", propOrder = {
    "creditCard",
    "expireMonth",
    "expireYear"
})
public class ValidateCreditCard {

    @XmlElement(name = "creditCard", namespace = "")
    private String creditCard;
    @XmlElement(name = "expireMonth", namespace = "")
    private int expireMonth;
    @XmlElement(name = "expireYear", namespace = "")
    private int expireYear;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCreditCard() {
        return this.creditCard;
    }

    /**
     * 
     * @param creditCard
     *     the value for the creditCard property
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getExpireMonth() {
        return this.expireMonth;
    }

    /**
     * 
     * @param expireMonth
     *     the value for the expireMonth property
     */
    public void setExpireMonth(int expireMonth) {
        this.expireMonth = expireMonth;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getExpireYear() {
        return this.expireYear;
    }

    /**
     * 
     * @param expireYear
     *     the value for the expireYear property
     */
    public void setExpireYear(int expireYear) {
        this.expireYear = expireYear;
    }

}
