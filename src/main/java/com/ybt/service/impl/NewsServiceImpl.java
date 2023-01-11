package com.ybt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ybt.mapper.NewsMapper;
import com.ybt.pojo.News;
import com.ybt.pojo.Page;
import com.ybt.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;

	@Override
	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		return newsMapper.addNews(news);
	}

	@Override
	public Page findAllNews(String pagenum, String type, String title) {

		// TODO Auto-generated method stub
		int num = 1;
		if (pagenum != null && !"".equals(pagenum.trim()))
			num = Integer.parseInt(pagenum);

		News news = newsMapper.getTotalRecords(type, title);

		int totalrecords = news.getId();
		Page page = new Page(num, totalrecords);

		List<News> records = newsMapper.findAllNews(type, title, page.getStartIndex(), page.getPagesize());
		page.setRecords(records);

		return page;
	}

	@Override
	public News findoneNews(int parseInt) {
		// TODO Auto-generated method stub
		return newsMapper.findoneNews(parseInt);
	}

	@Override
	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		return newsMapper.updateNews(news);
	}

	@Override
	public boolean deleteNews(int parseInt) {
		// TODO Auto-generated method stub
		return newsMapper.deleteNews(parseInt);
	}
}
