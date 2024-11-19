package bankmanagment;

import java.sql.*;

public class Connect {

    Connection c;
    Statement s;
    public Connect(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement", "root", "17200506Artur");
            s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
