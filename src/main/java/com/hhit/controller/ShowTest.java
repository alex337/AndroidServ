package com.hhit.controller;



import com.hhit.dao.TestDAO;
import com.hhit.dao.factory.DaoFactory;
import com.hhit.model.choicequestion;
import com.hhit.model.fillquestion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ShowTest
 */
@WebServlet("/ShowTest")
public class ShowTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		TestDAO tdao = DaoFactory.gettestdao();
		if (tdao.existtime() != 0) {
			StringBuffer sb = new StringBuffer();
			List<choicequestion> list1 = tdao.findchoiceques();
			sb.append("<div class=\"t\"><div class=\"title\"><span>考试开始时间：");
			String time = tdao.searchStime();
			time = time.substring(0, time.length() - 2);
			sb.append(time);
			sb.append("&nbsp;&nbsp;&nbsp;考试时长：");
			sb.append(tdao.searchTime());
			sb.append("分钟</span></div></div>");
			
			for (int i = 0; i < list1.size(); i++) {
				sb.append("<div class=\"t\"><div class=\"title\"><span>");
				sb.append(i + 1 + ".");
				sb.append(list1.get(i).getC_question());
				sb.append("</span></div><div class=\"choice\"><div><span>");
				sb.append(list1.get(i).getC_choiceA());
				sb.append("</span></div><div><span>");
				sb.append(list1.get(i).getC_choiceB());
				sb.append("</span></div><div><span>");
				sb.append(list1.get(i).getC_choiceC());
				sb.append("</span></div><div><span>");
				sb.append(list1.get(i).getC_choiceD());
				sb.append("</span></div></div><div class=\"answer\"><span>答案：");
				sb.append(list1.get(i).getC_answer());
				sb.append("</span></div></div>");
			}
			
			List<fillquestion> list2 = tdao.findfillques();
			for (int i = 0; i < list2.size(); i++) {
				sb.append("<div class=\"t\"><div class=\"title\"><span>");
				sb.append(i + 1 + list1.size() + ".");
				sb.append(list2.get(i).getF_question());
				sb.append("</span></div><div class=\"answer\"><span>答案：");
				sb.append(list2.get(i).getF_answer());
				//System.out.println(list2.get(i).getF_answer());
				sb.append("</span></div></div>");
			}
			request.setAttribute("testInfo", sb);
		} else {
			request.setAttribute("noTest", "noTest");
		}	
		request.getRequestDispatcher("./jsp/testView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
