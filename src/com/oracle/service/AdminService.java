package com.oracle.service;

import com.oracle.dao.AdminDao;
import com.oracle.entity.Admin;

public class AdminService {
	AdminDao ad=new AdminDao();
	public boolean login(Admin adminVo) throws Exception{
		Admin adminPo=ad.getAdminByLoginName(adminVo.getLoginName());
		if (adminPo==null) {
			return false;
		}
		if (!adminPo.getPwd().equals(adminVo.getPwd())) {
			return false;
		}
		adminVo.setUserName(adminPo.getUserName());
		adminVo.setLoginName(adminPo.getLoginName());
		adminVo.setPwd(adminPo.getPwd());
		return true;
		
	}

}
