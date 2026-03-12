package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.geekUserDao;
import com.example.geekUsers;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	  
	    geekUsers ge = new geekUsers();
	    ge.setBookname(request.getParameter("name"));
	    ge.setNumberOfbooks(Integer.parseInt(request.getParameter("numberOfPosts")));
	    ge.setAuthor(request.getParameter("techPreferred"));
	    ge.setBookId(Integer.parseInt(request.getParameter("id")));
	    
	    int status = geekUserDao.updateUser(ge);

	    
	    out.println("<html><head><style>");
	    out.println("body { margin: 0; height: 100vh; display: flex; justify-content: center; align-items: center; " +
	                "font-family: 'Segoe UI', sans-serif; " +
	                "background: linear-gradient(rgba(0,0,0,0.7), rgba(0,0,0,0.7)), " +
	                "url('https://tse3.mm.bing.net/th/id/OIP.ObImjoIMbB_ydK2bilL2HwHaE7?pid=Api&h=220&P=0'); " +
	                "background-size: cover; color: white; }");
	    
	    out.println(".alert-box { background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(10px); " +
	                "padding: 40px; border-radius: 15px; border: 1px solid rgba(255, 255, 255, 0.2); " +
	                "text-align: center; box-shadow: 0 10px 30px rgba(0,0,0,0.5); width: 320px; }");
	    
	    out.println(".btn { display: inline-block; margin-top: 15px; padding: 10px 25px; background: #ff9800; " +
	                "color: white; text-decoration: none; border-radius: 5px; font-weight: bold; transition: 0.3s; }");
	    out.println(".btn:hover { background: #e68a00; transform: scale(1.05); }");
	    out.println("</style></head><body>");

	    out.println("<div class='alert-box'>");
	    if(status > 0) {
	        out.println("<h2 style='color: #4CAF50;'>UPDATED!</h2>");
	        out.println("<p>Changes saved successfully.</p>");
	    } else {
	        out.println("<h2 style='color: #f44336;'>FAILED</h2>");
	        out.println("<p>Something went wrong while updating.</p>");
	    }
	    
	    out.println("<a href='viewServlets' class='btn'>VIEW UPDATED LIST</a>");
	    out.println("<br><br><a href='index.jsp' style='color: #ddd; text-decoration: none; font-size: 13px;'>Add Another Book</a>");
	    out.println("</div>");

	    out.println("</body></html>");
	    out.close();
	}

}

