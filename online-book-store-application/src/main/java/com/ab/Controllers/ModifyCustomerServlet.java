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
import com.ab.utilities.BSFactory;
import com.ab.utilities.DataValidation;

/**
 * Servlet implementation class ModifyCustomerServlet
 */
@WebServlet("/ModifyCustomerServlet")
public class ModifyCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String customerEmail = request.getParameter("customerEmail");
		String customerpassword = request.getParameter("customerpassword");
		
		String encryptedPassword = DataValidation.encryptPassword(customerpassword);
		
		Customer customer = BSFactory.getCustomer(firstName, lastName, customerEmail, encryptedPassword);
		
		AccountDAO dao = new AccountDAOImpl();
		
		AccountService accountService = new AccountServiceImpl(dao);
		
		Customer modifyCustomer = accountService.modifyAccountDetails(customer);
		
		//created a session
		HttpSession session =request.getSession(true);
		session.setAttribute("modifyCustomer", modifyCustomer);
		response.sendRedirect("modify_customer.jsp");
		
	}

}
