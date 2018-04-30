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
public class forgetPasswordServlet extends HttpServlet {

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
        
        PrintWriter p = response.getWriter();
        
        try{
            p.print("YO");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
            Statement st = con.createStatement();
            
            String email=request.getParameter("fg");
            String seca=request.getParameter("answer");
            p.print("YO");
            ResultSet rs = st.executeQuery("select * from student");
            p.print("YO");
            boolean b=false;
            String xxx="";
            while(rs.next())
            {
                if(rs.getString("email").equals(email))
                {
                    b=true;
                    xxx=rs.getString("secanswer");
                    break;
                }
            }
            p.print("YO");
            if(b==true)
            {
                if(xxx.equals(seca))
                {
                    HttpSession ses = request.getSession(false);
                    if(ses!=null)
                        ses.invalidate();
                    HttpSession session = request.getSession(true);
                    session.setAttribute("uname",rs.getString("username"));
                    session.setAttribute("whatis","student");
                    session.setAttribute("actualname", rs.getString("name"));
                    RequestDispatcher rd = request.getRequestDispatcher("loggedIn.html");
                    rd.forward(request, response);
                }
                else
                {
                    RequestDispatcher rd = request.getRequestDispatcher("forget.html");
                    rd.include(request, response);
                    p.print("<font color='red'>ANSWER MISMATCH</font>");
                }
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
