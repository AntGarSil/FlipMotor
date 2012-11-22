/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastore.Entities;

/**
 *
 * @author PC
 */
public class UserEntity {

    private String UserName;
    private String UserPassword;
    private String UserID;   
    private String CreditCard;
    private String NIF;
    private int Phone;
    private int AddressNo;
    private int AddressPC;
    private int AddressFlat;
    private String AddressLetter;  
    private String Email;




    public UserEntity() {
    }
    
    public UserEntity(String userid, String username, String pass) {
        this.UserID = userid;
        this.UserName = username;
        this.UserPassword = pass;                
    }

    public UserEntity(String UserName, String UserPassword, String UserID, String CreditCard, String NIF,
            int Phone, int AddressNo, int AddressPC, int AddressFlat, String AddressLetter, String email) {
        this.UserName = UserName;
        this.UserPassword = UserPassword;
        this.UserID = UserID;
        this.CreditCard = CreditCard;
        this.NIF = NIF;
        this.Phone = Phone;
        this.AddressNo = AddressNo;
        this.AddressPC = AddressPC;
        this.AddressFlat = AddressFlat;
        this.AddressLetter = AddressLetter;
        this.Email = email;
    }

    
    
    /**
     * Get the value of UserName
     *
     * @return the value of UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * Set the value of UserName
     *
     * @param UserName new value of UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    

    /**
     * Get the value of UserPassword
     *
     * @return the value of UserPassword
     */
    public String getUserPassword() {
        return UserPassword;
    }

    /**
     * Set the value of UserPassword
     *
     * @param UserPassword new value of UserPassword
     */
    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    /**
     * Get the value of UserID
     *
     * @return the value of UserID
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * Set the value of UserID
     *
     * @param UserID new value of UserID
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    


    /**
     * Get the value of NIF
     *
     * @return the value of NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Set the value of NIF
     *
     * @param NIF new value of NIF
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }


    /**
     * Get the value of Phone
     *
     * @return the value of Phone
     */
    public int getPhone() {
        return Phone;
    }

    /**
     * Set the value of Phone
     *
     * @param Phone new value of Phone
     */
    public void setPhone(int Phone) {
        this.Phone = Phone;
    }


    /**
     * Get the value of AddressNo
     *
     * @return the value of AddressNo
     */
    public int getAddressNo() {
        return AddressNo;
    }

    /**
     * Set the value of AddressNo
     *
     * @param AddressNo new value of AddressNo
     */
    public void setAddressNo(int AddressNo) {
        this.AddressNo = AddressNo;
    }


    /**
     * Get the value of AddressPC
     *
     * @return the value of AddressPC
     */
    public int getAddressPC() {
        return AddressPC;
    }

    /**
     * Set the value of AddressPC
     *
     * @param AddressPC new value of AddressPC
     */
    public void setAddressPC(int AddressPC) {
        this.AddressPC = AddressPC;
    }


    /**
     * Get the value of AddressFlat
     *
     * @return the value of AddressFlat
     */
    public int getAddressFlat() {
        return AddressFlat;
    }

    /**
     * Set the value of AddressFlat
     *
     * @param AddressFlat new value of AddressFlat
     */
    public void setAddressFlat(int AddressFlat) {
        this.AddressFlat = AddressFlat;
    }


    /**
     * Get the value of AddressLetter
     *
     * @return the value of AddressLetter
     */
    public String getAddressLetter() {
        return AddressLetter;
    }

    /**
     * Set the value of AddressLetter
     *
     * @param AddressLetter new value of AddressLetter
     */
    public void setAddressLetter(String AddressLetter) {
        this.AddressLetter = AddressLetter;
    }




    /**
     * Get the value of CreditCard
     *
     * @return the value of CreditCard
     */
    public String getCreditCard() {
        return CreditCard;
    }

    /**
     * Set the value of CreditCard
     *
     * @param CreditCard new value of CreditCard
     */
    public void setCreditCard(String CreditCard) {
        this.CreditCard = CreditCard;
    }

        /**
     * Get the value of Email
     *
     * @return the value of Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Set the value of Email
     *
     * @param Email new value of Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
}
