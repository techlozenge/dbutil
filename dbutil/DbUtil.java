package dbutil;

import java.sql.*;
import java.util.Properties;

public class DbUtil {

    DbUtil() { }  // empty constructor
    
    /* Common DBMS Propteries */
    private Connection conn;
    private Properties connProps;

    /* DBMS=MySQL Access used by getMySqlConnection() */
    private String userName = "root";
    private String passwd = "C0ldiron";
    private String mySqlDriver = "com.mysql.jdbc.Driver";
    private String mySqlUrl = "jdbc:mysql://localhost:3306/student_api?autoReconnect=true&useSSL=false";
    
    // caller must handle SQLException!
    public Connection getMySqlConnection() throws SQLException {
        System.out.println("... [DbUtil] Attempting to obtain MySQL connection");
        this.conn = null;
        this.connProps = new Properties();
        this.connProps.put("user", userName);
        this.connProps.put("password", passwd);
        try {      
            Class.forName(mySqlDriver);
            this.conn = DriverManager.getConnection(mySqlUrl, connProps);
        } 
        // lazy lazy lazy but okay for now...
        catch (Exception e)
        {
            System.err.println("getConnection encountered an exception");
            System.err.println(e.getMessage());
        }
        System.out.println("... [DbUtil] Returning with MySQL connection");
        return this.conn;
    }

} // end DbUtil class