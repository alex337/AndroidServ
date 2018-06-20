package com.hhit.dao.factory;


import com.hhit.dao.TestDAO;
import com.hhit.dao.impl.testdaoimpl;


public class DaoFactory {
	public static TestDAO gettestdao()
	{
		return new testdaoimpl();
	}
}
