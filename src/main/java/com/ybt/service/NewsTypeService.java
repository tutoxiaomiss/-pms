package com.ybt.service;

import java.util.List;

import com.ybt.pojo.NewsType;
import com.ybt.pojo.Page;

public interface NewsTypeService {

	int addNewsType(String typeName);

	Page findAllNewsType(String pagenum);

	int chickTypeName(String typeName);

	NewsType findOneNewsType(int parseInt);

	int updateNewsType(NewsType newsType);

	int deleteNewsType(int parseInt);

	List<NewsType> NewsTypeName();

	List<NewsType> NewsTypeName2(String type);

}
