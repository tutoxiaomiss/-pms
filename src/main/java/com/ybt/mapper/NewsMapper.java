package com.ybt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ybt.pojo.News;

public interface NewsMapper {

	boolean addNews(News news);

	News getTotalRecords(@Param("type") String type, @Param("title") String title);

	List<News> findAllNews(@Param("type") String type, @Param("title") String title,
			@Param("startIndex") int startIndex, @Param("pagesize") int pagesize);

	News findoneNews(int parseInt);

	boolean updateNews(News news);

	boolean deleteNews(int parseInt);

}
