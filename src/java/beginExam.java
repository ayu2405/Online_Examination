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
public class beginExam extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        
        if(session==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
        else if(request.getParameter("java")!=null)
        {
            session.setAttribute("counter",0);
            session.setAttribute("exam","java");
            //RequestDispatcher rd = request.getRequestDispatcher("exam");
            //rd.forward(request, response);
            if(session.getAttribute("type").toString().equals("real"))
            {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
            Statement st = con.createStatement();
            p.print("YO");
            ResultSet rs = st.executeQuery("select * from result where username='"+session.getAttribute("uname").toString()+"' and category='java';");
            p.print("YO");
            if(rs.next()==true)
            {
                RequestDispatcher rd = request.getRequestDispatcher("givenExam.html");
                rd.forward(request, response);
            }
            else
            {
                   p.print("<script>window.open(\"exam\", \"_blank\", \"fullscreen=yes\");\n" +
"    window.close();</script>");
            }
        }
        catch(Exception ex){}
            }
            else
            {
                 p.print("<script>window.open(\"exam\", \"_blank\", \"fullscreen=yes\");\n" +
"    window.close();</script>");
            }
        }
        else if(request.getParameter("python")!=null)
        {
            session.setAttribute("counter",0);
            session.setAttribute("exam","python");
            if(session.getAttribute("type").toString().equals("real"))
            {
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from result where username='"+session.getAttribute("uname").toString()+"' and category='python';");
            if(rs.next()==true)
            {
                RequestDispatcher rd = request.getRequestDispatcher("givenExam.html");
                rd.forward(request, response);
            }
            else
            {
                   p.print("<script>window.open(\"exam\", \"_blank\", \"fullscreen=yes\");\n" +
"    window.close();</script>");
            }
        }
        catch(Exception ex){}
        }
            else
            {
                p.print("<script>window.open(\"exam\", \"_blank\", \"fullscreen=yes\");\n" +
"    window.close();</script>");
            }
        }
        else
        {
            session.setAttribute("counter",0);
            session.setAttribute("exam","c");
            if(session.getAttribute("type").toString().equals("real"))
            {
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from result where username='"+session.getAttribute("uname").toString()+"' and category='c';");
            if(rs.next()==true)
            {
                RequestDispatcher rd = request.getRequestDispatcher("givenExam.html");
                rd.forward(request, response);
            }
            else
            {
                   p.print("<script>window.open(\"exam\", \"_blank\", \"fullscreen=yes\");\n" +
"    window.close();</script>");
            }
        }
        catch(Exception ex){}
            }
            else
            {
                 p.print("<script>window.open(\"exam\", \"_blank\", \"fullscreen=yes\");\n" +
"    window.close();</script>");
            }
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
