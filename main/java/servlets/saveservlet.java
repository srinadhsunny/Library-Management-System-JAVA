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
 * Servlet implementation class saveservlet
 */
@WebServlet("/saveservlet")
public class saveservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        // 1. Get parameters (Note: I kept your variable names so your DAO works)
	        String name = request.getParameter("name");
	        int numberOfPosts = Integer.parseInt(request.getParameter("quantity")); // Matched to new JSP name
	        String techPreferred = request.getParameter("author"); // Matched to new JSP name
	        
	        geekUsers e = new geekUsers();
	        e.setBookname(name);
	        e.setNumberOfbooks(numberOfPosts);
	        e.setAuthor(techPreferred);
	        
	        int status = geekUserDao.saveuser(e);

	        // 2. Start Styled Output
	        out.println("<html><head><style>");
	        out.println("body { margin: 0; padding: 0; height: 100vh; display: flex; justify-content: center; align-items: center; " +
	                    "font-family: 'Segoe UI', sans-serif; " +
	                    "background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), " +
	                    "url('https://tse3.mm.bing.net/th/id/OIP.ObImjoIMbB_ydK2bilL2HwHaE7?pid=Api&h=220&P=0'); " +
	                    "background-size: cover; background-position: center; color: white; }");
	        
	        out.println(".msg-frame { background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(15px); " +
	                    "padding: 40px; border-radius: 20px; border: 1px solid rgba(255, 255, 255, 0.2); " +
	                    "text-align: center; box-shadow: 0 15px 35px rgba(0, 0, 0, 0.5); width: 350px; }");
	        
	        out.println(".btn { display: inline-block; margin-top: 20px; padding: 10px 30px; background: #ff9800; " +
	                    "color: white; text-decoration: none; border-radius: 50px; font-weight: bold; transition: 0.3s; }");
	        out.println(".btn:hover { background: #e68a00; transform: scale(1.05); }");
	        out.println("</style></head><body>");

	        out.println("<div class='msg-frame'>");
	        if(status > 0) {
	            out.println("<h2 style='color: #4CAF50;'>✔ SUCCESS!</h2>");
	            out.println("<p>The book '<strong>" + name + "</strong>' has been added to the library.</p>");
	        } else {
	            out.println("<h2 style='color: #f44336;'>✖ ERROR</h2>");
	            out.println("<p>Sorry, we couldn't save the book. Please try again.</p>");
	        }
	        
	        out.println("<a href='viewServlets' class='btn'>VIEW ALL BOOKS</a>");
	        out.println("<br><br><a href='home.jsp' style='color: #ddd; text-decoration: none; font-size: 14px;'>Back to Home</a>");
	        out.println("</div>");
	        
	        out.println("</body></html>");
	        out.close();
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	

}
