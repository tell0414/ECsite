package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {



	public void createUser(String loginUserId,String loginUserPassword,String userName)throws SQLException{
		DBConector db=new DBConector();
		Connection con=db.getConnection();
		DateUtil dateUtil=new DateUtil();

		String sql="INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?)";
//		login_user_transactionに登録(insert)するためのsql文
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, dateUtil.getDate());
//			登録した年月日時間を出力する

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
