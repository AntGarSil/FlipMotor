/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BankService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author root
 */
@WebService(serviceName = "BankService")
public class BankService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validateCreditCard")
    public Integer validateCreditCard(@WebParam(name = "creditCard") String creditCard, @WebParam(name = "expireMonth") int expireMonth, @WebParam(name = "expireYear") int expireYear) {
        //TODO write your implementation code here:
      
    int sum = 0;
    int digit = 0;
    int addend = 0;
    boolean timesTwo = false;

    for (int i = creditCard.length() - 1; i >= 0; i--) {
        digit = Integer.parseInt(creditCard.substring(i, i + 1));
        if (timesTwo) {
            addend = digit * 2;
            if (addend > 9) {
                addend -= 9;
            }
        } else {
            addend = digit;
        }
        sum += addend;
        timesTwo = !timesTwo;
    }

    int modulus = sum % 10;
    if(modulus==0)
    {
        return sum;
    }
    else
    {
        return -1;
    }
}
}
