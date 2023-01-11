package com.ybt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ybt.pojo.Admin;

public interface AdminMapper {

	int chickAdmin(String adminName);

	int register(Admin admin);

	Admin save(Admin admin);

	int getTotalRecords();

	List<?> findPageRecords(@Param("startIndex") int startIndex, @Param("pagesize") int pagesize);

	Admin byIdAdmin(int intId);

	int updateAdmin(Admin admin);

	int deleteAdmin(int intId);

}
