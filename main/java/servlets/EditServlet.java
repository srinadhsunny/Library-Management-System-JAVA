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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int id = Integer.parseInt(request.getParameter("id"));
        geekUsers e = geekUserDao.getGeekUserById(id);

        out.println("<html><head><style>");
        
        out.println("body { font-family: sans-serif; height: 100vh; display: flex; justify-content: center; align-items: center; " +
                    "margin: 0; background: linear-gradient(rgba(0,0,0,0.7), rgba(0,0,0,0.7)), " +
                    "url('https://tse3.mm.bing.net/th/id/OIP.ObImjoIMbB_ydK2bilL2HwHaE7?pid=Api&h=220&P=0'); " +
                    "background-size: cover; color: white; }");
        
        out.println(".card { background: rgba(255,255,255,0.1); backdrop-filter: blur(10px); padding: 30px; " +
                    "border-radius: 15px; border: 1px solid rgba(255,255,255,0.2); width: 350px; }");
        
        out.println("input { width: 100%; padding: 8px; margin: 5px 0; border-radius: 5px; border: none; }");
        
        out.println(".save-btn { background: #ff9800; color: white; font-weight: bold; cursor: pointer; margin-top: 15px; }");
        out.println("</style></head><body>");

        out.println("<div class='card'>");
        out.println("<h2 style='text-align:center; color:#ff9800;'>UPDATE BOOK</h2>");
        
        out.print("<form action='EditServlet2' method='post'>");
        out.print("<input type='hidden' name='id' value='"+e.getBookId()+"'/>");
        
        out.print("Name:<br><input type='text' name='name' value='"+e.getBookname()+"'/>");
        out.print("<br>Copies:<br><input type='number' name='numberOfPosts' value='"+e.getNumberOfbooks()+"'/>");
        out.print("<br>Author:<br><input type='text' name='techPreferred' value='"+e.getAuthor()+"'/>");
        
        out.print("<input type='submit' value='UPDATE & SAVE' class='save-btn'>");
        out.print("</form>");
        
        out.println("<div style='text-align:center; margin-top:15px;'><a href='viewServlets' style='color:#ddd; text-decoration:none; font-size:12px;'>Cancel</a></div>");
        out.println("</div>"); // Close card
        
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
