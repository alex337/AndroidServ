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

/**
 * Servlet implementation class UploadQuestions
 */
@WebServlet("/UploadQuestions")
public class UploadQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadQuestions() {
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
		String type = request.getParameter("type");
		if (type.equals("Choice")) {
			choicequestion cq = new choicequestion();
			cq.setC_question(request.getParameter("choiceTitle"));
			System.out.println("题目"+request.getParameter("OptionA"));
			cq.setC_choiceA("A." + request.getParameter("OptionA"));
			cq.setC_choiceB("B." + request.getParameter("OptionB"));
			cq.setC_choiceC("C." + request.getParameter("OptionC"));
			cq.setC_choiceD("D." + request.getParameter("OptionD"));
			cq.setC_answer(request.getParameter("answer"));
			if (tdao.savechoiceq(cq) != 0) {
				request.setAttribute("upload", "upload");
				request.getRequestDispatcher("./jsp/upload.jsp").forward(request, response);
			} else {
				request.setAttribute("uploadFail", "uploadFail");
				request.getRequestDispatcher("./jsp/upload.jsp").forward(request, response);
			}
			
		} else {
			fillquestion fq = new fillquestion();
			fq.setF_question(request.getParameter("completionTitle"));
			fq.setF_answer(request.getParameter("answerText"));
			if(tdao.savefillq(fq) != 0) {
				request.setAttribute("upload", "upload");
				request.getRequestDispatcher("./jsp/upload.jsp").forward(request, response);
			} else {
				request.setAttribute("uploadFail", "uploadFail");
				request.getRequestDispatcher("./jsp/upload.jsp").forward(request, response);
			}
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
