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
public class forgetServlet extends HttpServlet {

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
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
            Statement st = con.createStatement();
            
            String email = request.getParameter("email");
            
            ResultSet rs = st.executeQuery("select * from student");
            
            boolean b=false;
            
            while(rs.next())
            {
                if(rs.getString("email").equals(email))
                {
                    b=true;
                    break;
                }
            }
            
            if(b==true)
            {
                p.print("<form action='forgetPasswordServlet' method='post'>"
                        +"<input type='text' readonly='' hidden='' name='fg' value='"+email+"'/>");
                p.print("<h2>SECURITY QUESTION : </h2><input type='text' value='"+rs.getString("secquestion")+"' required=''/>");
                p.print("<br><h1>ANSWER</h1><input type='text' name='answer'/>"
                        + "<input type='submit' value='VERIFY'>"
                        + "</form>");
                p.print("<a href='forget.html'>BACK</a>");
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("forget.html");
                 rd.include(request, response);
                 p.print("<font color='red'>EMAIL NOT FOUND!</font>");
            }
            
        }
        catch(Exception ex){}
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
