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
public class Stadium extends Table{
    private Connection con;
    private String dropQuery = "DROP TABLE IF EXSISTS Stadiums";
    private String buildQuery = 
            "CREATE TABLE Stadiums(\n"+
            "name varchar(30),\n"+
            "teamCode ENUM"+teams+",\n"+
            "capacity INT(6),\n"+
            "dome ENUM('Y','N'),\n"+
            "retract ENUM('Y','N'),\n"+
            "city VARCHAR(14),\n"+
            "state CHAR(2),\n"+
            "surface ENUM('Turf', 'Grass'),\n"+
            "opended YEAR NOT NULL,\n"+
            "PRIMARY KEY (Name),\n"+
            "CONSTRAINT stadConst1 FOREIGN KEY (teamCode) REFERENCES Teams ";
    
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
            System.out.println("Stadiums dropped sucessfully");
        }
    }
    
    public String grabQuery(){
        return buildQuery;
    }
}
