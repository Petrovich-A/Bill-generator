package by.petrovich.dao;

import by.petrovich.model.DiscountCard;

import java.util.List;

public interface DiscountCardDao {
    List<DiscountCard> readAllDiscountCards();

    DiscountCard readDiscountCardById(int id);

    DiscountCard readDiscountCardByNumber(int number);

}
