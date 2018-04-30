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
public class inbox3 extends HttpServlet {

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
        p.print("<head><style>table {align:center;border-collapse: collapse;width: 100%;}th, td {text-align: left;padding: 8px;}tr:nth-child(even){background-color: #f2f2f2}th {background-color: #4CAF50;color: white;}</style></head>");
        
        
        HttpSession session = request.getSession(false);
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
                
                p.print("<table cellspacing='2'>" 
                            + "<tr>"
                            + "<th>Name</td>"
                            + "<th>Message</td>"
                            + "</tr>");
                
                ResultSet rs = st.executeQuery("select * from inbox where toz='"+session.getAttribute("uname").toString()+"';");

                
                while(rs.next()==true)
                {
                    p.print("<tr>"
                            + "<td>"+rs.getString("name")+"</td>"
                            + "<td>"+rs.getString("message")+"</td>"
                            + "</tr>");
                }
                p.print("</table>");
                if(session.getAttribute("whatis").toString().equals("teacher"))
                {
                    p.print("<a href='contactUs.html'>REPLY</a> &nbsp;");
                    p.print("<a href='loggedInTeacher.html'>BACK</a>");
                }
                else
                {
                    p.print("<a href='contactstud.html'>REPLY</a> &nbsp;");
                    p.print("<a href='loggedIn.html'>BACK</a>");
                }
                
            }
            catch(Exception ex)
            {}
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
