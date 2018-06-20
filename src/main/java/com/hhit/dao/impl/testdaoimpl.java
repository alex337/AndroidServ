package com.hhit.dao.impl;

import com.hhit.dao.TestDAO;
import com.hhit.dao.util.DbUtil;
import com.hhit.model.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class testdaoimpl implements TestDAO {
	public int save(test t)
	{
		String sql="INSERT INTO test(name,password)values(?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, t.getName());
			ps.setString(2, t.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
		
	}

	@Override
	public String studentLogin(String account, String password) {
		// TODO Auto-generated method stub
		String sql="select sname from student where sid='"+account+"' and pwd='"+password+"'";
		ResultSet rs = DbUtil.executeQuery(sql);
		String result= "null";
		try {
			if(rs.next())
			{
				result=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	@Override
	public String teacherLogin(String account, String password) {
		// TODO Auto-generated method stub
		String sql="select tname from teacher where tid='"+account+"' and pwd='"+password+"'";
		ResultSet rs = DbUtil.executeQuery(sql);
		String result="null";
		try {
			if(rs.next())
			{
				result=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	@Override
	public String adminLogin(String account, String password) {
		// TODO Auto-generated method stub
		String sql="select aname from administrator where adid='"+account+"' and pwd='"+password+"'";
		ResultSet rs = DbUtil.executeQuery(sql);
		String result="null";
		try {
			if(rs.next())
			{
				result=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

//	public int savestudent(Student s) {
//		// TODO Auto-generated method stub
//		String sql="INSERT INTO student(sid,sname,sex,cardnumber,pwd,department,phone)values(?,?,?,?,?,?,?)";
//		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
//		int result = 0 ;
//		try {
//			ps.setString(1, s.getSid() );
//			ps.setString(2, s.getSname());
//			ps.setString(3, s.getSex());
//			ps.setString(4, s.getCardnumber());
//			ps.setString(5, s.getPwd());
//			ps.setString(6, s.getDepartment());
//			ps.setString(7, s.getPhone());
//			result = ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		DbUtil.close();
//		return result;
//	}
//
//	public int saveteacher(teacher t) {
//		// TODO Auto-generated method stub
//		String sql="INSERT INTO teacher(tid,tname,sex,cardnumber,pwd,title,phone)values(?,?,?,?,?,?,?)";
//		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
//		int result = 0 ;
//		try {
//			ps.setString(1, t.getTid());
//			ps.setString(2, t.getTname());
//			ps.setString(3, t.getSex());
//			ps.setString(4, t.getCardnumber());
//			ps.setString(5, t.getPwd());
//			ps.setString(6, t.getTitle());
//			ps.setString(7, t.getPhone());
//			result = ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		DbUtil.close();
//		return result;
//	}

	@Override
	public int updatespwd(String account, String password) {
		// TODO Auto-generated method stub
		String sql="update student set pwd='"+password+"' where sid='"+account+"'";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	@Override
	public int updatetpwd(String account, String password) {
		// TODO Auto-generated method stub
		String sql="update teacher set pwd='"+password+"' where tid='"+account+"'";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	
	@Override
	public int updateapwd(String account, String password) {
		// TODO Auto-generated method stub
		String sql="update administrator set pwd='"+password+"' where adid='"+account+"'";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	@Override
	public int savescore(String sid, int score) {
		// TODO Auto-generated method stub
		
		String sql="INSERT INTO stuscore(sid,score)values(?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1,sid);
			ps.setInt(2,score);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	@Override
	public String searchscore(String sid) {
		// TODO Auto-generated method stub
		String sql="select score from stuscore where sid='"+sid+"'";
		ResultSet rs = DbUtil.executeQuery(sql);
		String result="null";
		try {
			if(rs.next())
			{
				result=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

//	@Override
//	public int updatestudent(student s) {
//		// TODO Auto-generated method stub
//		String sql = "UPDATE student SET sname=?, sex=?,"
//				+ "cardnumber=?,pwd=?,department=?,phone=?"
//				+ " WHERE sid=?";
//
//		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
//		int result = 0 ;
//		try {
//
//			ps.setString(1,s.getSname() );
//			ps.setString(2, s.getSex());
//			ps.setString(3, s.getCardnumber());
//			ps.setString(4, s.getPwd());
//			ps.setString(5,s.getDepartment());
//			ps.setString(6, s.getPhone());
//			ps.setString(7,s.getSid());
//			result = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DbUtil.close();
//		return result;
//	}
//
//	@Override
//	public int updateteacher(teacher t) {
//		// TODO Auto-generated method stub
//		String sql = "UPDATE teacher SET tname=?, sex=?,"
//				+ "cardnumber=?,pwd=?,title=?,phone=?"
//				+ " WHERE tid=?";
//
//		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
//		int result = 0 ;
//		try {
//			ps.setString(1,t.getTname());
//			ps.setString(2,t.getSex());
//			ps.setString(3,t.getCardnumber());
//			ps.setString(4,t.getPwd());
//			ps.setString(5,t.getTitle());
//			ps.setString(6,t.getPhone());
//			ps.setString(7,t.getTid());
//
//			result = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DbUtil.close();
//		return result;
//	}
	
	@Override
	public String searchcardnumber(String account, String password) {
		// TODO Auto-generated method stub
		String sql="select cardnumber from student where sid='"+account+"' and pwd='"+password+"'";
		ResultSet rs = DbUtil.executeQuery(sql);
		String result="null";
		try {
			if(rs.next())
			{
				result=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	
	@Override
	public String searchStime() {
		// TODO Auto-generated method stub
		String sql="select stime from testtime";
		ResultSet rs = DbUtil.executeQuery(sql);
		String result="null";
		try {
			if(rs.next())
			{
				result=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	@Override
	public String searchTime() {
		// TODO Auto-generated method stub
		String sql="select time from testtime";
		ResultSet rs = DbUtil.executeQuery(sql);
		String result="null";
		try {
			if(rs.next())
			{
				result=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	
	@Override
	public List<choicequestion> findchoiceques() {
		// TODO Auto-generated method stub
		String type="0";
		String sql = "SELECT * FROM testpaper where type='"+type+"'ORDER BY nowid";
		List<testpaper> list = new ArrayList<testpaper>();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list"+list.get(i));
		}
		ResultSet rs = DbUtil.executeQuery(sql);
		try {
			while(rs.next())
			{
				testpaper tp=new testpaper();
				tp.setPreid(rs.getInt("preid"));
				list.add(tp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		List<choicequestion> list1=new ArrayList<choicequestion>();
		for(int i=0;i<list.size();i++)
		{
			int preid=list.get(i).getPreid();
			String sql1="select * from choicequestion where c_id='"+preid+"'";
			ResultSet rs1 = DbUtil.executeQuery(sql1);
			try {
				while(rs1.next())
				{
					choicequestion cq=new choicequestion();
					cq.setC_question(rs1.getString("c_question"));
					cq.setC_choiceA(rs1.getString("c_choiceA"));
					cq.setC_choiceB(rs1.getString("c_choiceB"));
					cq.setC_choiceC(rs1.getString("c_choiceC"));
					cq.setC_choiceD(rs1.getString("c_choiceD"));
					cq.setC_answer(rs1.getString("c_answer"));
					System.out.println("cxxx"+cq.getC_answer());
					list1.add(cq);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbUtil.close();
		}	
		return list1;
	}

	@Override
	public List<fillquestion> findfillques() {
		// TODO Auto-generated method stub
		String type="1";
		String sql = "SELECT * FROM testpaper where type='"+type+"'ORDER BY nowid";
		List list = new ArrayList();
		ResultSet rs = DbUtil.executeQuery(sql);
		try {
			testpaper tp=new testpaper();
			while(rs.next())
			{
				//testpaper tp=new testpaper();
				//tp.setPreid(rs.getInt("preid"));
				list.add(Integer.valueOf(rs.getInt("preid")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		List<fillquestion> list1=new ArrayList<fillquestion>();
		for(int i=0;i<list.size();i++)
		{
			int preid=(int) list.get(i);
			String sql1="select * from fillquestion where f_id='"+preid+"'";
			ResultSet rs1 = DbUtil.executeQuery(sql1);
			try {
				while(rs1.next())
				{
					fillquestion fq=new fillquestion();
					fq.setF_question(rs1.getString("f_question"));
					fq.setF_answer(rs1.getString("f_answer"));
					list1.add(fq);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbUtil.close();
		}	
		return list1;
	}
	
	@Override
	public List<testpaper> findanswer() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM testpaper ORDER BY nowid ";
		List<testpaper> list = new ArrayList<testpaper>();
		ResultSet rs = DbUtil.executeQuery(sql);
		try {
			while(rs.next())
			{
				stuscore sscore=new stuscore();
				testpaper tp=new testpaper();
				tp.setAnswer(rs.getString("answer"));
				list.add(tp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return list;
	}
	
	@Override
	public int searchallpage(String type,String keyword) {
		// TODO Auto-generated method stub
		int length=0;
		String sql=null;
		if(type.equals("0"))
		{
			if(keyword.equals("")||keyword==null)
				sql="select * from choicequestion";
			else
				sql="select * from choicequestion where c_question like '%"+keyword+"%'";
			ResultSet rs= DbUtil.executeQuery(sql);
			List<choicequestion> list = new ArrayList<choicequestion>();
			try {
				while(rs.next())
				{
					choicequestion cq=new choicequestion();
					cq.setC_question(rs.getString("c_question"));
					cq.setC_choiceA(rs.getString("c_choiceA"));
					cq.setC_choiceB(rs.getString("c_choiceB"));
					cq.setC_choiceC(rs.getString("c_choiceC"));
					cq.setC_choiceD(rs.getString("c_choiceD"));
					list.add(cq);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			length=list.size();
			DbUtil.close();
			return length/10+1;
		}
		else
		{
			if(keyword.equals("")||keyword==null)
				sql="select * from fillquestion";
			else
				sql="select * from fillquestion where f_question like '%"+keyword+"%'";
			ResultSet rs= DbUtil.executeQuery(sql);
			List<fillquestion> list = new ArrayList<fillquestion>();
			try {
				while(rs.next())
				{
					fillquestion fq=new fillquestion();
					fq.setF_question(rs.getString("f_question"));
					list.add(fq);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			length=list.size();
			DbUtil.close();
			return length/10+1;
		}
		
	}

	
	@Override
	public int savechoiceq(choicequestion c) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO choicequestion(c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer)values(?,?,?,?,?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, c.getC_question() );
			ps.setString(2, c.getC_choiceA());
			ps.setString(3, c.getC_choiceB());
			ps.setString(4, c.getC_choiceC());
			ps.setString(5, c.getC_choiceD());
			ps.setString(6, c.getC_answer());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result; 
	}

	@Override
	public int savefillq(fillquestion f) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO fillquestion(f_question,f_answer)values(?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, f.getF_question());
			ps.setString(2, f.getF_answer());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result; 
	}
	
	@Override
	public int searchallchoice(String keyword) {
		// TODO Auto-generated method stub
		String sql=null;
		if(keyword.equals("")||keyword==null)
			sql="select count(*)totalCount from choicequestion";
		else
			sql="select count(*)totalCount from choicequestion where c_question like '%"+keyword+"%'";
		ResultSet rs= DbUtil.executeQuery(sql);
		int allchoice=0;
		try {
			if(rs.next())
			{
				allchoice=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allchoice;
	}

	@Override
	public int searchallfill(String keyword) {
		// TODO Auto-generated method stub
		String sql=null;
		if(keyword.equals("")||keyword==null)
			sql="select count(*)totalCount from fillquestion";
		else
			sql="select count(*)totalCount from fillquestion where f_question like '%"+keyword+"%'";
		ResultSet rs= DbUtil.executeQuery(sql);
		int allfill=0;
		try {
			if(rs.next())
			{
				allfill=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allfill;
	}

	
	@Override
	public int savechoice(List a) {
		// TODO Auto-generated method stub
		int result1 = 0 ;
		String sql="select * from choicequestion";
		ResultSet rs = DbUtil.executeQuery(sql);
		List<choicequestion> list = new ArrayList<choicequestion>();
		String result=null; //答案
		int id=0;  //原题id
		try {
			while(rs.next())
			{
				choicequestion cq=new choicequestion();
				cq.setC_id(rs.getInt("c_id"));
				cq.setC_answer(rs.getString("c_answer"));
				list.add(cq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		for(int i=0;i<a.size();i++) {
			int alltitle = searchnowtest();//获取当前试卷的题数
			//查找原题库的对应选择题
			System.out.println("长度"+list.size());
			id=list.get((int) a.get(i)-1).getC_id();
			result=list.get((int) a.get(i)-1).getC_answer();
				
			String sql1="insert into testpaper(nowid,preid,type,answer) values(?,?,0,?)";
			PreparedStatement ps = DbUtil.executePreparedStatement(sql1);
			try {
				ps.setInt(1, alltitle+1);
				ps.setInt(2, id);
				ps.setString(3,result);
				result1 = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DbUtil.close();
		return result1;
	}

	@Override
	public int savefill(List a) {
		// TODO Auto-generated method stub
		int result1 = 0 ;
		String sql="select * from fillquestion";
		ResultSet rs = DbUtil.executeQuery(sql);
		List<fillquestion> list = new ArrayList<fillquestion>();
		String result=null; //答案
		int id=0;  //原题id
		try {
			while(rs.next())
			{
				fillquestion fq=new fillquestion();
				fq.setF_id(rs.getInt("f_id"));
				fq.setF_answer(rs.getString("f_answer"));
				list.add(fq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		for(int i=0;i<a.size();i++) {

			int alltitle = searchnowtest();
			//System.out.println(alltitle);
			id=list.get((int) a.get(i)-1).getF_id();
			result=list.get((int) a.get(i)-1).getF_answer();

			String sql1="insert into testpaper(nowid,preid,type,answer) values(?,?,1,?)";
			PreparedStatement ps = DbUtil.executePreparedStatement(sql1);
			try {
				ps.setInt(1, alltitle+1);
				ps.setInt(2, id);
				ps.setString(3,result);
				result1 = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbUtil.close();
		}

		return result1;
	}


	@Override
	public int searchnowtest() {
		// TODO Auto-generated method stub
		String sql="select count(*)totalCount from testpaper";
		ResultSet rs= DbUtil.executeQuery(sql);
		int alltitle=0;
		try {
			if(rs.next())
			{
				alltitle=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return alltitle;
	}
	
	@Override
	public int deletechoice(int id) {
		// TODO Auto-generated method stub
		String sql="delete from choicequestion where c_id='"+id+"'";
		int result = 0 ;
		result = DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}

	@Override
	public int deletefill(int id) {
		// TODO Auto-generated method stub
		String sql="delete from fillquestion where f_id='"+id+"'";
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	
	@Override
	public int updatechoice(choicequestion c) {
		// TODO Auto-generated method stub
		String sql="update choicequestion set c_question=?,c_choiceA=?,"
				+"c_choiceB=?,c_choiceC=?,c_choiceD=?,c_answer=? where c_id=?";
		PreparedStatement ps=DbUtil.executePreparedStatement(sql);
		int result=0;
		try {
			
			ps.setString(1, c.getC_question());
			ps.setString(2, c.getC_choiceA());
			ps.setString(3, c.getC_choiceB());
			ps.setString(4, c.getC_choiceC());
			ps.setString(5, c.getC_choiceD());
			ps.setString(6, c.getC_answer());
			ps.setInt(7, c.getC_id());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	@Override
	public int updatefill(fillquestion f) {
		// TODO Auto-generated method stub
		String sql="update fillquestion set f_question=?,f_answer=? where f_id=?";
		PreparedStatement ps=DbUtil.executePreparedStatement(sql);
		int result=0;
		try {
			
			ps.setString(1, f.getF_question());
			ps.setString(2, f.getF_answer());
			ps.setInt(3, f.getF_id());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}
	
	@Override
	public List findtitle(int page,String type,String keyword) {
		// TODO Auto-generated method stub
		int spage=(page-1)*10; //当前页开始的记录数
		String sql=null;
		if(type.equals("0"))
		{
			if(keyword.equals("")||keyword==null)
				sql="select * from choicequestion limit "+spage+",10";
			else
				sql="select * from choicequestion where c_question like '%"+keyword+"%' limit "+spage+",10";
			
				List<choicequestion> list = new ArrayList<choicequestion>();
				ResultSet rs = DbUtil.executeQuery(sql);
				try {
					while(rs.next())
					{
					choicequestion cq=new choicequestion();
					cq.setC_id(rs.getInt("c_id"));
					cq.setC_question(rs.getString("c_question"));
					cq.setC_choiceA(rs.getString("c_choiceA"));
					cq.setC_choiceB(rs.getString("c_choiceB"));
					cq.setC_choiceC(rs.getString("c_choiceC"));
					cq.setC_choiceD(rs.getString("c_choiceD"));
					cq.setC_answer(rs.getString("c_answer"));
					list.add(cq);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbUtil.close();
			return list;
		}
		else
		{
			if(keyword.equals("")||keyword==null)
				sql="select * from fillquestion limit "+spage+",10";
			else
				sql="select * from fillquestion where f_question like '%"+keyword+"%' limit "+spage+",10";
			List<fillquestion> list = new ArrayList<fillquestion>();
			ResultSet rs = DbUtil.executeQuery(sql);
			try {
				while(rs.next())
				{
					fillquestion fq=new fillquestion();
					fq.setF_id(rs.getInt("f_id"));
					fq.setF_question(rs.getString("f_question"));
					fq.setF_answer(rs.getString("f_answer"));
					list.add(fq);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbUtil.close();
			return list;
		}
		
	}

	@Override
	public int deletetestpaper() {
		// TODO Auto-generated method stub
		String sql="delete from testpaper";
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	
	@Override
	public int savetime(String stime,String time) {
		// TODO Auto-generated method stub
		String sql="insert into testtime(stime,time) values(?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, stime);
			ps.setString(2, time);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	@Override
	public int deletetime() {
		// TODO Auto-generated method stub
		String sql="delete from testtime";
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}

	@Override
	public List<stuscore> findscore() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM stuscore ORDER BY sid ";
		List<stuscore> list = new ArrayList<stuscore>();
		ResultSet rs = DbUtil.executeQuery(sql);
		try {
			while(rs.next())
			{
				stuscore sscore=new stuscore();
				sscore.setSid(rs.getString("sid"));
				sscore.setScore(rs.getString("score"));
				list.add(sscore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		List<stuscore> list1 =new ArrayList<stuscore>();
		for(int i=0;i<list.size();i++)
		{
			String sql1="select stuName from student where stuID='"+list.get(i).getSid()+"'";
			ResultSet rs1 = DbUtil.executeQuery(sql1);
			try {
				if(rs1.next())
				{
					stuscore score=new stuscore();
					score.setSid(list.get(i).getSid());
					score.setSname(rs1.getString(1));
					score.setScore(list.get(i).getScore());
					list1.add(score);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DbUtil.close();
		return list1;
	}
	
	@Override
	public int existtime() {
		// TODO Auto-generated method stub
		String sql="select count(*)totalCount from testtime";
		ResultSet rs= DbUtil.executeQuery(sql);
		int time=0;
		try {
			if(rs.next())
			{
				time=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return time;
	}

	@Override
	public int existscore() {
		// TODO Auto-generated method stub
		String sql="select count(*)totalCount from stuscore";
		ResultSet rs= DbUtil.executeQuery(sql);
		int score=0;
		try {
			if(rs.next())
			{
				score=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return score;
	}
	
	@Override
	public int deletescore() {
		// TODO Auto-generated method stub
		String sql="delete from stuscore";
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}
	
//	@Override
//	public List<student> searchstudent(String keyword, String select,int page) {
//		// TODO Auto-generated method stub
//		int spage=(page-1)*10;
//		String sql=null;
//		List<student> list = new ArrayList<student>();
//		if(keyword==null || keyword == "")
//		{
//			sql="select * from student limit "+spage+",10";
//			ResultSet rs = DbUtil.executeQuery(sql);
//			try {
//				while(rs.next())
//				{
//					student s=new student();
//					s.setSid(rs.getString("sid"));
//					s.setSname(rs.getString("sname"));
//					s.setSex(rs.getString("sex"));
//					s.setCardnumber(rs.getString("cardnumber"));
//					s.setPwd(rs.getString("pwd"));
//					s.setDepartment(rs.getString("department"));
//					s.setPhone(rs.getString("phone"));
//					list.add(s);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//			DbUtil.close();
//			return list;
//		}
//		else
//		{
//			if(select.equals("id"))
//				sql="select * from student where sid='"+keyword+"' limit "+spage+",10";
//			else
//				sql="select * from student where sname='"+keyword+"' limit "+spage+",10";
//			ResultSet rs = DbUtil.executeQuery(sql);
//			try {
//				while(rs.next())
//				{
//					student s=new student();
//					s.setSid(rs.getString("sid"));
//					s.setSname(rs.getString("sname"));
//					s.setSex(rs.getString("sex"));
//					s.setCardnumber(rs.getString("cardnumber"));
//					s.setPwd(rs.getString("pwd"));
//					s.setDepartment(rs.getString("department"));
//					s.setPhone(rs.getString("phone"));
//					list.add(s);
//				}
//			} catch (SQLException e) {
//			e.printStackTrace();
//			}
//				DbUtil.close();
//				return list;
//		}
//	}


//	@Override
//	public List<teacher> searchteacher(String keyword, String select,int page) {
//		// TODO Auto-generated method stub
//		int spage=(page-1)*10;
//		String sql=null;
//		List<teacher> list = new ArrayList<teacher>();
//		if(keyword==null || keyword == "")
//		{
//			sql="select * from teacher limit "+spage+",10";
//			ResultSet rs = DbUtil.executeQuery(sql);
//			try {
//				while(rs.next())
//				{
//					teacher t=new teacher();
//					t.setTid(rs.getString("tid"));
//					t.setTname(rs.getString("tname"));
//					t.setSex(rs.getString("sex"));
//					t.setCardnumber(rs.getString("cardnumber"));
//					t.setPwd(rs.getString("pwd"));
//					t.setTitle(rs.getString("title"));
//					t.setPhone(rs.getString("phone"));
//					list.add(t);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//			DbUtil.close();
//			return list;
//		}
//		else
//		{
//			if(select.equals("id"))
//				sql="select * from teacher where tid='"+keyword+"' limit "+spage+",10";
//			else
//				sql="select * from teacher where tname='"+keyword+"' limit "+spage+",10";
//			ResultSet rs = DbUtil.executeQuery(sql);
//			try {
//				while(rs.next())
//				{
//					teacher t=new teacher();
//					t.setTid(rs.getString("tid"));
//					t.setTname(rs.getString("tname"));
//					t.setSex(rs.getString("sex"));
//					t.setCardnumber(rs.getString("cardnumber"));
//					t.setPwd(rs.getString("pwd"));
//					t.setTitle(rs.getString("title"));
//					t.setPhone(rs.getString("phone"));
//					list.add(t);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//			DbUtil.close();
//			return list;
//	}
//	}

	@Override
	public int searchstuallpage(String keyword,String select) {
		// TODO Auto-generated method stub
		String sql=null;
		int allstu=0;
		if(keyword==null || keyword == "")
			sql="select count(*)totalCount from student";
		else 
		{	if(select.equals("id"))
			sql="select count(*)totalCount from student where sid='"+keyword+"'";
			else 
			sql="select count(*)totalCount from student where sname='"+keyword+"'";
		}
		ResultSet rs= DbUtil.executeQuery(sql);
		try {
			if(rs.next())
			{
				allstu=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return allstu/10+1;
	}

	@Override
	public int searchteaallpage(String keyword,String select) {
		// TODO Auto-generated method stub
		String sql=null;
		int alltea=0;
		if(keyword==null || keyword == "")
			sql="select count(*)totalCount from teacher";
		else 
		{ 	if(select.equals("id"))
				sql="select count(*)totalCount from teacher where tid='"+keyword+"'";
			else
				sql="select count(*)totalCount from teacher where tname='"+keyword+"'";
		}
		ResultSet rs= DbUtil.executeQuery(sql);
		try {
			if(rs.next())
			{
				alltea=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return alltea/10+1;
	}

	@Override
	public int findstu(String keyword,String select) {
		// TODO Auto-generated method stub
		String sql=null;
		int allstu=0;
		if(keyword==null || keyword == "")
			sql="select count(*)totalCount from student";
		else 
		{	if(select.equals("id"))
			sql="select count(*)totalCount from student where sid='"+keyword+"'";
			else 
			sql="select count(*)totalCount from student where sname='"+keyword+"'";
		}
		ResultSet rs= DbUtil.executeQuery(sql);
		try {
			if(rs.next())
			{
				allstu=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return allstu;
	}

	@Override
	public int findtea(String keyword,String select) {
		// TODO Auto-generated method stub
		String sql=null;
		int alltea=0;
		if(keyword==null || keyword == "")
			sql="select count(*)totalCount from teacher";
		else 
		{ 	if(select.equals("id"))
				sql="select count(*)totalCount from teacher where tid='"+keyword+"'";
			else
				sql="select count(*)totalCount from teacher where tname='"+keyword+"'";
		}
		ResultSet rs= DbUtil.executeQuery(sql);
		try {
			if(rs.next())
			{
				alltea=rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbUtil.close();
		return alltea;
	}
	
	@Override
	public int deletestudent(String id) {
		// TODO Auto-generated method stub
		String sql="delete from student where sid='"+id+"'";
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}

	@Override
	public int deleteteacher(String id) {
		// TODO Auto-generated method stub
		String sql="delete from teacher where tid='"+id+"'";
		int result=0;
		result=DbUtil.executeUpdate(sql);
		DbUtil.close();
		return result;
	}

	@Override
	public int savestudent(Student s) {
		return 0;
	}

	@Override
	public int saveteacher(Teacher t) {
		return 0;
	}

	@Override
	public int updatestudent(Student s) {
		return 0;
	}

	@Override
	public int updateteacher(Teacher t) {
		return 0;
	}

	@Override
	public List<Teacher> searchteacher(String keyword, String select, int page) {
		return null;
	}

	@Override
	public List<Student> searchstudent(String keyword, String select, int page) {
		return null;
	}
}

