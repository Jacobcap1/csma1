package DTO;

import java.util.List;

public class OrderDTO {

    private List<DrinkDTO> cart;
    private String name;
    private String phone;
    private String cardNumber;
    private String cvc;
    private String expDate;

    // No-args constructor required for Jackson
    public OrderDTO() {}

    // Getters
    public List<DrinkDTO> getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }
    public String getExpDate(){
        return expDate;
    }

    // Setters
    public void setCart(List<DrinkDTO> cart) {
        this.cart = cart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
    public void setExpDate(String expDate){
        this.expDate = expDate;
    }
}
