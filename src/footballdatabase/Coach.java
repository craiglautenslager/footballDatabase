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
public class Coach extends Table{
    private Connection con;
    private String buildQuery =
            "CREATE TABLE Coaches(\n,"+
            "name VARCHAR(30) NOT NULL,\n"+
            "teamCode ENUM"+teams+" NOT NULL DEFAULT 'FA',\n"+
            "wins int(3) NOT NULL DEFAULT '0',\n"+
            "loses int(3) NOT NULL DEFAULT '0',\n"+
            "PRIMARY KEY (name),\n"+
            "CONSTRAINT coachConst1 FOPREIGN KEY (teamCode) REFERNCES Teams (teamCode)\n"+
            ") ENGINE = InnoDB";
    
    private String dropQuery = "DROP TABLE IF EXISTS Coaches";
    
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
    
}
