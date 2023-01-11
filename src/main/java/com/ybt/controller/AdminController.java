package com.ybt.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ybt.pojo.Admin;
import com.ybt.pojo.Page;
import com.ybt.service.AdminService;
import com.ybt.utils.MD5Util;

@Controller

public class AdminController {
	@Autowired
	@Qualifier("adminServiceImpl")
	private AdminService adminService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping("/Login")
	public String login(Admin admin) {
		if (admin.getAdminName().equals("") && admin.getAdminPwd().equals("")) {
			request.setAttribute("successl", "<script>alert('请输入账号和密码');</script>");
			return "/admin/login";
		}
		if (admin.getAdminName().equals("")) {
			request.setAttribute("successl", "<script>alert('请输入账号');</script>");
			return "/admin/login";
		}
		if (admin.getAdminPwd().equals("")) {
			request.setAttribute("successl", "<script>alert('请输入密码');</script>");
			return "/admin/login";
		}

		String password = MD5Util.getMD5(admin.getAdminPwd());
		admin.setAdminPwd(password);
		Admin admin1 = adminService.save(admin);

		if (admin1 != null) {
			request.getSession().setAttribute("message", "欢迎您" + admin1.getAdminName());
			return "redirect:/admin/index.jsp";

		}

		request.setAttribute("successl", "<script>alert('账号或密码错误');</script>");
		return "admin/login";

	}

	@RequestMapping("/register")
	public String register(Admin admin) {
		String password = MD5Util.getMD5(admin.getAdminPwd());
		admin.setAdminPwd(password);
		if (adminService.chickAdmin(admin.getAdminName()) > 0) {
			request.setAttribute("successl", "<script>alert('该账号已拥有');</script>");
			return "/admin/login";
		}
		if (adminService.register(admin) > 0) {
			request.setAttribute("successl", "<script>alert('恭喜您注册成功');</script>");
			return "/admin/login";
		}

		request.setAttribute("successl", "<script>alert('很遗憾注册失败');</script>");
		return "/admin/login";
	}

	@RequestMapping("/exit")
	public String exit() {
		request.getSession().removeAttribute("message");
		return "redirect:/admin/login.jsp";

	}

	@RequestMapping("/goAddAdmin")
	public String goAddAdmin() {
		return "/admin/Admin_AddAdmin";
	}

	@RequestMapping("/findAllAdmin")
	public String findAllAdmin(String pagenum) {

		Page page = adminService.findPageRecords(pagenum);
		// 不改page.jsp就在路径后面加个问好一样
		page.setServletUrl("/findAllAdmin?"); // 使用分页时对应的下一页地址URL
		request.setAttribute("page", page);
		return "/admin/Admin_ManageAdmin";

	}

	@RequestMapping("/addAdmin")
	public String addAdmin(Admin admin) {
		String adminPwd = admin.getAdminPwd();
		String password = MD5Util.getMD5(admin.getAdminPwd());
		admin.setAdminPwd(password);
		if (adminService.chickAdmin(admin.getAdminName()) > 0) {
			request.setAttribute("successa", "<script>alert('该账号名已拥有');</script>");
			request.setAttribute("adminPwd", adminPwd);
			return "forward:/goAddAdmin";
		}
		if (adminService.register(admin) > 0) {
			request.setAttribute("success", "<script>alert('添加成功');</script>");
			return "forward:/findAllAdmin";
		}
		request.setAttribute("successa", "<script>alert('添加失败');</script>");
		return "forward:/goAddAdmin";
	}

	@RequestMapping("/findOneAdmin")
	public String findOneAdmin(String id) {

		Admin admin = adminService.byIdAdmin(Integer.parseInt(id));
		request.setAttribute("admin", admin);
//		Admin admin2 = (Admin)request.getAttribute("admin");
//		System.out.println(admin2);
		return "forward:/admin/Admin_EditAdmin.jsp";
	}

	@RequestMapping("/updateAdmin")
	public String updateAdmin(Admin admin) {
		
//		if (adminService.chickAdmin(admin.getAdminName()) > 0) {
//			request.setAttribute("successe", "<script>alert('该用户名已拥有');</script>");
//			admin.setAdminName("");
//			request.setAttribute("admin", admin);
//			return "/admin/Admin_EditAdmin";
//		}
		String password = MD5Util.getMD5(admin.getAdminPwd());
		admin.setAdminPwd(password);
		if (adminService.updateAdmin(admin) <= 0) {
			request.setAttribute("successe", "<script>alert('修改失败');</script>");
			return "/admin/Admin_EditAdmin";
		}

		request.setAttribute("success", "<script>alert('修改成功');</script>");
		return "forward:/findAllAdmin";
	}

	@RequestMapping("deleteAdmin")
	public String deleteAdmin(String id) {
		if (adminService.deleteAdmin(id) > 0) {
			request.setAttribute("success", "<script>alert('删除成功');</script>");
			return "forward:/findAllAdmin";
		}
		request.setAttribute("success", "<script>alert('删除失败');</script>");
		return "forward:/findAllAdmin";
	}

	@RequestMapping("deleteByIdsAdmin")
	public String deleteByIdsAdmin(String[] ck) {

		for (String ids : ck) {
			adminService.deleteAdmin(ids);
		}

		request.setAttribute("success", "<script>alert('批量删除成功');</script>");

		return "forward:/findAllAdmin";
	}
}
