package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.dao.UserDao;
import com.supermarket.entity.User;
import com.supermarket.service.UserService;
import com.supermarket.service.impl.UserServiceImpl;

public class userViewServlet extends HttpServlet {
	private static final String Date = null;
	UserService service = new UserServiceImpl();

	/**
	 * 显示全部用户信息,主页分页显示用户
	 * 
	 * @param request
	 * @param response
	 */
	private void allUser(HttpServletRequest request,
			HttpServletResponse response) {

		// 每页显示三条
		int pageSize = 3;
		// 默认显示第一页
		int pageIndex = 1;
		// 得到查询的内容
		String username = request.getParameter("username");
		if (username == null || "".equals(username)) {
			username = "%";
		} else {
			username = "%" + username + "%";
		}
		// 当前的页码
		String page_no = request.getParameter("page_no");
		if (page_no != null) {
			pageIndex = Integer.parseInt(page_no);
		}
		// 得到总页数
		int totalPages = service.getAllRocord(pageSize);

		// 对页码异常的处理
		if (pageIndex <= 0) {
			pageIndex = 1;
		}
		if (pageIndex > totalPages) {
			pageIndex = totalPages;
		}

		List<User> list = service.getAllUser(pageIndex, pageSize, username);
		request.setAttribute("list", list);// 把集合放在作用域当中；
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("totalPage", totalPages);

		try {
			request.getRequestDispatcher("user/userList.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 查看单个用户详细信息,
	 */
	private void selectUser(HttpServletRequest request,
			HttpServletResponse response) {

		String username = request.getParameter("sel");
		// System.out.println(username);
		User user = service.userSelcet(username);
		// System.out.println(user.getGender());

		request.setAttribute("user", user);

		// System.out.println(user);

		try {
			request.getRequestDispatcher("user/userView.jsp").forward(request,
					response);
			// response.sendRedirect("UserView.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 删除用户
	 */
	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String username = request.getParameter("remove");
		int row = service.deleteUser(username);
		if (row == 0) {
			out.print("<script>alert('删除失败！');window.location.href='userViewServlet?ac=selectAll'</script>");
			// response.sendRedirect("userList.jsp");
		} else {
			out.print("<script>alert('删除成功！');window.location.href='userViewServlet?ac=selectAll'</script>");
			// response.sendRedirect("userList.jsp");
		}

	}

	private void tankuang(HttpServletRequest request,
			HttpServletResponse response) {
		String rename = request.getParameter("remove");

		request.setAttribute("rename", rename);
		request.setAttribute("tan", 12);
		try {
			request.getRequestDispatcher("user/userList.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String result = request.getParameter("ac");
		// String uname=request.getParameter("sel");
		// System.out.println(result);
		String result2 = request.getParameter("tan");
		// System.out.println(result2);

		// 用户列表及分页
		if ("selectAll".equals(result)) {
			this.allUser(request, response);

			// 查看用户详情
		} else if ("select".equals(result)) {
			this.selectUser(request, response);

			/**
			 * 删除用户
			 */
		} else if ("del".equals(result)) {
			this.deleteUser(request, response);

		} else if ("tankuang".equals(result2)) {
			this.tankuang(request, response);

		}

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
	}

}
