package reivax.norac.website.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.caches.UserCache;
import reivax.norac.website.dto.UsersDTO;
import reivax.norac.website.util.CommonsUtils;

/**
 * Servlet implementation class SigninServlet
 */
//@WebServlet(name="/Login", urlPatterns={"/LoginAction"})
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		List<UsersDTO> users = UserCache.getInstance().getAll();
		Map<String, UsersDTO> usersMap = CommonsUtils.getUsersMapByLogin(users);
		
		if(login != null && password != null
			&& usersMap.containsKey(login)){
			UsersDTO u = usersMap.get(login);
			if(u.getPassword().equals(password) && u.isAdmin()){
				request.getSession().setAttribute("isLogged", Boolean.TRUE);
			}
		}
		RequestDispatcher disp = request.getRequestDispatcher("Home");
		disp.forward(request, response);
	}

}
