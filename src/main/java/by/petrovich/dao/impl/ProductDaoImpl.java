package by.petrovich.dao.impl;

import by.petrovich.dao.DataBaseConnector;
import by.petrovich.dao.ProductDao;
import by.petrovich.model.Product;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.petrovich.dao.ColumnNames.*;

public class ProductDaoImpl implements ProductDao {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SELECT_ALL = "SELECT id_product, name, prise, is_on_sale ";
    private static final String FROM = "FROM billgenerator.products ";
    private static final String WHERE_ID_PRODUCT = "WHERE id_product = ?";
    private final DataBaseConnector dataBaseConnector = new DataBaseConnector();

    /**
     * @param id
     * @return
     */
    @Override
    public Product readProductById(int id) {
        Product product;
        try (Connection connection = dataBaseConnector.receiveConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + FROM + WHERE_ID_PRODUCT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            product = productMapper(resultSet, id);
        } catch (SQLException e) {
            throw new RuntimeException("Problems with database access", e);
        }
        return product;
    }

    private Product productMapper(ResultSet resultSet, int id) throws SQLException {
        Product product = null;
        if (resultSet.next()) {
            product = populateProduct(resultSet);
        } else {
            LOGGER.log(Level.INFO, "Product with id: {} doesn't exist", id);
            System.out.printf("Product with id: %d doesn't exist", id);
        }
        return product;
    }

    private Product populateProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt(ID_PRODUCT));
        product.setName(resultSet.getString(NAME));
        product.setPrise(resultSet.getDouble(PRISE));
        product.setOnSale(resultSet.getBoolean(IS_ON_SALE));
        return product;
    }
}
