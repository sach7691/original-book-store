package com.ab.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.BookDAO;
import com.ab.models.Book;
import com.ab.services.BookService;
import com.ab.utilities.BSFactory;

/**
 * Servlet implementation class ReadBookServlet
 */
@WebServlet("/ReadBookServlet")
public class ReadBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    
        BookDAO dao = BSFactory.getBookDAO();
		
		BookService bookService = BSFactory.getBookService(dao);
             
		String title = request.getParameter("bookTitle"); //retrieve booktitle in hidden text box 
		Book readBook = bookService.readBookInformation(title);			
		
		//created a session
		HttpSession session =request.getSession(true);
		session.setAttribute("readBook", readBook);
		response.sendRedirect("read_book.jsp");
	}

}
