package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private MyPageDAO myPageDAO=new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	private String deleteFlg;
//	Mypage.jspで渡された値を入れる
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("login_user_id")){
			return ERROR;
//			値が入っていなければhome.jspに戻る
		}

		if(deleteFlg==null){
//			BuyItemCompleteから来たときはこっち
			String item_transaction_id=session.get("id").toString();
//			idをストレイング型に変換して格納
			String user_master_id=session.get("login_user_id").toString();
//			login_user_idをストレインぐ型に変換して格納
			myPageList=myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
//			myPageDAOのgetMyPageUserInfoに値を渡して戻り値をmyPageListにいれる
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	public void delete() throws SQLException{
//		Mypage.jspで削除ボタンを押されたたら動く
		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();
//		削除したいテーブルがあるIDを選択

		int res=myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);
//		myPageDAOのbuyItemHistoryDeleteに選択したIDをを渡して戻り値をresにいれる

				if(res>0){
					myPageList=null;
					setMessage("商品情報を正しく削除しました。");
				}else if(res==0){
					setMessage("商品情報の削除に失敗しました。");
				}

	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}
	public ArrayList<MyPageDTO>getMyPageList(){
		return this.myPageList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
