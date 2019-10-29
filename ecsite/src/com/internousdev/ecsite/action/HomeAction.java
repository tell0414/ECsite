package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		String result = "login";
//		login.jspに飛ぶ
		if (session.containsKey("login_user_id")) {

			// login_user_idに値が入って入れば

			BuyItemDAO buyItemDAO = new BuyItemDAO();

//			BuyItemDAOをこのクラスにコピー

			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//			buyItemDAOクラスのgetBuyItemInfo()を実行した後のbuyItemDTOをコピー

			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
//			buyItemDTOに入れたそれぞれの値をセッションに入れる
			result = SUCCESS;
//			buyItem.jspに飛ぶ
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
