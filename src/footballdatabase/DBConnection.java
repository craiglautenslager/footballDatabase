/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballdatabase;

import java.sql.*;

public class DBConnection {
    final static String user = "cpl3407";
    final static String password = "Apple123";
    final static String db = "cpl3407";
    final static String jdbc = "jdbc:mysql://localhost:3306/"+db+"?user="+user+"&password="+password;
    private Connection con;
    
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println("Faild to load driver");
        }
    }
    
    public Connection connect(){
        try{
            this.con = DriverManager.getConnection(jdbc);
            
        }
        catch(Exception e){
            System.out.println("Failed to Establish Connection");
            return null;
        }
        
        return this.con;
    }
    
    public void Disconnect() throws SQLException{
        con.close();
    }
}
