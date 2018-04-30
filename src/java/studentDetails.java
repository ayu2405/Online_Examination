/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hppc
 */
public class studentDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter p =response.getWriter();
        p.print("<html>\n" +
"<head>\n" +
"<style>\n" +
"\n" +
"h1 {\n" +
"  	font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"  	font-weight:700;\n" +
"  	font-style:italic;\n" +
"}\n" +
"\n" +
".form {\n" +
"	\n" +
"  	float: left;\n" +
"}\n" +
"\n" +
".border {\n" +
" 	 border: 2px solid #009;\n" +
"  	-webkit-border-radius: 10px;\n" +
"  	-moz-border-radius: 10px;\n" +
"  	border-radius: 10px;\n" +
"  	-webkit-box-shadow: 4px 4px 5px rgba(50, 50, 50, 0.75);\n" +
"  	-moz-box-shadow: 4px 4px 5px rgba(50, 50, 50, 0.75);\n" +
"  	box-shadow: 4px 4px 5px rgba(50, 50, 50, 0.75);\n" +
"}\n" +
"\n" +
"</style>\n" +
"</head>");
        
        
        
        HttpSession session = request.getSession();
        if(session==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
        else
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();

                p.print("<body><form><fieldset><legend><h2>USER DETAILS</h2></legend><table width=\"40%\" cellspacing=\"10px\">");
                
                ResultSet rs = st.executeQuery("select * from student where username='"+session.getAttribute("uname").toString()+"';");
                String name="",uname="",password="",college="",email="",secq="",seca="";
                if(rs.next()==true)
                {
                    name = rs.getString("name");
                    password = rs.getString("userpassword");
                    college = rs.getString("college");
                    email = rs.getString("email");
                    uname = rs.getString("username");
                    secq = rs.getString("secquestion");
                    seca = rs.getString("secanswer");
                }
                p.print("<tr><td><label>NAME</label></td>\n" +
"	    <td><input type=\"text\" value="+name+" readonly /></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><label>User name</label></td>\n" +
"	    <td><input type=\"text\" value="+uname+" readonly /></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><label>Password</label></td>\n" +
"	    <td><input type=\"text\" value="+password+" readonly /></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><label>Email</label></td>\n" +
"	    <td><input type=\"text\" value="+email+" readonly /></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><label>College</label></td>\n" +
"	    <td><input type=\"text\" value="+college+" readonly /></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><label>Security Question</label></td>\n" +
"	    <td><input type=\"text\" value="+secq+" readonly /></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><label>Security Answer</label></td>\n" +
"	    <td><input type=\"text\" value="+seca+" readonly /></td>\n" +
"	</tr>\n" +
"    </table>      \n" +
"    </fieldset>\n" +
"  </form>\n" +
"</body>\n" +
"</html>");
                //p.print(name+"<br>"+password+"<br>"+college+"<br>"+email+"<br>");
                p.print("<form action='studentDetailsModify'>"
                        + "<input type='submit' value='MODIFY' name='modify'/>"
                        + " &nbsp; "
                        + "<input type='submit' value='BACK' name='back'/>"
                        + "</form>");
            }
            catch(Exception ex){}
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
