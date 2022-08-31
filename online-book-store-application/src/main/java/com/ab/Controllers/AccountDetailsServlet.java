package com.ab.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.AccountDAO;
import com.ab.daos.AccountDAOImpl;
import com.ab.models.Customer;
import com.ab.services.AccountService;
import com.ab.services.AccountServiceImpl;

/**
 * Servlet implementation class AccountDetailsServlet
 */
@WebServlet("/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AccountDAO dao = new AccountDAOImpl();
		
		AccountService accountService = new AccountServiceImpl(dao);
		
		String email = request.getParameter("email");
		
		 Customer customer = accountService.viewAccountDetails(email);
		 
		  //created a session
			HttpSession session =request.getSession(true);
			session.setAttribute("customer", customer);
			response.sendRedirect("account_details.jsp");
		
	}

}
