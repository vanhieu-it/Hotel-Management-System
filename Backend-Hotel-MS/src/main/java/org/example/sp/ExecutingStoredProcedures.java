package org.example.sp;

import org.hibernate.StaleObjectStateException;
import org.example.util.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecutingStoredProcedures {

  private final static String ROOM_CLASS_PRICE = "GIA";

  public static void SpCapNhapPhong(String oldRoomCode, Integer roomClassId,
      String description,
      Integer roomStatusId,
      String newRoomCode) {

    try (
        Connection conn = DatabaseConnection.connection();
        CallableStatement statement = conn.prepareCall("{call SP_CAPNHATPHONG(?,?,?,?,?)}");
    ) {
      statement.setString(1, oldRoomCode);
      statement.setString(2, roomClassId.toString());
      statement.setString(3, description);
      statement.setString(4, roomStatusId.toString());
      statement.setString(5, newRoomCode);
      statement.execute();
      statement.close();

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public static Long SpLayGiaHangHienTai(Integer roomClassId) {
    Long price = 0L;
    try (
        Connection conn = DatabaseConnection.connection();
        CallableStatement statement = conn.prepareCall("{call SP_LAY_GIA_HANG_HIEN_TAI(?)}");
    ) {
      statement.setString(1, roomClassId.toString());
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        price = resultSet.getLong(1);
      }
      statement.close();
      resultSet.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    } catch (StaleObjectStateException t) {

    }
    return price;
  }

}
