package com.ybt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ybt.mapper.AdminMapper;
import com.ybt.pojo.Admin;
import com.ybt.pojo.Page;
import com.ybt.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public int chickAdmin(String adminName) {
		return adminMapper.chickAdmin(adminName);
	}

	@Override
	public int register(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.register(admin);
	}

	@Override
	public Admin save(Admin admin) {
		// TODO Auto-generated method stub

		return adminMapper.save(admin);
	}

	@Override
	public Page findPageRecords(String pagenum) {
		// TODO Auto-generated method stub
		int num = 1;
		if (pagenum != null && !"".equals(pagenum.trim()))
			num = Integer.parseInt(pagenum);
		int totalrecords = adminMapper.getTotalRecords();
		Page page = new Page(num, totalrecords);
		List<?> records = adminMapper.findPageRecords(page.getStartIndex(), page.getPagesize());
		page.setRecords(records);
		return page;

	}

	@Override
	public Admin byIdAdmin(int parseInt) {
		// TODO Auto-generated method stub

		return adminMapper.byIdAdmin(parseInt);
	}

	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.updateAdmin(admin);
	}

	@Override
	public int deleteAdmin(String id) {
		// TODO Auto-generated method stub
		int intId = Integer.parseInt(id);
		return adminMapper.deleteAdmin(intId);
	}

}
