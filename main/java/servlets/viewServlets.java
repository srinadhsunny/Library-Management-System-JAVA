package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.geekUserDao;
import com.example.geekUsers;

/**
 * Servlet implementation class viewServlets
 */
@WebServlet("/viewServlets")
public class viewServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<style>");
        // Main Background and Layout
        out.println("body { margin: 0; padding: 20px; display: flex; flex-direction: column; align-items: center; " +
                    "font-family: 'Segoe UI', sans-serif; " +
                    "background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), " +
                    "url('https://tse3.mm.bing.net/th/id/OIP.ObImjoIMbB_ydK2bilL2HwHaE7?pid=Api&h=220&P=0'); " +
                    "background-size: cover; background-attachment: fixed; color: white; }");

        // The Glass Frame
        out.println(".container { background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(10px); " +
                    "padding: 30px; border-radius: 15px; border: 1px solid rgba(255, 255, 255, 0.2); " +
                    "box-shadow: 0 8px 32px rgba(0, 0, 0, 0.5); width: 85%; margin-top: 20px; }");

        // Professional Table Styling
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 15px; }");
        out.println("th { background: #ff9800; color: white; padding: 12px; text-align: left; }");
        out.println("td { padding: 12px; border-bottom: 1px solid rgba(255, 255, 255, 0.1); }");
        out.println("tr:hover { background: rgba(255, 255, 255, 0.05); }");

        // Link Buttons
        out.println(".add-link { text-decoration: none; background: #ff9800; color: white; padding: 10px 20px; " +
                    "border-radius: 5px; font-weight: bold; margin-bottom: 10px; display: inline-block; }");
        out.println(".action-link { color: #ff9800; text-decoration: none; margin-right: 10px; font-weight: bold; }");
        out.println("</style></head><body>");

        out.println("<a href='index.jsp' class='add-link'>+ ADD NEW BOOK</a>");
        
        out.println("<div class='container'>");
        out.println("<h1 style='letter-spacing: 2px;'>LIST OF BOOKS</h1>");
        
        List<geekUsers> list = geekUserDao.getAllUsers();
        
        out.println("<table>");
        out.print("<tr><th>ID</th><th>Book Name</th><th>Copies</th><th>Author</th><th>Edit</th><th>Delete</th></tr>");
        
        for(geekUsers e : list) {
            out.print("<tr><td>"+e.getBookId()+"</td><td>"+e.getBookname()+"</td><td>"+e.getNumberOfbooks()+"</td><td>"+e.getAuthor()+
                    "</td><td><a class='action-link' href='EditServlet?id="+e.getBookId()+"'>Edit</a></td>" +
                    "<td><a class='action-link' style='color:#ff4444;' href='DeleteUser?id="+e.getBookId()+"'>Delete</a></td></tr>");
        }
        
        out.print("</table>");
        out.println("</div>"); // Close Container
        out.println("<br><a href='home.jsp' style='color: white; text-decoration: none; font-size: 14px;'>← Back to Home</a>");
        out.println("</body></html>");
        out.close();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
