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
public class Team extends Table{
    private final String dropQuery = "DROP TABLE IF EXISTS Teams";
    private Connection con;
    private String buildQuery = 
            "CREATE TABLE Teams(\n"+
            "name VARCHAR(12),\n"+
            "teamCode ENUM"+teams+",\n"+
            "city VARCHAR(14),\n"+
            "coach VARCHAR(30),\n"+
            "Stadium VARCHAR(30),\n"+
            "PRIMARY KEY (teamCode)"+
            ") ENGINE=InnoDB";

   
    public void dropTable() throws SQLException {
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
            System.out.println("Teams dropped sucessfully");
        }
    }

    public void newPlayer() {
        
    }

    public void updatePlayer() {
        
    }
    
    public String grabQuery(){
        return this.buildQuery;
    }
}
