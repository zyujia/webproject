package com.oracle.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oracle.entity.Goods;
import com.oracle.entity.Images;
import com.oracle.entity.Type;
import com.oracle.exception.FileNameException;
import com.oracle.exception.HeadInfoException;
import com.oracle.service.GoodsService;
import com.oracle.utils.FileUtils;
import com.oracle.utils.SnUtils;
import com.oracle.utils.UUIDUtils;
@WebServlet("/admin/goods/save")
@MultipartConfig
public class AdminGoodsSave extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		Integer num=Integer.parseInt(request.getParameter("num"));
		Integer type=Integer.parseInt(request.getParameter("type"));
		Double price=Double.parseDouble(request.getParameter("price"));
		Part coverImgPart=request.getPart("coverImg");
		String headInfo=coverImgPart.getHeader("Content-Disposition");
		String path=this.getServletContext().getRealPath("/")+"upload/";
		try {
			String fileName=FileUtils.getFileName(headInfo);
			String suffix=FileUtils.getSuffix(fileName);
			String uuidName=UUIDUtils.getUUID()+suffix;
			coverImgPart.write(path+uuidName);
			Type t=new Type(type, null);
			Goods goods=new Goods(null, name, num, price, t, uuidName, null, SnUtils.getGoodsSn());
			Collection<Part> imgParts=request.getParts();//表单元素所有name名称
			Images images=null;
			List<Images> lsImages=new ArrayList<Images>();
			for (Part part : imgParts) {
				if ("img".equals(part.getName())) {
					String imgHeaderInfo=part.getHeader("Content-Disposition");
					String imgFileName=FileUtils.getFileName(imgHeaderInfo);
					String imgSuffix=FileUtils.getSuffix(imgFileName);
					String newImgUUIDName=UUIDUtils.getUUID()+imgSuffix;
					part.write(path+newImgUUIDName);
					images=new Images(null, newImgUUIDName, null);
					lsImages.add(images);
				}
			}
			goods.setListImages(lsImages);
			GoodsService gs=new GoodsService();
			gs.save(goods);
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		} catch (HeadInfoException e) {
			e.printStackTrace();
		} catch (FileNameException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
