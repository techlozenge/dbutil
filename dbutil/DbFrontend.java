package dbutil;

import java.sql.*;
import java.util.Properties;

public class DbFrontend
{
  DbFrontend() { }  // empty constructor

  /**** Begin MySQL Methods Section ****/

  public void executeMySql() {
    Connection conn = null;
    DbUtil dbms = null;
    Statement st;
    
    try {
      // get MySQL connection from DB utility control...
      System.out.println("... [DbFrontend] Asking politely for MySQL Connection");
      dbms = new DbUtil();
      // getMySqlConnection throws SQLException
      conn = dbms.getMySqlConnection();

      // create the statement with the connection and define the query...
      System.out.println("... [DbFrontend] Creating Statement & Query");
      st = conn.createStatement();
      String query = "SELECT * FROM student ORDER BY gpa DESC";

      // execute the query...
      System.out.println("... [DbFrontend] Executing Query");
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the resultset & obtain the columns...
      while (rs.next())
      {
        int student_id = rs.getInt("student_id");
        String first_name = rs.getString("first_name");
        String last_name = rs.getString("last_name");
        Date start_date = rs.getDate("start_date");
        int gpa = rs.getInt("gpa");
        
        // print the row data (the "-" causes left justification)...
        System.out.format("%-4s %-10s %-10s %-15s %-10s\n", student_id, first_name, last_name, start_date, gpa);
      }
      System.out.println("... [DbFrontend] Closing Query Statement & Connection");
      st.close();
      conn.close();
    }
    // this is the parent of the SQLException so SQLexception will never be used
    catch (Exception e) {
      System.err.println("JavaMysqlSelectExample encountered an exception");
      System.err.println(e.getMessage());
    }
  }
    /**** End MySQL Methods Section ****/
  
}   // end DbFrontend class