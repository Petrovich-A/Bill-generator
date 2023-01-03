package by.petrovich.service;

import by.petrovich.dao.DiscountCardDao;
import by.petrovich.dao.impl.DiscountCardDaoImpl;
import by.petrovich.model.DiscountCard;

import java.util.List;

public interface DiscountCardService {
    DiscountCardDao discountCardDao = new DiscountCardDaoImpl();

    List<DiscountCard> receiveAllDiscountCards();


    DiscountCard readDiscountCardById(int id);


    DiscountCard readDiscountCardByNumber(int number);

}
