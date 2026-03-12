package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class geekUserDao {
	private static String url="jdbc:mysql://localhost:3306/gfg";
	private static String username="root";
	private static String password="DMSA@2005";
	//method to get Connection 
	public static Connection getConnection(){
		Connection  con =null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			if (con != null) {
	            System.out.println("✅ SUCCESS: Database connected successfully!");
	        }
	    } catch(Exception e) {
	        System.out.println("❌ FAILURE: Connection failed!");
	        e.printStackTrace(); // This prints the EXACT error (like wrong password)
	    }
	    return con;
		
	}
	//save new user
	public static int saveuser(geekUsers e) {
		int Status=0;
		try(Connection con = getConnection()){
			PreparedStatement ps = con.prepareStatement("insert into geekusers(gName,numberOfPosts,tech) values(?,?,?)");
			ps.setString(1,e.getBookname());
			ps.setInt(2, e.getNumberOfbooks());
			ps.setString(3,e.getAuthor());
			  Status = ps.executeUpdate();
		}catch(Exception se) {
			se.printStackTrace();
		}
		return Status;
	}
	//read all the users DAO
	public static List<geekUsers> getAllUsers(){
		List<geekUsers> list = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement ps = con.prepareStatement("SELECT * from geekUsers");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				geekUsers e = new geekUsers();
				e.setBookId(rs.getInt(1));
				e.setBookname(rs.getString(2));
				e.setNumberOfbooks(rs.getInt(3));
				e.setAuthor(rs.getString(4));
				list.add(e);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//get user by id
	public static geekUsers getGeekUserById(int id) {
		geekUsers e= new geekUsers();
		try(Connection con=getConnection()){
			PreparedStatement pt= con.prepareStatement("SELECT * from geekUsers where userId=?");
			pt.setInt(1,id);
			ResultSet rs= pt.executeQuery();
			while(rs.next()) {
				e.setBookId(rs.getInt("userId"));
				e.setBookname(rs.getString(2));
				e.setNumberOfbooks(rs.getInt(3));
				e.setAuthor(rs.getString(4));
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	//update user 
	public static int updateUser(geekUsers e) {
		int status=0;
		try(Connection con=getConnection()){
			PreparedStatement pt= con.prepareStatement("update geekUsers set gName=?,numberOfPosts=?,tech=? where userId=?");
			pt.setString(1,e.getBookname());
			pt.setInt(2, e.getNumberOfbooks());
			pt.setString(3, e.getAuthor());
			pt.setInt(4, e.getBookId());
			status=pt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	//delete user
	public static void deleteuser(int id) {
		try(Connection con =getConnection()){
			PreparedStatement pt= con.prepareStatement("DELETE from geekUsers where userId=?");
			pt.setInt(1,id);
			pt.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
