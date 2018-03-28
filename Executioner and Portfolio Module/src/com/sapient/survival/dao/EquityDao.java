package com.sapient.survival.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class EquityDao { 
	static final String DB_URL="jdbc:mysql://dlufflab103/ets";

static final String USER = "root";
static final String PASS = "root" ;
private static Connection conn = null;
public EquityDao(){
}

 public static  Connection getConnection() {
try{
    // Register JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    // Open a connection
  conn = DriverManager.getConnection(DB_URL,USER,PASS);

    // Execute SQL query
}
    
     catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
     }

 return conn;
 }



public void closeConn(Connection conn) {
	if (conn != null){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
}