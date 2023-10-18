package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.service.impl.NewService;
import com.laptrinhjavaweb.service.impl.UserService;
import com.laptrinhjavaweb.util.FormUtil;
import com.laptrinhjavaweb.util.SessionUtil;



@WebServlet(urlPatterns = { "/trang-chu","/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 2686801510274002166L;

	private ICategoryService categoryService = new CategoryService();
	
	private INewService newService = new NewService();
	
	private IUserService userService = new UserService();
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("categories",categoryService.findAll() );
		String action = req.getParameter("action");
		if(action != null && action.equals("login")){
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("view/login.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		}else {
		RequestDispatcher rd = req.getRequestDispatcher("view/web/home.jsp");
		rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")){
			UserModel user = FormUtil.toModel(UserModel.class, req);
			user = userService.findUsernamePasswordAndStatus(user.getUserName(), user.getPassword(), 1);
			if(user != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", user);
				if(user.getRole().getName().equals("USER")) {
					resp.sendRedirect(req.getContextPath()+"/trang-chu");
				}else if(user.getRole().getName().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath()+"/admin-home");
				}
			}else {
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&&message=username_password_invalid&&alert=danger");
			}
		}
	}

}
