package com.hs;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date: 1/25/17
 */
public class MySQLSample {


    public static void main(String[] args) throws Exception {
        Driver dr = HSDriverManager.loadDriver("jdbc:hs:alias1");

        Properties prop = new Properties();
        prop.setProperty("user", "hsjdbc");
        prop.setProperty("password", "123456");

        Connection con = dr.connect("jdbc:mysql://localhost:3306/jdbc_sample", prop);
        //PreparedStatement ps = con.prepareStatement("select * from identities");
        PreparedStatement ps = con.prepareStatement("select * from ABCD");

        ResultSet r = ps.executeQuery();

        while(r.next()){
            System.out.println(r.getString("email") + " " + r.getString("first_name") + " " + r.getString("last_name"));
        }

    }
}
