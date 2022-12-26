package by.petrovich.model;

import java.util.Objects;

public class InputData {
    private int productId;
    private int quantity;
    private int cardNumber;

    public InputData(int productId, int quantity, int cardNumber) {
        this.productId = productId;
        this.quantity = quantity;
        this.cardNumber = cardNumber;
    }

    public int getProductId() {
        return productId;
    }

    public InputData setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public InputData setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public InputData setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputData inputData = (InputData) o;
        return productId == inputData.productId && quantity == inputData.quantity && cardNumber == inputData.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity, cardNumber);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InputData{");
        sb.append("productId=").append(productId);
        sb.append(", quantity=").append(quantity);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append('}');
        return sb.toString();
    }
}
