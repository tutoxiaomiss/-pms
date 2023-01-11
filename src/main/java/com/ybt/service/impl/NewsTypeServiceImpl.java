package com.ybt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ybt.mapper.NewsTypeMapper;
import com.ybt.pojo.NewsType;
import com.ybt.pojo.Page;
import com.ybt.service.NewsTypeService;

@Service
public class NewsTypeServiceImpl implements NewsTypeService {
	@Autowired
	private NewsTypeMapper newsTypeMapper;

	@Override
	public int addNewsType(String typeName) {
		// TODO Auto-generated method stub
		return newsTypeMapper.addNewsType(typeName);
	}

	@Override
	public Page findAllNewsType(String pagenum) {
		int num = 1;
		if (pagenum != null && !"".equals(pagenum.trim()))
			num = Integer.parseInt(pagenum);
		int totalrecords = newsTypeMapper.getTotalRecords();
		Page page = new Page(num, totalrecords);

		List<NewsType> records = newsTypeMapper.findPageRecords(page.getStartIndex(), page.getPagesize());
		page.setRecords(records);

		return page;
	}

	@Override
	public int chickTypeName(String typeName) {
		// TODO Auto-generated method stub
		return newsTypeMapper.chickTypeName(typeName);
	}

	@Override
	public NewsType findOneNewsType(int parseInt) {
		// TODO Auto-generated method stub
		return newsTypeMapper.findOneNewsType(parseInt);
	}

	@Override
	public int updateNewsType(NewsType newsType) {

		return newsTypeMapper.updateNewsType(newsType);
	}

	@Override
	public int deleteNewsType(int parseInt) {
		// TODO Auto-generated method stub
		return newsTypeMapper.deleteNewsType(parseInt);
	}

	@Override
	public List<NewsType> NewsTypeName() {
		// TODO Auto-gnerated method stub
		return newsTypeMapper.NewsTypeName();
	}

	@Override
	public List<NewsType> NewsTypeName2(String type) {
		// TODO Auto-generated method stub
		return newsTypeMapper.NewsTypeName2(type);
	}

}
