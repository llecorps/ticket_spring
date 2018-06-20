package org.example.demo.ticket.consumer.impl.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by esspressoh on 05.06.18.
 */
public class BasicDataSourceDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            BasicDataSource bds = DataSource.getInstance().getBds();
            connection = bds.getConnection();
            statement = connection
                    .prepareStatement("SELECT * FROM public.statut");
            resultSet = statement.executeQuery();
            System.out
                    .println("Id, Libelle");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + ", "
                             + resultSet.getString("libelle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
