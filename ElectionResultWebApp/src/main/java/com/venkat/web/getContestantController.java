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
 * Servlet implementation class getContestantController
 */
public class getContestantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getContestantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int Y = Integer.parseInt(request.getParameter("Year"));
		String S = request.getParameter("State");
		String P = request.getParameter("Party");
		
		
		EDaoImpl edao = new EDaoImpl();
		Election e1 = edao.fetchContestantDetails(Y, S, P);
		
		request.getSession().setAttribute("candidate_contestant", e1.getContestant());
		
		//System.out.println(e1.getContestant());
		
		RequestDispatcher rd = request.getRequestDispatcher("Contestant.jsp");
		rd.forward(request, response);
		
	}

}
