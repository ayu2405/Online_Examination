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
public class loginServlet extends HttpServlet {

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
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        String slct = request.getParameter("st");
        try{
            if(slct.equals("s"))
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","tiger");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from student");
                boolean b=false;
                String actualname="";
                while(rs.next()==true)
                {
                    if(rs.getString("username").equals(uname) && rs.getString("userpassword").equals(upass))
                    {
                        b=true;
                        actualname=rs.getString("name");
                    }
                }
                if(b==true)
                {
                    HttpSession ses = request.getSession(false);
                    if(ses!=null)
                        ses.invalidate();
                    HttpSession session = request.getSession(true);
                    session.setAttribute("uname",uname);
                    session.setAttribute("whatis","student");
                    session.setAttribute("actualname", actualname);
                    
                   
                    String ct = session.getCreationTime()+"";
                    
                    st.executeUpdate("insert into logs values('"+ct+"','"+uname+"','notYet','student','"+session.getId()+"');");
                    p.print("YO");
                    RequestDispatcher rd = request.getRequestDispatcher("loggedIn.html");
                    rd.forward(request, response);
                }
                else
                {
                    RequestDispatcher rd2 = request.getRequestDispatcher("loginerror.html");
                    rd2.forward(request, response);
                }
            }
            else
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from teacher");
                boolean b=false;
                String actualname="";
                while(rs.next()==true)
                {
                    if(rs.getString("username").equals(uname) && rs.getString("teacherpassword").equals(upass))
                    {
                        b=true;
                        actualname=rs.getString("name");
                    }
                }
                if(b==true)
                {
                    HttpSession ses = request.getSession(false);
                    if(ses!=null)
                        ses.invalidate();
                    HttpSession session = request.getSession(true);
                    session.setAttribute("uname",uname);
                    session.setAttribute("whatis","teacher");
                    session.setAttribute("actualname", actualname);
                    
                    String ct = session.getCreationTime()+"";
                    
                    st.executeUpdate("insert into logs values('"+ct+"','"+uname+"','notYet','teacher','"+session.getId()+"');");
                    
                    RequestDispatcher rd = request.getRequestDispatcher("loggedInTeacher.html");
                    rd.forward(request, response);
                }
                else
                {
                    RequestDispatcher rd2 = request.getRequestDispatcher("loginerror.html");
                    rd2.forward(request, response);
                }
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
