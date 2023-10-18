package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.impl.NewService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.util.FormUtil;

/**
 * Servlet implementation class NewController
 */
@WebServlet("/admin-new")


public class NewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private INewService newService = new NewService();
	
    public NewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsModel model = FormUtil.toModel(NewsModel.class, request);
		
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		
		model.setListResult(newService.findAll(pageble));
		System.out.println(model.getSortName() + " " +  model.getSortBy());
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		
		request.setAttribute(SystemConstant.MODEL, model);
		
		System.out.println("hoan thanh");
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = request.getRequestDispatcher("view/admin/new/list.jsp");
		rd.forward(request, response);
		System.out.println("hoan thanh");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
