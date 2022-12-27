package by.petrovich.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InputData {
    private Map<Integer, Integer> idToQuantity = new HashMap<>();
    private int cardNumber;

    public InputData(Map<Integer, Integer> idToQuantity, int cardNumber) {
        this.idToQuantity = idToQuantity;
        this.cardNumber = cardNumber;
    }

    public InputData() {

    }

    public Map<Integer, Integer> getIdToQuantity() {
        return idToQuantity;
    }

    public InputData setIdToQuantity(Map<Integer, Integer> idToQuantity) {
        this.idToQuantity = idToQuantity;
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
        return cardNumber == inputData.cardNumber && Objects.equals(idToQuantity, inputData.idToQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idToQuantity, cardNumber);
    }

    @Override
    public String toString() {
        return "InputData{" + "idToQuantity=" + idToQuantity +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
