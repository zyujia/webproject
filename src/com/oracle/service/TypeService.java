package com.oracle.service;

import java.util.List;
import com.oracle.dao.DbUtils;
import com.oracle.dao.TypeDao;
import com.oracle.entity.Type;

public class TypeService {
	TypeDao td=new TypeDao();
	public List<Type> list() throws Exception{
		List<Type> ls=td.list();
		DbUtils.closeConn();
		return ls;
	}
}
