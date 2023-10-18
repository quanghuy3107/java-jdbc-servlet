package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.impl.NewService;
import com.laptrinhjavaweb.util.HttpUtil;

/**
 * Servlet implementation class NewApi
 */
@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       @Inject 
     INewService newService = new NewService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("application/json");
		NewsModel newsmodel = 	HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		System.out.println(newsmodel.toString());

		newsmodel = newService.save(newsmodel);
		
		mapper.writeValue(response.getOutputStream(), newsmodel);
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("application/json");
		NewsModel updateNews = 	HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		System.out.println(updateNews.toString());
//		newService = new NewService();
		updateNews = newService.update(updateNews);
		
		mapper.writeValue(response.getOutputStream(), updateNews);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(request, response);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("application/json");
		NewsModel newModel = 	HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		System.out.println(newModel.toString());
//		newService = new NewService();
		newService.delete(newModel.getNews_ids());
		
		mapper.writeValue(response.getOutputStream(), "{}");
	}
	private void SaveOrUpdate() {
		
	}
}
