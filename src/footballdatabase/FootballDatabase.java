package footballdatabase;
import java.sql.*;


public class FootballDatabase {
    
    
    public static void main(String[] args) throws SQLException {
        DBConnection DBCon = new DBConnection();
        Connection con = DBCon.connect();
        Team TM = new Team();
        QuarterBack QB = new QuarterBack();
        
        TM.dropTable();
        TM.buildTable(TM.grabQuery());
        QB.dropTable();
        QB.buildTable(QB.grabQuery());
        
        
    }
    
    
    
}
