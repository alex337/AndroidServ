package com.hhit.controller;

import com.hhit.dao.factory.DaoFactory;
import com.hhit.model.choicequestion;
import com.hhit.model.fillquestion;
import com.hhit.dao.TestDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class EnterTest
 */
@WebServlet("/EnterTest")
public class EnterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		TestDAO tdao = DaoFactory.gettestdao();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime = tdao.searchStime();
		System.out.println("时间"+startTime);
		if (startTime.equals("null")) {
			System.out.println("ERROR.Don't set the test time");
			return;
		}
		try {
			Date stime = sdf.parse(startTime);
			int testMinute = Integer.parseInt(tdao.searchTime());
			Date ntime = new Date();
			System.out.println("现在时间"+ntime);
			Calendar rightNow = Calendar.getInstance();
	        rightNow.setTime(stime);
	        rightNow.add(Calendar.MINUTE,testMinute);
	        Date sTime = rightNow.getTime(); //考试结束时间	
					
	        if (ntime.before(sTime)) {
	        	List<choicequestion> list1 = tdao.findchoiceques();
				for (int i = 0; i < list1.size(); i++) {
					System.out.println("list"+list1.get(i));
				}
				System.out.println("1111");
				StringBuffer sb = new StringBuffer();
	        	for (int i = 1; i <= list1.size(); i++) {	        		
	        		if (i == 1)
	        			sb.append("<div class=\"con\" style=\"display: block;\">");
	        		else if (i % 5 == 1) {
	        			sb.append("<div class=\"con\" style=\"display: none;\">");
	        		}
	        		sb.append("<div class=\"t\"><div class=\"title\"><label>" + i + ".");
	        		sb.append(list1.get(i - 1).getC_question());
	        		sb.append("</label></div>");
	        		sb.append("<div class=\"answer\"><label><input name=\"t" + i + "\" type=\"radio\" value=\"A\" />");
	        		sb.append(list1.get(i - 1).getC_choiceA());
	        		sb.append("</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input name=\"t" + i + "\" type=\"radio\" value=\"B\" />");
	        		sb.append(list1.get(i - 1).getC_choiceB());
	        		sb.append("</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input name=\"t" + i + "\" type=\"radio\" value=\"C\" />");
	        		sb.append(list1.get(i - 1).getC_choiceC());
	        		sb.append("</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input name=\"t" + i + "\" type=\"radio\" value=\"D\" />");
	        		sb.append(list1.get(i - 1).getC_choiceD());
	        		sb.append("</label></div></div>");
	        		if (i % 5 == 0) {
	        			sb.append("</div>");
	        		}
	        	}
	        	List<fillquestion> list2 = tdao.findfillques();
	        	for (int i = 51; i <= list2.size() + 50; i++) {
	        		if (i % 5 == 1) {
	        			sb.append("<div class=\"con\" style=\"display: none;\">");
	        		}
	        		sb.append("<div class=\"t\"><div class=\"title\"><label>题目" + i + "：");
	        		sb.append(list2.get(i - 51).getF_question());
	        		sb.append("</label></div>");
	        		sb.append("<div class=\"answer\"><label><input name=\"t" + i + "\" type=\"text\" value=\"\"/> </label></div></div>");
	        		if (i % 5 == 0) {
	        			sb.append("</div>");
	        		}
	        	}
	        	//System.out.println(sb);
	        	request.setAttribute("sb", sb);
	        	//考试结束时间
	        	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String endTime;
				endTime = df.format(sTime);
				HttpSession session = request.getSession();
				session.setAttribute("endTime", endTime);
				
	        	request.getRequestDispatcher("jsp/stuTest.jsp").forward(request, response);
	        	//response.sendRedirect("./jsp/stuTest.jsp");
	        } else {
	        	request.setAttribute("overTest", "over");
	        	request.getRequestDispatcher("jsp/stuMenu.jsp").forward(request, response);
	        	System.out.println("考试时间已过");	    
	        }	        	
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//response.sendRedirect("./jsp/stuTest.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
