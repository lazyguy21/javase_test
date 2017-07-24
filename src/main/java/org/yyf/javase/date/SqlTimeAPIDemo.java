package org.yyf.javase.date;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by tobi on 2017/7/21.
 */
public class SqlTimeAPIDemo {
  /**
   * 虽然存了UTC毫秒，但是toString只会返回yyyy-mm-dd，对应着数据比如mysql的date类型
   */
  @Test
  public void t(){
    Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    System.out.println(sqlDate);
  }

  /**
   * 虽然存了UTC毫秒，但是toString只会返回HH:mm:ss，对应着数据比如mysql的time类型
   * @throws Exception
   */
  @Test
  public void testTime() throws Exception {
    Date date = new Date();
    Time time = new Time(date.getTime());
    System.out.println(time);
  }

  @Test
  public void testDateTime() throws Exception {

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    System.out.println(timestamp);
  }

  @Test
  public void testJDBC() throws Exception {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "root";
    Connection conn = null;
    try {
      Class.forName(driver); //classLoader,加载对应驱动
      conn = (Connection) DriverManager.getConnection(url, username, password);
      PreparedStatement stmt = conn.prepareStatement("insert into date_test(date,time,datetime,TIMESTAMP) values (?,?,?,?)");


      long date = System.currentTimeMillis();
      stmt.setDate(1,new java.sql.Date(date));
      System.out.println();
      stmt.setTime(2,new java.sql.Time(date));
      Timestamp x = new Timestamp(date);
      System.out.println(x);
      stmt.setTimestamp(3, x);

      stmt.setTimestamp(4, x);

      stmt.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void testquery() throws Exception {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "root";
    Connection conn = null;
    try {
      Class.forName(driver); //classLoader,加载对应驱动
      conn = (Connection) DriverManager.getConnection(url, username, password);
      PreparedStatement pstmt = conn.prepareStatement("select * from date_test");
      ResultSet rs = pstmt.executeQuery();
      rs.next();
      java.sql.Date date = rs.getDate(2);
      System.out.println(date);
      Date date1 = new Date(date.getTime());
      System.out.println(date1);
      Timestamp timestamp = rs.getTimestamp(4);

      System.out.println(timestamp);
      int col = rs.getMetaData().getColumnCount();
      System.out.println("============================");
      while (rs.next()) {
        for (int i = 1; i <= col; i++) {
          System.out.print(rs.getString(i) + "\t");
          if ((i == 2) && (rs.getString(i).length() < 8)) {
            System.out.print("\t");
          }
        }
        System.out.println("");
      }
      System.out.println("============================");

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
