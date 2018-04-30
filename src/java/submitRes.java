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
public class submitRes extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        if(session==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
        else
        {            
            if(session.getAttribute("type").toString().equals("real") && session.getAttribute("exam").toString().equals("java"))
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                    Statement st = con.createStatement();
                    
                    String arr1[] = (String[]) session.getAttribute("answers");
                    ResultSet rs = st.executeQuery("select * from realjava;");
                    
                    int marks=0;
                    int i=1;
                    
                    while(rs.next()==true)
                    {
                        String temp = rs.getString("ans");
                        if(temp.equals(arr1[i]))
                        {
                            marks++;
                        }
                        i++;
                    }
                    
                    p.print("YOUR SCORE : "+marks);
                    
                    st.executeUpdate("insert into result values('"+session.getAttribute("uname").toString()+"','java',"+marks+");");
                    //p.print("<form action='loggedIn.html'><input type='submit' value='PROCEED'/></form>");
                    p.print("<script>\n" +
"window.open(\"loggedIn.html\", \"_blank\");\n" +
"window.close();\n" +
"</script>");
                }
                catch(Exception ex){}
            }
            else if(session.getAttribute("type").toString().equals("sample") && session.getAttribute("exam").toString().equals("java"))
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                    Statement st = con.createStatement();
                    
                    String arr1[] = (String[]) session.getAttribute("answers");
                    ResultSet rs = st.executeQuery("select * from java;");
                    
                    int marks=0;
                    int i=1;
                    
                    while(rs.next()==true)
                    {
                        String temp = rs.getString("ans");
                        if(temp.equals(arr1[i]))
                        {
                            marks++;
                        }
                        i++;
                    }
                    
                    p.print("YOUR SCORE : "+marks);
                    
                    p.print("<form action='faltu'><input type='submit' onlick='' value='PROCEED'/></form>");
                }
                catch(Exception ex){}
            }
            else if(session.getAttribute("type").toString().equals("real") && session.getAttribute("exam").toString().equals("python"))
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                    Statement st = con.createStatement();
                    
                    String arr1[] = (String[]) session.getAttribute("answers");
                    ResultSet rs = st.executeQuery("select * from realpython;");
                    
                    int marks=0;
                    int i=1;
                    
                    while(rs.next()==true)
                    {
                        String temp = rs.getString("ans");
                        if(temp.equals(arr1[i]))
                        {
                            marks++;
                        }
                        i++;
                    }
                    
                    p.print("YOUR SCORE : "+marks);
                    
                    st.executeUpdate("insert into result values('"+session.getAttribute("uname").toString()+"','python',"+marks+");");
                    //p.print("<form action='loggedIn.html'><input type='submit' value='PROCEED'/></form>");
                    p.print("<script>\n" +
"window.open(\"loggedIn.html\", \"_blank\");\n" +
"window.close();\n" +
"</script>");
                }
                catch(Exception ex){}
            }
            else if(session.getAttribute("type").toString().equals("sample") && session.getAttribute("exam").toString().equals("python"))
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                    Statement st = con.createStatement();
                    
                    String arr1[] = (String[]) session.getAttribute("answers");
                    ResultSet rs = st.executeQuery("select * from python;");
                    
                    int marks=0;
                    int i=1;
                    
                    while(rs.next()==true)
                    {
                        String temp = rs.getString("ans");
                        if(temp.equals(arr1[i]))
                        {
                            marks++;
                        }
                        i++;
                    }
                    
                    p.print("YOUR SCORE : "+marks);
                    p.print("<form action='faltu'><input type='submit' onlick='' value='PROCEED'/></form>");
                    //p.print("<!--<form action='loggedIn.html'>--><input type='submit' value='PROCEED' onclick=\"window.open(\"loggedIn.html\", \"_blank\", \"width=200 height=100\");window.close\"/><!--</form>-->");
                }
                catch(Exception ex){}
            }
            else if(session.getAttribute("type").toString().equals("real") && session.getAttribute("exam").toString().equals("c"))
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                    Statement st = con.createStatement();
                    
                    String arr1[] = (String[]) session.getAttribute("answers");
                    ResultSet rs = st.executeQuery("select * from realc;");
                    
                    int marks=0;
                    int i=1;
                    
                    while(rs.next()==true)
                    {
                        String temp = rs.getString("ans");
                        if(temp.equals(arr1[i]))
                        {
                            marks++;
                        }
                        i++;
                    }
                    
                    p.print("YOUR SCORE : "+marks);
                   
                    st.executeUpdate("insert into result values('"+session.getAttribute("uname").toString()+"','c',"+marks+");");
                    //p.print("<form action='loggedIn.html'><input type='submit' value='PROCEED'/></form>");
                    p.print("<script>\n" +
"window.open(\"loggedIn.html\", \"_blank\");\n" +
"window.close();\n" +
"</script>");
                }
                catch(Exception ex){}
            }
            else if(session.getAttribute("type").toString().equals("sample") && session.getAttribute("exam").toString().equals("c"))
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                    Statement st = con.createStatement();
                    
                    String arr1[] = (String[]) session.getAttribute("answers");
                    ResultSet rs = st.executeQuery("select * from c;");
                    
                    int marks=0;
                    int i=1;
                    
                    while(rs.next()==true)
                    {
                        String temp = rs.getString("ans");
                        if(temp.equals(arr1[i]))
                        {
                            marks++;
                        }
                        i++;
                    }
                    
                    p.print("YOUR SCORE : "+marks);
                    p.print("<form action='faltu><input type='submit' value='PROCEED'/></form>");
                }
                catch(Exception ex){}
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
