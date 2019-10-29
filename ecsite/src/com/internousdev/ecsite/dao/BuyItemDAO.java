package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConector;

public class BuyItemDAO {
	public BuyItemDTO getBuyItemInfo(){
		DBConector db=new DBConector();
//		DBConecorをインスタンス化してこのクラスにコピー
		Connection con=db.getConnection();
//		箱（con）に情報(db)を入れる

		BuyItemDTO buyItemDTO=new BuyItemDTO();
//		buyItemDTOをインスタンス化してこのクラスにコピー

		String sql="SELECT id,item_name,item_price "
				+ "FROM item_info_transaction";
//		item_info_transactionの中のid,item_name,item_priceを取り出すためのsql文

		try{
			PreparedStatement ps=con.prepareStatement(sql);
//			文字列であるsql文をコンパイルするためのインターフェイス
			ResultSet rs=ps.executeQuery();
//			sql文を実行し、rsに値を入れる
			if(rs.next()){
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
//				それぞれの値をString型に変換して格納
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}

}
