package org.example.util;

import org.example.exception.BadRequestException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {



  public static Connection connection() {
    String dbURL = "jdbc:sqlserver://localhost:1433;database=QLKS";
    String user = "sa";
    String password = "123";
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(dbURL, user, password);
    } catch (SQLException e) {
      throw new BadRequestException("sql-can-not-connect");
    }

    return connection;
  }

}
