package com.ybt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ybt.pojo.News;
import com.ybt.pojo.NewsType;
import com.ybt.pojo.Page;
import com.ybt.service.NewsService;
import com.ybt.service.NewsTypeService;

@Controller
public class NewsController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("newsServiceImpl")
	private NewsService newsService;

	@Autowired
	@Qualifier("newsTypeServiceImpl")
	private NewsTypeService newsTypeService;

	@RequestMapping("/NewsgoAddNews")
	public String NewsgoAddNews() {
		List<NewsType> newsType = newsTypeService.NewsTypeName();
		request.setAttribute("newsType", newsType);
		return "/admin/New_AddNew";
	}

	@RequestMapping("/addNews")
	public String addNews(News news) {
		Date date1 = new Date();
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		news.setDate(sdf.format(date1));
		if (newsService.addNews(news)) {
			request.setAttribute("success", "<script>alert('添加成功');</script>");
			return "forward:/findAllNews";
		}
		request.setAttribute("successa", "<script>alert('添加失败');</script>");
		return "forward:/NewsgoAddNews";
	}

	@RequestMapping("/findAllNews")
	// 当添加新闻后addNews会把他添加新闻的对象newsforward传过来所以添加完成后
	// 列表就会就只显示刚才添加的新闻 我们只需要把type改成type1 title1 和传过来的news对象里的type title对象不一样就行
	//但如果需求是添加完成列表只显示刚才添加的一条 把type1 title1 改成和addnews forward过来的news里type title 对象 一致的就行
	public String findAllNews(String pagenum, String type1, String title1) {
		//当第一层访问时会传null而不是""所有数据库就搜索不到字符"null"的字断 
		//我们把他转换一下就行
		String message = (String)request.getSession().getAttribute("message");
		System.out.print(message);
		if (type1 == null && title1 == null) {
			type1 = "";
			title1 = "";
		}

		List<NewsType> newsType = newsTypeService.NewsTypeName();
		request.setAttribute("newsType", newsType);
		Page page = newsService.findAllNews(pagenum, type1, title1);
		request.setAttribute("page", page);
		page.setServletUrl("/findAllNews?&type=" + type1 + "&title=" + title1);

		return "/admin/New_ManageNew";
	}
	@RequestMapping("findoneNews")
	public String findoneNews(String id){
		News news = newsService.findoneNews(Integer.parseInt(id));

		List<NewsType> newsType = newsTypeService.NewsTypeName2(news.getType());
		request.setAttribute("newsType", newsType);
		request.setAttribute("news", news);
		return "/admin/New_EditNew";
	}
	@RequestMapping("/updateNews")
	public String updateNews(News news){
		if(newsService.updateNews(news)){
			request.setAttribute("success", "<script>alert('修改成功');</script>");
			return "forward:/findAllNews";
		}
		request.setAttribute("success", "<script>alert('修改失败');</script>");
		return "forward:/findAllNews";
	}
	@RequestMapping("deleteNews")
	public String deleteNews(String id){
		if(newsService.deleteNews(Integer.parseInt(id))){
			request.setAttribute("success", "<script>alert('删除成功');</script>");
			return "forward:/findAllNews";
		}
		request.setAttribute("success", "<script>alert('删除失败');</script>");
		return "forward:/findAllNews";
	}
	
	@RequestMapping("deleteByIdsNews")
	public String deleteByIdsNews(String[] ck){
		for(String ids : ck){
			newsService.deleteNews(Integer.parseInt(ids));
		}
		request.setAttribute("success", "<script>alert('批量删除成功');</script>");
		return "forward:/findAllNews";
		
	}
}
