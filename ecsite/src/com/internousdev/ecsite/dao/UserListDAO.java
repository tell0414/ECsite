package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConector;

public class UserListDAO {
	public ArrayList<UserListDTO> getUserListInfo() throws SQLException{
		DBConector db=new DBConector();
		Connection con=db.getConnection();
		ArrayList<UserListDTO> userListDTO=new ArrayList<UserListDTO>();

		String sql="SELECT * FROM login_user_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				UserListDTO dto=new UserListDTO();
				dto.setId(rs.getString("login_id"));
				dto.setPass(rs.getString("login_pass"));
				dto.setName(rs.getString("user_name"));
				dto.setDate(rs.getString("insert_date"));
				userListDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return userListDTO;
	}

}
