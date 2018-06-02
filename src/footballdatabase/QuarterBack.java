/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballdatabase;
import java.sql.*;

public class QuarterBack extends Player{
    
    private String buildQuery = 
            "CREATE TABLE QuarterBacks (\n "+
            "name VARCHAR(30) ,\n "+
            "teamCode ENUM"+teams+" NOT NULL DEFAULT 'FA',\n "+
            "position ENUM"+pos+" NOT NULL DEFAULT 'QB',\n "+
            "number INT(2) NOT NULL DEFAULT '0',\n "+
            "height INT(3) NOT NULL,\n "+
            "weight INT(3) NOT NULL,\n "+
            "passYds INT(5) NOT NULL DEFAULT '0',\n "+
            "rushYds INT(5) NOT NULL DEFAULT '0',\n "+
            "Ints INT(3) NOT NULL DEFAULT '0',\n "+
            "Sacks INT(3) NOT NULL DEFAULT '0',\n "+
            "PRIMARY KEY(name),\n "+
            "CHECK (height > 175 AND height < 210),"+
            "CHECK (weight > 160 AND weight < 400),"+
            "CONSTRAINT qbConst FOREIGN KEY (teamCode) REFERENCES Teams (teamCode)"+
            ") ENGINE=InnoDB;";
    
    private String dropQuery = "DROP TABLE IF EXISTS QuarterBacks;";
    
    private Connection con;

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
            System.out.println("Quarterbacks dropped sucessfully");
        }
    }
    
    public void newPlayer(){
        
    }
    
    public void updatePlayer(){
        
    }
    
    public String grabQuery(){
        return this.buildQuery;
    }
}
