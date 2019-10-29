package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConector;

public class MyPageDAO {
	public ArrayList<MyPageDTO>getMyPageUserInfo
	(String item_transaction_id,String user_master_id)throws SQLException{
		DBConector db=new DBConector();
		Connection con=db.getConnection();
		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();

		String sql="SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date "
				+ "FROM user_buy_item_transaction ubit "
				+ "LEFT JOIN item_info_transaction iit "
//				二行目と三行目を結合
				+ "ON ubit.item_transaction_id=iit.id "
//				左辺と右辺のIDが同じなら結合
				+ "WHERE ubit.item_transaction_id=? AND ubit.user_master_id=? "
//				ps.setStringで与えられた抽出するための条件
				+ "ORDER BY insert_date DESC";
//				日付(insert_date)を基準にして降順

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs=ps.executeQuery();
//			sql文を実行

			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
//				MypageDTOにそれぞれの値を格納
				myPageDTO.add(dto);
//				myPageDTOを引数として使えるようにdtoをmyPageDTOに入れている
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return myPageDTO;
	}

public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{

	DBConector db=new DBConector();
	Connection con=db.getConnection();

	String sql="DELETE FROM user_buy_item_transaction "
//			デリートするテーブルを選択
			+ "WHERE item_transaction_id=? AND user_master_id=?";
//			ps.setStringで与えられた値と合うIDを選択
	PreparedStatement ps;
	int result=0;
	try{
		ps=con.prepareStatement(sql);
		ps.setString(1, item_transaction_id);
		ps.setString(2, user_master_id);
		result=ps.executeUpdate();
//		データベースで処理した行数が帰ってくる
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		con.close();
	}
	return result;


}

}
