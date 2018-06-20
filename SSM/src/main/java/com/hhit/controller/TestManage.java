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
 * Servlet implementation class TestManage
 */
@WebServlet("/TestManage")
public class TestManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestManage() {
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
		int page = Integer.valueOf(request.getParameter("page"));
		String type = request.getParameter("type");
		String keyword = request.getParameter("key");
		request.setAttribute("type", type);
		request.setAttribute("key", keyword);
		request.setAttribute("page", page);
		TestDAO tdao = DaoFactory.gettestdao();
		StringBuffer sb = new StringBuffer();
		if (type.equals("Choice")) {
			List<choicequestion> list = tdao.findtitle(page, "0", keyword);
			sb.append("<table style=\"table-layout:fixed\" class=\"table table-hover table-bordered\">");
			sb.append("<caption>选择题</caption><thead><tr>");
			sb.append("<th>试题ID</th><th>题目</th><th>选项A</th><th>选项B</th><th>选项C</th><th>选项D</th><th>答案</th><th>操作</th></tr></thead>");
			
			for (int i = 0; i < list.size(); i++) {
				sb.append("<tr><td>");
				sb.append(list.get(i).getC_id());
				sb.append("</td><td>");
				sb.append(list.get(i).getC_question());
				sb.append("</td><td>");
				sb.append(list.get(i).getC_choiceA());
				sb.append("</td><td>");
				sb.append(list.get(i).getC_choiceB());
				sb.append("</td><td>");
				sb.append(list.get(i).getC_choiceC());
				sb.append("</td><td>");
				sb.append(list.get(i).getC_choiceD());
				sb.append("</td><td>");
				sb.append(list.get(i).getC_answer());
				sb.append("</td>");
				sb.append("<td><button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal1\" onclick=\"editTest(this)\">修改</button><br/>");
				sb.append("<form action=\"./DeleteServlet?type=Choice&id=" + list.get(i).getC_id() + "&page=" + page + "&key=" + keyword + "\" method=\"post\" onsubmit=\"return checkDelete()\">");
				sb.append("<button class=\"btn btn-primary\" type=\"submit\">删除</button></form></td></tr>");
			}
			//总页数
			int pages = tdao.searchallpage("0", keyword);
			//总题数
			int counts = tdao.searchallchoice(keyword);
			sb.append("</table><div><span>共");
			sb.append(pages);
			sb.append("页");
			sb.append(counts);
			sb.append("题</span>&nbsp;&nbsp;<label>");
			sb.append("<a href=\"./TestManage?page=1&type=Choice&key=" + keyword + "\" class=\"abtn\">首页</a></label>&nbsp;");
			//
			int last = page - 1;
			if (last <= 0)
				last = 1;
			sb.append("<label><a href=\"./TestManage?page=" + last + "&type=Choice&key=" + keyword + "\" class=\"abtn\">上一页</a></label>&nbsp;");
			//
			int next = page + 1;
			if (next > pages)
				next = pages;
			sb.append("<label><a href=\"./TestManage?page=" + next + "&type=Choice&key=" + keyword + "\" class=\"abtn\">下一页</a></label>&nbsp;");
			sb.append("<label><a href=\"./TestManage?page=" + pages + "&type=Choice&key=" + keyword + "\" class=\"abtn\">尾页</a></label>&nbsp;&nbsp;");
			sb.append("<span>当前第" + page + "页</span></div>");
			
		} else {
			List<fillquestion> list = tdao.findtitle(page, "1", keyword);
			sb.append("<table class=\"table table-hover table-bordered\">");
			sb.append("<caption>填空题</caption><thead><tr>");
			sb.append("<th>试题ID</th><th>题目</th><th>答案</th><th>操作</th></tr></thead>");
			
			for (int i = 0; i < list.size(); i++) {
				sb.append("<tr><td>");
				sb.append(list.get(i).getF_id());
				sb.append("</td><td>");
				sb.append(list.get(i).getF_question());
				sb.append("</td><td>");
				sb.append(list.get(i).getF_answer());
				sb.append("</td>");
				sb.append("<td><button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal2\" onclick=\"editTest(this)\">修改</button><br/>");
				sb.append("<form action=\"./DeleteServlet?type=Completion&id=" + list.get(i).getF_id() + "&page=" + page + "&key=" + keyword + "\" method=\"post\" onsubmit=\"return checkDelete()\">");
				sb.append("<button class=\"btn btn-primary\" type=\"submit\">删除</button></form></td></tr>");
			}
			//总页数
			int pages = tdao.searchallpage("1", keyword);
			//总题数
			int counts = tdao.searchallfill(keyword);
			sb.append("</table><div><span>共");
			sb.append(pages);
			sb.append("页");
			sb.append(counts);
			sb.append("题</span>&nbsp;&nbsp;<label>");
			sb.append("<a href=\"./TestManage?page=1&type=Completion&key=" + keyword + "\" class=\"abtn\">首页</a></label>&nbsp;");
			//
			int last = page - 1;
			if (last <= 0)
				last = 1;
			sb.append("<label><a href=\"./TestManage?page=" + last + "&type=Completion&key=" + keyword + "\" class=\"abtn\">上一页</a></label>&nbsp;");
			//
			int next = page + 1;
			if (next > pages)
				next = pages;
			sb.append("<label><a href=\"./TestManage?page=" + next + "&type=Completion&key=" + keyword + "\" class=\"abtn\">下一页</a></label>&nbsp;");
			sb.append("<label><a href=\"./TestManage?page=" + pages + "&type=Completion&key=" + keyword + "\" class=\"abtn\">尾页</a></label>&nbsp;&nbsp;");
			sb.append("<span>当前第" + page + "页</span></div>");			
		}
		request.setAttribute("Table", sb);
		//response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("./jsp/testManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
