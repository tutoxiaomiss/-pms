package com.ybt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ybt.pojo.NewsType;
import com.ybt.pojo.Page;
import com.ybt.service.NewsTypeService;

@Controller
public class NewsTypeController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("newsTypeServiceImpl")
	private NewsTypeService newsTypeService;

	@RequestMapping("/goAddNewsType")
	public String goaddNewsType() {
		return "/admin/NewType_AddNew";
	}

	@RequestMapping("/addNewsType")
	public String addNewsType(String typeName) {

		if (newsTypeService.chickTypeName(typeName) > 0) {
			request.setAttribute("successa", "<script>alert('该类型已存在');</script>");
			return "forward:/goAddNewsType";
		}

		if (newsTypeService.addNewsType(typeName) > 0) {
			request.setAttribute("success", "<script>alert('添加成功');</script>");
			return "forward:findAllNewsType";
		}

		return "forward:/goAddNewsType";
	}

	@RequestMapping("/findAllNewsType")
	public String findAllNewsType(String pagenum) {

		Page page = newsTypeService.findAllNewsType(pagenum);
		page.setServletUrl("findAllNewsType?");
		request.setAttribute("page", page);
		return "/admin/NewType_ManageNew";
	}

	@RequestMapping("/findoneNewsType")
	public String findoneNewsType(String id) {
		NewsType newsType = newsTypeService.findOneNewsType(Integer.parseInt(id));
		request.setAttribute("newsType", newsType);
		return "/admin/NewType_EditNew";
	}

	@RequestMapping("/updateNewsType")
	public String updateNewsType(NewsType newsType) {

		if (newsTypeService.chickTypeName(newsType.getTypeName()) > 0) {
			request.setAttribute("successe", "<script>alert('该类型已拥有');</script>");
			newsType.setTypeName("");
			request.setAttribute("newsType", newsType);
			return "/admin/NewType_EditNew";
		}

		if (newsTypeService.updateNewsType(newsType) > 0) {
			request.setAttribute("success", "<script>alert('恭喜您修改成功');</script>");
			return "forward:/findAllNewsType";
		}
		request.setAttribute("successe", "<script>alert('很遗憾:修改失败');</script>");
		return "forward:/findAllNewsType";
	}

	@RequestMapping("deleteNewsType")
	public String deleteNewsType(String id) {
		if (newsTypeService.deleteNewsType(Integer.parseInt(id)) > 0) {
			request.setAttribute("success", "<script>alert('恭喜您删除成功!');</script>");
			return "forward:/findAllNewsType";
		}
		request.setAttribute("success", "<script>alert('很遗憾修改失败');</script>");
		return "forward:/findAllNewsType";
	}

	@RequestMapping("deleteByIdsNewsType")
	public String deleteByIdsNewsType(String[] ck) {

		for (String id : ck) {
			newsTypeService.deleteNewsType(Integer.parseInt(id));
		}

		request.setAttribute("success", "<script>alert('批量删除成功');</script>");
		return "forward:/findAllNewsType";

	}
}
