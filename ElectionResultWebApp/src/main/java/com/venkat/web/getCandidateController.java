package com.venkat.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.venkat.web.model.Election;
import com.venkat.web.dao.EDaoImpl;

/**
 * Servlet implementation class getCandidateController
 */
public class getCandidateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCandidateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String candidate = request.getParameter("candidate");
		
		//ElectionDao dao = new ElectionDao();
		//Election e1 = dao.getGenderCount(gender);
		
		EDaoImpl edao = new EDaoImpl();
		Election e1 = edao.fetchCandidateDetails(candidate);
		
		
		request.getSession().setAttribute("candidate_details", e1.getDetails());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Candidate.jsp");
		
		rd.forward(request, response);
		
	}

}
