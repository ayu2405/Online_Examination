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
public class registerServlet extends HttpServlet {

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
        
        String name=request.getParameter("name");
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        String uemail = request.getParameter("uemail");
        String sq = request.getParameter("st");
        String ans = request.getParameter("ans");
        String college = request.getParameter("college");
        if(college.equals(""))
            college="COLLEGE NOT YET REGISTERED";
        try{
            //p.print("");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","tiger");
        Statement st = con.createStatement();
        //p.print("yo");
        
        ResultSet rs = st.executeQuery("select * from student");
        boolean b = false,c=false;
        while(rs.next()==true)
        {
            if(rs.getString("username").equals(uname))
            {
                b=true;
                break;
            }
            if(rs.getString("email").equals(uemail))
            {
                c=true;
                break;
            }
        }
        
        if(b==false && c==false)
        {
            st.executeUpdate("insert into student values('"+name+"','"+uname+"','"+upass+"','"+college+"','"+uemail+"','"+sq+"','"+ans+"');");
            
            HttpSession ses =  request.getSession(false);
            if(ses!=null)
                ses.invalidate();
            HttpSession session =  request.getSession(true);
            session.setAttribute("uname",uname);
            session.setAttribute("actualname", name);
            RequestDispatcher rd1 = request.getRequestDispatcher("loggedIn.html");
            rd1.forward(request, response);
        }
        else if(b==true)
        {
            RequestDispatcher rd = request.getRequestDispatcher("registererror.html");
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("registererror1.html");
            rd.forward(request, response);
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
