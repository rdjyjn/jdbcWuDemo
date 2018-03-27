package com.ruide.wu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ruide.wu.vo.Dept;

public class DBManager {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String user="scott";
	private String password="tiger";
	
	private Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int executeUpdate(String sql){
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		try {
			stmt=conn.prepareStatement(sql);
			int iden=stmt.executeUpdate();
			return iden;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	public List<Dept> executeQuery(String sql){
		Connection conn=getConnection();
		List<Dept> list=new ArrayList<Dept>();
		PreparedStatement stmt=null;
		ResultSet rst=null;
		try {
			stmt=conn.prepareStatement(sql);
			rst=stmt.executeQuery();
			while(rst.next()){
				int deptno=rst.getInt("DEPTNO");
				String dname=rst.getString("DNAME");
				String loc=rst.getString("LOC");
				Dept dept=new Dept(deptno, dname, loc);
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rst.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
