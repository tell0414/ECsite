package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {
	DBConector db=new DBConector();
	Connection con=db.getConnection();
	DateUtil dateUtil=new DateUtil();

	String sql="INSERT INTO item_info_transaction"
			+ "(item_name,item_price,item_stock) VALUES(?,?,?)";
	public void createItem(String itemName,String itemValue,String itemStock) throws
	SQLException{

		int iV=Integer.parseInt(itemValue);
		int iS=Integer.parseInt(itemStock);

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setInt(2, iV);
			ps.setInt(3, iS);
//			ps.setString(4, dateUtil.getDate());
			ps.execute();


		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}

}
