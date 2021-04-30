package oracle.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	String oracleDriver = "oracle.jdbc.driver.OracleDriver";
	String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public DbConnect()
	{
		try {
			Class.forName(oracleDriver);
			//System.out.println("����Ŭ ����̹� �˻� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹� �˻� ����:" + e.getMessage());
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(oracleUrl, "angel", "a1234");
			//System.out.println("����Ŭ ���� ���� ����");
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����:" + e.getMessage());
		}
		return conn;
	}
	
	//db close
	public void dbclose(Statement stmt, Connection conn)
	{
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {}
	}
	
	public void dbclose(ResultSet rs,Statement stmt, Connection conn)
	{
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {}
	}
	public void dbclose(PreparedStatement pstmt, Connection conn)
	{
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {}
	}
	public void dbclose(ResultSet rs,PreparedStatement pstmt, Connection conn)
	{
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {}
	}
	public void dbclose(CallableStatement cstmt, Connection conn)
	{
		try {
			if(cstmt!=null)cstmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {}
	}
	public void dbclose(ResultSet rs,CallableStatement cstmt, Connection conn)
	{
		try {
			if(rs!=null)rs.close();
			if(cstmt!=null)cstmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {}
	}
	
	
	
}
