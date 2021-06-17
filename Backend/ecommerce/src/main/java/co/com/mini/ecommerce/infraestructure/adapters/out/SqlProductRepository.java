package co.com.mini.ecommerce.infraestructure.adapters.out;

import co.com.mini.ecommerce.Application.commons.*;
import co.com.mini.ecommerce.Application.domain.EnumProductStatus;
import co.com.mini.ecommerce.Application.domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.domain.Product;
import co.com.mini.ecommerce.Application.ports.out.ProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;
@Repository
public class SqlProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public SqlProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<Product> ProductRowMapper = (rs, RowNum)->fromResultSet(rs);


    @Override
    public Optional<Product> getProductById(IdentificationNumber identificationNumber) {
        final String sql = "SELECT * FROM PRODUCT WHERE PRODUCTID= ?";
        PreparedStatementSetter preparedStatementSetter =ps ->{
            ps.setInt(1,identificationNumber.getValue());
        };
        final ResultSetExtractor<Optional<Product>> resultSetExtractor=rs->{
            if (rs.next()){
                final Product product =fromResultSet(rs);
                return  Optional.of(product);
            }else{
                return Optional.empty();
            }
        };
        return jdbcTemplate.query(sql,preparedStatementSetter,resultSetExtractor);
    }


    @Override
    public void storeProduct(Product product) {
    jdbcTemplate.update(connection -> {
        final PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO PRODUCT (PRODUCTID,NAME,DESCRIPTION,BASEPRICE,TAXRATE,PRODUCTSTATUS,INVENTORYQUANTITY)VALUES(?,?,?,?,?,?,?)");

        preparedStatement.setInt(1,product.getProductId().getValue());
        preparedStatement.setString(2,product.getName().getValue());
        preparedStatement.setString(3,product.getDescription().getValue());
        preparedStatement.setFloat(4,product.getBasePrice().getValue());
        preparedStatement.setFloat(5,product.getTaxRate().getValue());
        preparedStatement.setString(6,product.getProductStatus().name());
        preparedStatement.setInt(7,product.getInventoryQuantity().getValue());

        return preparedStatement;
    });
    }

    @Override
    public void deleteProductById(long productId) {
        final String sql="DELETE FROM PRODUCT WHERE PRODUCTID = ?";

        PreparedStatementSetter preparedStatementSetter =ps ->{
            ps.setLong(1,productId);
         };
        jdbcTemplate.update(sql,preparedStatementSetter);

    }

    public Collection<Product> getIdProduct (int productId){
        final String sql="SELECT FROM PRODUCT WHERE PRODUCTID = ?";

        PreparedStatementSetter preparedStatementSetter = ps ->{
            ps.setInt(1,productId);


        };
        return jdbcTemplate.query(sql,ProductRowMapper);

    }


    @Override
    public Collection<Product> listProduct() {
        final String sql = "SELECT * FROM PRODUCT";
        return jdbcTemplate.query(sql,ProductRowMapper);
    }

    @Override
    public Collection<Product> getProductId(IdentificationNumber identificationNumber) {
        String sql = "SELECT * FROM PRODUCT WHERE PRODUCTID= ?";
        PreparedStatementSetter preparedStatementSetter= preparedStatement ->{
            preparedStatement.setInt(1,identificationNumber.getValue());
        };
        return jdbcTemplate.query(sql, preparedStatementSetter,ProductRowMapper);
    }

    @Override
    public void editProduct(Product product) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE PRODUCT SET NAME=?,DESCRIPTION=?,BASEPRICE=?,TAXRATE=?,PRODUCTSTATUS=?,INVENTORYQUANTITY=? WHERE PRODUCTID=? "
            );
           preparedStatement.setString(1,product.getName().getValue());
           preparedStatement.setString(2,product.getDescription().getValue());
           preparedStatement.setFloat(3,product.getBasePrice().getValue());
           preparedStatement.setFloat(4,product.getTaxRate().getValue());
           preparedStatement.setString(5,product.getProductStatus().name());
           preparedStatement.setInt(6,product.getInventoryQuantity().getValue());
           preparedStatement.setInt(7,product.getProductId().getValue());
           return preparedStatement;
        });
    }

    private static Product fromResultSet (ResultSet rs) throws SQLException{
     return new Product(
             new IdentificationNumber(rs.getInt("ProductId")),
             new NonEmptyName(rs.getString("Name")),
             new NonEmptyDescription(rs.getString("Description")),
             new NonEmptyBasePrice(rs.getFloat("BasePrice")),
             new NonEmptyTaxRate(rs.getFloat("TaxRate")),
             EnumProductStatus.valueOf(rs.getString("ProductStatus")),
             new NonEmptyInvQuantity(rs.getInt("InventoryQuantity"))
     );
    }
}
