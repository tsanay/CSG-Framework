package skynet.beans;

import io.codearte.jfairy.producer.person.Person;
import org.springframework.stereotype.Component;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DatabaseConnection {

    java.sql.Connection conn;
    ResultSet result;
    PreparedStatement pst;

    public DatabaseConnection(){
        try {
            String url="jdbc:sqlserver://10.80.0.82:1433;"+ "databaseName=facilityDB; integratedSecurity=false;";
            String username = "hiddenserver";
            String password = "H1ddenP30pl3";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet databaseConnection(){
        //java.sql.Connection conn= null;
        ResultSet result = null;

        try {
            System.out.println(conn.isClosed());

            System.out.println("Data");
            String query = "SELECT * FROM alertData";
            PreparedStatement pst =  conn.prepareStatement(query);

            result =  pst.executeQuery();
            while(result.next()){
                System.out.println(result.getString(1)+" "+result.getString(2));
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean validateInsertResident(String firstName, String lastName) throws SQLException {
        String query = "SELECT * FROM residents WHERE firstName =\"+firstName+\" AND lastName = \"+lastName+\" ";
        pst = conn.prepareStatement(query);
        return pst.execute();
    }

    public ResultSet getLastResident() throws SQLException {
        String query = "SELECT TOP 1 firstName, lastName FROM residents ORDER BY id DESC ";
        pst = conn.prepareStatement(query);
        result = pst.executeQuery();
        return result;
    }
}
