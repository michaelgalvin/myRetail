package com.example.myRetail.model.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Makes a connection to Cassandra keyspace
* */
public class CassandraConnection {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public Session getConnection() {
        String serverIP = "127.0.0.1";
        String keyspace = "targetdb";

        Cluster cluster = Cluster.builder()
                .addContactPoints(serverIP)
                .build();
        Session session = cluster.connect(keyspace);
        logger.info("Successfully made connection to Cassandra keyspace");
        return session;
    }
}
