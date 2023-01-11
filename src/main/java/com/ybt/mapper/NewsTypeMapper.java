package com.ybt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ybt.pojo.NewsType;

public interface NewsTypeMapper {

	int addNewsType(String typeName);

	int getTotalRecords();

	List<NewsType> findPageRecords(@Param("startIndex") int startIndex, @Param("pagesize") int pagesize);

	int chickTypeName(String typeName);

	NewsType findOneNewsType(int parseInt);

	int updateNewsType(NewsType newsType);

	int deleteNewsType(int parseInt);

	List<NewsType> NewsTypeName();

	List<NewsType> NewsTypeName2(String type);

}
