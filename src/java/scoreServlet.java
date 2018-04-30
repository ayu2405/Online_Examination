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
public class scoreServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        
        if(session==null)
        {
            RequestDispatcher rd= request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
        else
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                
                ResultSet rs = st.executeQuery("select * from result where username='"+session.getAttribute("uname").toString()+"';");
                
                p.print("<table cellspacing='2'>" 
                            + "<tr>"
                            + "<th>CATEGORY</td>"
                            + "<th>MARKS</td>"
                            + "<th>PERCENTAGE</td>"
                            + "<th>GRADE</td>"
                            + "</tr>");
                
                while(rs.next()==true)
                {
                    String a = rs.getString("category");
                    String b = rs.getString("marks");
                    
                    int marks = Integer.parseInt(b);
                    
                    double per = (double)marks/3*100;
                    
                    String pp = per+"";
                    if(pp.length()>4)
                    {
                        pp=pp.substring(0,4);
                    }
                    
                    String grade= "E";
                    
                    if(per<40)
                        grade="C";
                    else if(per<70)
                        grade="B";
                    else
                        grade="A";
                    
                    p.print("<tr>"
                            + "<td>"+a+"</td>"
                            + "<td>"+b+"</td>"
                            + "<td>"+pp+"</td>"
                            + "<td>"+grade+"</td>"
                            + "</tr>");
                    
                }
                p.print("</table>");
                
                p.print("<a href='loggedIn.html'>BACK</a>");
                
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
