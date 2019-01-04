package com.oracle.service;

import com.oracle.bean.ReturnMessage;
import com.oracle.dao.DbUtils;
import com.oracle.dao.UserDao;
import com.oracle.entity.User;


public class UserService {
	UserDao ud=new UserDao();
	public boolean login(User userVo) throws Exception{
		User userPo=ud.getUserByLoginName(userVo.getLoginName());
		if (userPo==null) {
			return false;
		}
		if (!userPo.getPwd().equals(userVo.getPwd())) {
			return false;
		}
		userVo.setUserName(userPo.getUserName());
		userVo.setLoginName(userPo.getLoginName());
		userVo.setPwd(userPo.getPwd());
		return true;
		
	}
	public boolean reg(User userVo) throws Exception {
		User userPo=ud.getUserByLoginName(userVo.getLoginName());
		if (userPo!=null) {
			DbUtils.closeConn();
			return  false;
		}
		return true;
	}
	public boolean register(User user) throws Exception{
		boolean bln=true;
		try {
			if (ud.reg(user)>0) {
			} else {
				bln=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeConn();
		}
		return bln;
	}

}
