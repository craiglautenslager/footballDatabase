/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballdatabase;
import java.sql.*;
/**
 *
 * @author Craig
 */
public class Halfback extends Table{
    private Connection con;
    private String dropQuery = "DROP TABLE IF EXISTS Halfback";
    private String buildQuery = "";
    
    public String grabQuery(){
        return buildQuery;
    }
    
    public void dropTable() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println("Faild to load driver");
        }
        
        this.con = DriverManager.getConnection(jdbc);
        Statement stat = con.createStatement();
        Boolean success = stat.execute(this.dropQuery);
        if(!success){
            System.out.println("Coaches dropped sucessfully");
        }
    }
    
    public void newPlayer(){
        
    }
    
    public void updatePlayer(){
        
    }
}
