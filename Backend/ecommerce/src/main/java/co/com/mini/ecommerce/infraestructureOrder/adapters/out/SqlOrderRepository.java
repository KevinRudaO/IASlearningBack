package co.com.mini.ecommerce.infraestructureOrder.adapters.out;


import co.com.mini.ecommerce.Application.commons.NonEmptyBasePrice;
import co.com.mini.ecommerce.Application.commons.NonEmptyString;
import co.com.mini.ecommerce.ApplicationOrder.domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.domain.OrderIdentificationNumber;
import co.com.mini.ecommerce.ApplicationOrder.ports.out.OrderRepository;
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
public class SqlOrderRepository implements OrderRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Order> OrderRowMapper = (rs, RowNum)->fromResultSet(rs);

    public SqlOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Order> getOrderById(OrderIdentificationNumber orderId) {
       final String sql="SELECT * FROM PRODUCTORDER";

        PreparedStatementSetter preparedStatementSetter=ps->{
           ps.setInt(1,orderId.getValue());
        };

        final ResultSetExtractor<Optional<Order>> resultSetExtractor= rs->{
            if (rs.next()){
                final Order order =fromResultSet(rs);
                return  Optional.of(order);
            }else{
                return Optional.empty();
            }
        };

       return jdbcTemplate.query(sql,preparedStatementSetter,resultSetExtractor);

    }

    @Override
    public void storeOrder(Order order) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO ORDERPRODUCT (clientid,orderstatus,totalprice,clientname,productname)VALUES(?,?,?,?,?)");

           preparedStatement.setInt(1,order.getClientId().getValue());
           preparedStatement.setString(2,order.getOrderStatus().getValue());
           preparedStatement.setFloat(3,order.getTotalPrice().getValue());
           preparedStatement.setString(4,order.getClientName().getValue());
           preparedStatement.setString(5,order.getProductName().getValue());

            return preparedStatement;
        });

    }

    @Override
    public Collection<Order> listOrder() {
        final String sql="SELECT * FROM ORDERPRODUCT";
        return jdbcTemplate.query(sql,OrderRowMapper);
    }

    private static Order fromResultSet(ResultSet rs)throws SQLException{
        return new Order(
          new OrderIdentificationNumber(rs.getInt("clientid")) ,
          new NonEmptyString(rs.getString("orderstatus")) ,
          new NonEmptyBasePrice( rs.getFloat("totalprice")),
           new NonEmptyString(rs.getString("clientname")),
            new NonEmptyString(rs.getString("productname")));

    }
}
