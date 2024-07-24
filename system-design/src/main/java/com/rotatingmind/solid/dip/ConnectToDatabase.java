package com.rotatingmind.solid.dip;

public class ConnectToDatabase {

    /*public void connect(PostgreSQLJdbcUrl url) {

    }*/
    public void connect(JdbcUrl url) {
        System.out.println("Connect with postgres " + url.get());
    }
}
