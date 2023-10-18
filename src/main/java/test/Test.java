package test;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.impl.CategoryDAO;
import com.laptrinhjavaweb.dao.impl.NewDao;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.impl.NewService;

public class Test {
	public static void main(String[] args) {
		INewService sv;
		
//		List<NewsModel> list = new ArrayList<>();
//		CategoryModel ct = new CategoryModel();
//		ct.setCategory_id(1L);
//		NewDao ctd = new NewDao();
//		
//		list = ctd.findByCategoryId(ct.getCategory_id());
//		
//		for (NewsModel newsModel : list) {
//			System.out.println(newsModel.toString());
//		}
		sv = new NewService();
		NewsModel md = new NewsModel();
		md.setNews_id(1L);
		md.setTitle("Bai viet 2");
		md.setThumbnail("link anh");
		md.setShortDescription("bai viet1");
		md.setContent("bai bviet 2");
		md.setCategory_Id(1L);
		
		sv.update(md);
//		NewDao nd = new NewDao();

//		List<NewsModel> news =  sv.findAll(5, 0, "title", "desc");
//		for (NewsModel newsModel : news) {
//			System.out.println(newsModel.toString());
//		}
	}
}
