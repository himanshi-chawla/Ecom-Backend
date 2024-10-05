package com.ecom.product.repository;

import com.ecom.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts(){
        String sql = "SELECT * FROM product";
        List<Product> listOfProducts = jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getLong("price")); // Use BigDecimal for price
                product.setCategory(rs.getString("category"));
                product.setQuantity(rs.getInt("quantity"));
                return product;
            }
        });
        return listOfProducts;
    }

    public void saveProduct(Product product){
        String sqlQuery = "INSERT INTO product (name, description, price, category, quantity) VALUES " +
                "('" + product.getName() + "','" + product.getDescription() + "','" + product.getPrice() + "','" + product.getCategory() + "','"+ product.getQuantity() +"')";
        jdbcTemplate.execute(sqlQuery);
    }
    public void updateProduct(Product product){
        String sql = "UPDATE product set " + "name = '"+product.getName() +"',description = '"+product.getDescription() + "', price = '" +product.getPrice() + "'," +
            " category ='"+ product.getCategory() + "', quantity = '"+product.getQuantity()+ "' " + "WHERE  id = " + product.getId();
        jdbcTemplate.execute(sql);
    }

}
