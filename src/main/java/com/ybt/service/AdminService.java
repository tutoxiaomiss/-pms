package com.ybt.service;

import com.ybt.pojo.Admin;
import com.ybt.pojo.Page;

public interface AdminService {

	int chickAdmin(String adminName);

	int register(Admin adminr);

	Admin save(Admin admin);

	Page findPageRecords(String pagenum);

	Admin byIdAdmin(int parseInt);

	int updateAdmin(Admin admin);

	int deleteAdmin(String id);

}
