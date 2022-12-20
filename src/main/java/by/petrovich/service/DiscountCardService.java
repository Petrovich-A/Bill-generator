package by.petrovich.service;

import by.petrovich.dao.DiscountCardDao;
import by.petrovich.dao.impl.DiscountCardDaoImpl;
import by.petrovich.model.DiscountCard;

import java.util.List;

public class DiscountCardService {
    private final DiscountCardDao discountCardDao = new DiscountCardDaoImpl();

    public List<DiscountCard> receiveAllDiscountCards() {
        return discountCardDao.readAllDiscountCards();
    }

    public DiscountCard readDiscountCardById(int id) {
        return discountCardDao.readDiscountCardById(id);
    }

    public DiscountCard readDiscountCardByNumber(int number) {
        return discountCardDao.readDiscountCardByNumber(number);
    }
}
