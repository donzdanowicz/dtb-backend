package com.dtb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DbManager {

    INSTANCE;

    private Connection conn;

    DbManager() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "dtbuser");
        connectionProps.put("password", "dtbpassword");
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dtb?serverTimezone=Europe/Warsaw&useSSL=False" +
                            "&allowPublicKeyRetrieval=true",
                    connectionProps);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DbManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return conn;
    }
}
