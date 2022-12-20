package by.petrovich.dao.impl;

import by.petrovich.dao.DataBaseConnector;
import by.petrovich.dao.DiscountCardDao;
import by.petrovich.model.DiscountCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.petrovich.dao.ColumnNames.ID_DISCOUNT_CARD;
import static by.petrovich.dao.ColumnNames.NUMBER;

public class DiscountCardDaoImpl implements DiscountCardDao {
    private final DataBaseConnector dataBaseConnector = new DataBaseConnector();

    private static final String QUERY_READ_ALL_DISCOUNT_CARDS = "SELECT id_discount_card, number FROM billgenerator.discount_cards";
    private static final String QUERY_READ_DISCOUNT_CARD_BY_ID = "SELECT id_discount_card, number FROM billgenerator.discount_cards where id_discount_card = ?";
    private static final String QUERY_READ_DISCOUNT_CARD_BY_NUMBER = "SELECT id_discount_card, number FROM billgenerator.discount_cards where number = ?";

    /**
     * @return
     */
    @Override
    public List<DiscountCard> readAllDiscountCards() {
        List<DiscountCard> discountCards;
        try (Connection connection = dataBaseConnector.receiveConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_ALL_DISCOUNT_CARDS);
            ResultSet resultSet = preparedStatement.executeQuery();
            discountCards = discountCardsMapper(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return discountCards;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public DiscountCard readDiscountCardById(int id) {
        try (Connection connection = dataBaseConnector.receiveConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_DISCOUNT_CARD_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return discountCardMapper(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param number
     * @return
     */
    @Override
    public DiscountCard readDiscountCardByNumber(int number) {
        try (Connection connection = dataBaseConnector.receiveConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_DISCOUNT_CARD_BY_NUMBER);
            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            return discountCardMapper(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<DiscountCard> discountCardsMapper(ResultSet resultSet) throws SQLException {
        List<DiscountCard> discountCards = new ArrayList<>();
        while (resultSet.next()) {
            discountCards.add(populateDiscountCard(resultSet));
        }
        return discountCards;
    }

    private DiscountCard discountCardMapper(ResultSet resultSet) throws SQLException {
        DiscountCard discountCard = new DiscountCard();
        while (resultSet.next()) {
            discountCard = populateDiscountCard(resultSet);
        }
        return discountCard;
    }

    private DiscountCard populateDiscountCard(ResultSet resultSet) throws SQLException {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setId(resultSet.getInt(ID_DISCOUNT_CARD));
        discountCard.setDiscountPercent(resultSet.getInt(NUMBER));
        return discountCard;
    }

}
