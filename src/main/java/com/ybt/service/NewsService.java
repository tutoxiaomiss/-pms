package com.ybt.service;

import com.ybt.pojo.News;
import com.ybt.pojo.Page;

public interface NewsService {

	boolean addNews(News news);

	Page findAllNews(String pagenum, String type, String title);

	News findoneNews(int parseInt);

	boolean updateNews(News news);

	boolean deleteNews(int parseInt);

}
