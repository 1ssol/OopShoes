package com.cart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.CartDAO;
import com.cart.dto.CartDTO;

import controller.CommandAction;

public class CartListService implements CommandAction {

	@Override 
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("cart list service1");
		System.out.println(request.getParameter("mid"));
		
		//파라메터값
		String mid = request.getParameter("mid");
		
		Map<String, String>map=new HashMap<>();
		map.put("mid", mid);
		
		CartDAO dao = new CartDAO();
		List<CartDTO> list = dao.getCartList(map);
		
		request.setAttribute("list", list);
		request.setAttribute("mid", mid);
		
		return "cart/cart.jsp";

	}
}
