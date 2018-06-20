package com.hhit.controller;


import com.hhit.dao.TestDAO;
import com.hhit.dao.factory.DaoFactory;
import com.hhit.model.testpaper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class TestSubmit
 */
@WebServlet("/TestSubmit")
public class TestSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());		 
		//System.out.println("t84=" + request.getParameter("t84"));
		request.setCharacterEncoding("UTF-8");
		TestDAO tdao = DaoFactory.gettestdao();
		List<testpaper> list = tdao.findanswer();
		int score = 0;
		String answer = " ";
		for (int i = 1; i <= list.size(); i++)  {
			answer = request.getParameter("t" + i);
			//System.out.println("answer" + i + "=" + answer);
			if (answer != null) {
				if (answer.equals(list.get(i - 1).getAnswer()))
					score += 2;
			}				
		}
		HttpSession session = request.getSession();
		tdao.savescore(session.getAttribute("userid").toString(), score);
		request.setAttribute("score", score);
		//request.setAttribute("aTest", "alearlyTest");
		request.getRequestDispatcher("jsp/stuMenu.jsp").forward(request, response);
		//System.out.println(score);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
