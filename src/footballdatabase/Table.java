/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package footballdatabase;
import java.sql.*;

public abstract class Table{
    private Connection con;
    public final static String user = "cpl3407";
    public final static String password = "Apple123";
    public final static String db = "cpl3407";
    public final static String jdbc = "jdbc:mysql://localhost:3306/"+db+"?user="+user+"&password="+password;
    public final static String pos = "('QB', 'HB', 'FB', 'TE', 'WR', 'LT', 'LG',"+
                                    "'C', 'RG', 'RT', 'LE', 'DT', 'RE', 'LOLB',"+
                                    "'MLB', 'ROLB', 'CB', 'SS', 'FS', 'P', 'K')";
    
    public final static String teams = 
            "('SF', 'CHI', 'CIN', 'BUF', 'DEN', 'CLE'"+
            "'ARI', 'LAC', 'KC',  'IND', 'DAL', 'MIA',"+
            "'PHI', 'ATL', 'NYG', 'JAC', 'NYJ', 'DET',"+
            "'GB',  'CAR', 'NE',  'OAK', 'LAR', 'BAL',"+
            "'WAS', 'NO',  'SEA', 'PIT', 'TB',  'HOU',"+
            "'TEN', 'MIN', 'FA')";
    
    public void buildTable(String buildQuery) throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println("Faild to load driver");
        }
        this.con = DriverManager.getConnection(jdbc);
        Statement stat = con.createStatement();
        Boolean success = stat.execute(buildQuery);
        if(!success){
            System.out.println("Table built sucessfully");
        }
        
        stat.close();
        con.close();
    }
    
    public abstract void dropTable() throws SQLException;
    
    
    public abstract String grabQuery();
}
