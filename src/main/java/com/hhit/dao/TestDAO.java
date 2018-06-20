package com.hhit.dao;



import com.hhit.model.*;

import java.util.List;

public interface TestDAO {
	public int save(test t);
	public String studentLogin(String account, String password);  //学生登陆
	public String teacherLogin(String account, String password);  //教师登陆
	public String adminLogin(String account, String password);  //管理员登陆
	public int savestudent(Student s);  //学生注册
	public int saveteacher(Teacher t);   //教师注册
	public int updatespwd(String account, String password);  //修改学生密码
	public int updatetpwd(String account, String password);  //修改教师密码
	public int updateapwd(String account, String password);  //修改管理员面膜
	public int savescore(String sid, int score);    //保存学生的成绩
	public String searchscore(String sid);  //教师查询学生的成绩
	public int updatestudent(Student s);  //修改学生信息
	public int updateteacher(Teacher t);  //修改教师信息
	public String searchcardnumber(String account, String password);  //查询身份证
	public String searchStime();   //查询考试开始时间
	public String searchTime();  //查询考试时长
	public List<choicequestion> findchoiceques();   //查询考卷选择题的信息
	public List<fillquestion> findfillques();  //查询考卷填空题的信息
	public List<testpaper> findanswer();   //查询考卷试题的答案
	public int searchallpage(String type, String keyword);   //查询选择/填空总页数
	public int savechoiceq(choicequestion c);  // 保存选择考试试题
	public int savefillq(fillquestion f);   //保存填空考试试题
	public int searchallfill(String keyword);  //搜索总的填空题数
	public int searchallchoice(String keyword);  //搜索总的选择题数
	public int searchnowtest();   //查询当前试卷的题数
	public int savefill(List a);  //保存填空题
	public int savechoice(List a);  //保存选择题
	public int deletefill(int id);  //选择填空题
	public int deletechoice(int id); //删除选择题
	public int updatefill(fillquestion f);  //修改填空题
	public int updatechoice(choicequestion c); //修改选择题
	public List findtitle(int page, String type, String keyword);//分页查询所有选择/填空试题
	public int deletetestpaper(); //删除试卷
	public int savetime(String stime, String time);  //保存时间
	public int deletetime(); //删除时间表
	public List<stuscore> findscore(); //查询所有学生的成绩
	public int existtime();//判断考试时间表是否存在
	public int existscore();//判断学生成绩表是否存在
	public int deletescore();//删除成绩表
	public List<Teacher> searchteacher(String keyword, String select, int page); //查询教师信息
	public List<Student> searchstudent(String keyword, String select, int page); //查询学生信息
	public int findtea(String keyword, String select); //查询教师信息的总页数
	public int findstu(String keyword, String select); //查询学生信息的总页数
	public int searchteaallpage(String keyword, String select); //查询教师信息的总记录数
	public int searchstuallpage(String keyword, String select);//查询学生信息的总记录数
	public int deletestudent(String id);  //删除学生表
	public int deleteteacher(String id);  //删除教师表
}
