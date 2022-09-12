package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.MyConnection;
import com.pojo.User;

public class UserImpl {
	public boolean register(User user) {
		boolean state=false;
		try(Connection conn=MyConnection.connect()){		
			String sql="insert into user values (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getAge());
			pstmt.setLong(3, user.getContact());
			pstmt.setString(4, user.getEmailId());
			pstmt.setString(5, user.getUsername());
			pstmt.setString(6, user.getPassword());
			pstmt.setString(7, user.getGender());
			pstmt.setString(8, user.getLocation());
			int no=pstmt.executeUpdate();
			System.out.println(no);
			if(no>0)
				state=true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public String login (String uname, String pass) {
		String name=null;
		try(Connection conn=MyConnection.connect()){
			
		String sql="select *  from user where username=? and password=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,uname);
		pstmt.setString(2,pass);	
		System.out.println(pstmt);
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()) {
			name=rs.getString("first_name");
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
