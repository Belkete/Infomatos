/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outilgestionmateriel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FROSINI
 */
public class ConnexionSQL {
    // JDBC driver nom et database URL 
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost/infomatos";
    
    //  Database identifiant
    static final String USER = "root";
    static final String PASS = "";
    public static Connection conn;
    
    public static void initConn(){
        if(ConnexionSQL.conn == null){
           try {
            //JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");

            //Ouvrir une connection
            System.out.println("Connecting to a selected database...");
            ConnexionSQL.conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/infomatos", "root", "");
            System.out.println("Connected database successfully...");
           
            } catch (Exception e) {
                //Handle errors for Class.forName
                ConnexionSQL.conn = null;
                e.printStackTrace();
            }    
        }
        

    }
            
    public static void finalise() throws SQLException{
        if(conn != null){
            ConnexionSQL.conn.close();
            conn = null;
        }
    }
}
