package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.util.DBConector;
import com.internousdev.ecsite.util.ItemInfoDTO;

public class ItemListDAO {
	public ArrayList<ItemInfoDTO> getItemInfo() throws SQLException{
		DBConector db=new DBConector();
		Connection con=db.getConnection();
		ArrayList<ItemInfoDTO> itemListDTO=new ArrayList<ItemInfoDTO>();

		String sql="SELECT * from item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemInfoDTO dto=new ItemInfoDTO();
				dto.setItemN(rs.getString("item_name"));
				dto.setItemP(rs.getInt("item_price"));
				dto.setItemS(rs.getInt("item_stock"));
				itemListDTO.add(dto);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemListDTO;
	}

}
