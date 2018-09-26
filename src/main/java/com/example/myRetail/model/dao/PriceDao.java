package com.example.myRetail.model.dao;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.example.myRetail.model.entity.Price;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;

public class PriceDao {

    @Autowired
    Price price;
    private CassandraConnection conn = new CassandraConnection();

    /* Pull price and currency code from Cassandra keyspace
    * */
    public Price getPrice(int id) {
        price = new Price();
        Session session = conn.getConnection();
        if (session == null ) {
            throw new IllegalArgumentException("Could not connect to Cassandra");
        }

        String cqlStatement = "SELECT * FROM price where id=?";
        for (Row row : session.execute(cqlStatement, id)) {
            price.setCurrency_code(row.getString("currency_code"));
            price.setValue(row.getDouble("value"));
        }
        return price;
    }
    public void setPrice(int id, Double new_price) {
        Session session = conn.getConnection();
        if (session == null ) {
            throw new IllegalArgumentException("Could not connect to Cassandra");
        }

        SimpleStatement cqlStatement = new SimpleStatement("UPDATE price SET value=? WHERE id=?",new_price, id );
        session.execute(cqlStatement);
    }
}
