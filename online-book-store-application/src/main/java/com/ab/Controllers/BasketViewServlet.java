package com.ab.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.BasketDAO;
import com.ab.models.Book;
import com.ab.services.BasketService;
import com.ab.utilities.BSFactory;

/**
 * Servlet implementation class BasketViewServlet
 */
@WebServlet("/BasketViewServlet")
public class BasketViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    BasketDAO dao = BSFactory.getBasketDAO();
			BasketService basketService = BSFactory.getBasketService(dao);
	             
			String book = request.getParameter("books"); //retrieve booktitle in hidden text box 
			//Book addBook = basketService.addBook(book);
						
			List<String> bList = new ArrayList<>();
			
			for(String b: bList) {
				
				bList.add(book);
			}
						
			//created a session
			HttpSession session =request.getSession(true);
			session.setAttribute("bList", bList);
			response.sendRedirect("display_basket.jsp");
	}

	

}
