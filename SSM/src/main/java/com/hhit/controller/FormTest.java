package com.hhit.controller;


import com.hhit.dao.TestDAO;
import com.hhit.dao.factory.DaoFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Servlet implementation class FormTest
 */
@WebServlet("/FormTest")
public class FormTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String dateTime = request.getParameter("Datetime");
		String timeLimit = request.getParameter("Timelimit");
		TestDAO tdao = DaoFactory.gettestdao();
		//清空试卷表、时间表、成绩表
		tdao.deletetestpaper();
		tdao.deletetime();
		tdao.deletescore();
		
		tdao.savetime(dateTime, timeLimit);
		List list = new ArrayList();
	    Random r = new Random();
	    int nums = 20;
	    int end = tdao.searchallchoice("");
	    int start = 1;
	    int num = 1;
	    while (list.size() != nums) {
	        num = r.nextInt(end-start) + start;
	        if(!list.contains(num)){
	            list.add(num);
	        }
	    }
	    //生成选择题
	    tdao.savechoice(list);
	    
	    list.clear();
	    end = tdao.searchallfill("");
	    while (list.size() != nums) {
	        num = r.nextInt(end-start) + start;
	        if(!list.contains(num)){
	            list.add(num);
	        }
	    }
	    //生成填空题
	    tdao.savefill(list);

		request.getRequestDispatcher("./ShowTest").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
