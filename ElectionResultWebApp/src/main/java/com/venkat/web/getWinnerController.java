package com.venkat.web;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.venkat.web.dao.EDaoImpl;
import com.venkat.web.model.Election;

/**
 * Servlet implementation class getWinnerController
 */
public class getWinnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getWinnerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Y = Integer.parseInt(request.getParameter("Year"));
		String S = request.getParameter("State");
		String C = request.getParameter("Constituency");
		
		
		EDaoImpl edao = new EDaoImpl();
		Election e1 = edao.fetchWinnerDetails(Y, S, C);
		
		request.getSession().setAttribute("candidate_winner", e1.getWinner());
		
		//System.out.println(e1.getWinner());
		
		RequestDispatcher rd = request.getRequestDispatcher("Winner.jsp");
		rd.forward(request, response);
	}

}
