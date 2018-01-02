package dbutil;

import java.lang.*;

public class DbLauncher
{
    public static void main(String[] args) {
        String dbms = System.getenv("DBMS");
        if (dbms.equals("MySQL")) {
            System.out.println("... [DbLauncher] Hello. Found MySQL. Launching Now.");
            DbFrontend dbf = null;
            dbf = new DbFrontend();           
            dbf.executeMySql();
        } else {
            System.out.println("[DbLauncher] Environment Variable \"DBMS\" is invalid or not found!");
        }

        System.out.println("... [DbLauncher] Process Complete. Good-bye.");

        //DbFrontend.myLambdaTest();
    }

} // end class DbLauncher