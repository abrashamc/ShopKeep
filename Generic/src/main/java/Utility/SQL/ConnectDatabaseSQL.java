package Utility.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abra on 4/12/17.
 */
public class ConnectDatabaseSQL {     //This class is used to connect to mySQL Database using JDBC to retrieve credentials to log in to the ShopKeep BackOffice

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs=null;


    public void connectToDBFramework() throws ClassNotFoundException, SQLException {        //This method is used to connect to the database using JDBC
        String myDriver = "com.mysql.jdbc.Driver";
        Class.forName(myDriver);
        String URL = "jdbc:mysql://localhost/web_automation?useSSL=false";                  //'web_automation' is the database name
        String userN = "root";
        String passW = "root";
        conn = DriverManager.getConnection(URL, userN, passW);
    }


    public List<String> retrieveDataFromTable(String tableName, String colName) {           //This method is used to retrieve data from the Database by executing queries.
        List<String> list = null;
        try {
            connectToDBFramework();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select "+colName+" from " +tableName);             //This SQL query can be used to retrieve data from a certain table
            list = new ArrayList<String>();
            while (rs.next()) {
                list.add(rs.getString(colName));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return list;
    }
}
