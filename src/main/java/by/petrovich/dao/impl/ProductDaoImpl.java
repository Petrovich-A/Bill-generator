package by.petrovich.dao.impl;

import by.petrovich.dao.DataBaseConnector;
import by.petrovich.dao.ProductDao;
import by.petrovich.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.petrovich.dao.ColumnNames.*;

public class ProductDaoImpl implements ProductDao {

    private final DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private static final String QUERY_READ_PRODUCT_BY_ID = "SELECT * FROM billgenerator.products WHERE id_product = ?";


    /**
     * @param id
     * @return
     */
    @Override
    public Product readProductById(int id) {
        Product product;
        try (Connection connection = dataBaseConnector.receiveConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            product = productMapper(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    private Product productMapper(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        while (resultSet.next()) {
            product = populateProduct(resultSet);
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
