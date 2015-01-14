package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userservice.UserListService;
import userservice.UserModifyService;
import userservice.userserviceimpl.ListUserModify;
import userservice.userserviceimpl.UserListServiceImpl;
import userservice.userserviceimpl.UserModifyServiceImpl;

public class ControllerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String path = req.getServletPath();
		path = path.substring(0, path.indexOf("."));
		System.out.println(path);
		if("/userManage".equals(path))
		{
			try
			{
				UserListService  service = new UserListServiceImpl();
				List list = service.getUserList();
				req.setAttribute("userList", list);				
				getServletContext().getRequestDispatcher("/userManage").forward(req, resp);								
			}catch(Exception e)
			{				
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req, resp);								
			}
		}else if("/userModify".equals(path))
			{
			try
			{
				UserModifyService service = new UserModifyServiceImpl();
				List list = service.getUserModifyList();							
				req.setAttribute("userModify", list);				
				getServletContext().getRequestDispatcher("/userModify").forward(req, resp);								
			}catch(Exception e)
			{				
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req, resp);								
			}
			
			}else if("/productDetail".equals(path))
			{
			try
			{
				UserModifyService service = new UserModifyServiceImpl();
				List list = service.getUserModifyList();							
				req.setAttribute("productDetail", list);				
				getServletContext().getRequestDispatcher("/productDetail").forward(req, resp);								
			}catch(Exception e)
			{				
				req.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req, resp);								
			}
			
			}
		else if("/productList".equals(path))
		{
		try
		{
			UserModifyService service = new UserModifyServiceImpl();
			List list = service.getUserModifyList();							
			req.setAttribute("productList", list);				
			getServletContext().getRequestDispatcher("/productList").forward(req, resp);								
		}catch(Exception e)
		{				
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher("/error").forward(req, resp);								
		}
		
		}
		else
		{
			resp.sendError(resp.SC_NOT_FOUND);
			//resp.sendError(404);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	}

}
