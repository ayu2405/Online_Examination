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
public class exam extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String array[];
    
    @Override
    public void init()
    {
        array = new String[4];
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter p =response.getWriter();
        
        HttpSession session  = request.getSession(false);
        if(session==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
        else if(session.getAttribute("exam").toString().equals("java") && session.getAttribute("type").toString().equals("real") )
        {
            RequestDispatcher rdd=request.getRequestDispatcher("newjsp.jsp");
            rdd.include(request, response);
            try{
                
                int i = Integer.parseInt(session.getAttribute("counter").toString());
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                
                if(request.getParameter("opt")!=null)
                {
                    array[i]=request.getParameter("opt");
                }
                else
                    array[i]="e";
                
                i++;
                session.setAttribute("counter",i);
           
                if(i==4)
                {
                    i=0;
                    session.setAttribute("counter",0);
                    session.setAttribute("answers", array);
                    RequestDispatcher rd = request.getRequestDispatcher("submitRes");
                    rd.forward(request, response);
                }

                p.print("<form action='exam'>");

                String name="",a="",b="",c="",d="";

                ResultSet rs = st.executeQuery("select * from realjava where id ="+i);

                if(rs.next()==true){
                    name = rs.getString("question");
                    a=rs.getString("opta");
                    b=rs.getString("optb");
                    c=rs.getString("optc");
                    d=rs.getString("optd");
                }
                    p.print(name+"<br><hr>");
                    
                    p.print("<input type='radio' name='opt' value='a'/>"+a+"<br>");
                    p.print("<input type='radio' name='opt' value='b'/>"+b+"<br>");
                    p.print("<input type='radio' name='opt' value='c'/>"+c+"<br>");
                    p.print("<input type='radio' name='opt' value='d'/>"+d+"<br>");

                if(i<3)
                    p.printf("<input type='submit' value='NEXT' name='act1'/>");
                else
                    p.printf("<input type='submit' value='FINISH' name='act3'/>");
               p.printf("</form>");
                    }
            catch(Exception ex){}
        }
        else if(session.getAttribute("exam").toString().equals("java") && session.getAttribute("type").toString().equals("sample") )
        {
            try{
                RequestDispatcher rdd=request.getRequestDispatcher("newjsp.jsp");
            rdd.include(request, response);
            
            int i = Integer.parseInt(session.getAttribute("counter").toString());
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                
                if(request.getParameter("opt")!=null)
                {
                    array[i]=request.getParameter("opt");
                }
                else
                    array[i]="e";
                
                i++;
                session.setAttribute("counter",i);
           
                if(i==4)
                {
                    i=0;
                    session.setAttribute("counter",0);
                    session.setAttribute("answers", array);
                    RequestDispatcher rd = request.getRequestDispatcher("submitRes");
                    rd.forward(request, response);
                }

                p.print("<form action='exam'>");

                String name="",a="",b="",c="",d="";

                ResultSet rs = st.executeQuery("select * from java where id ="+i);

                if(rs.next()==true){
                    name = rs.getString("question");
                    a=rs.getString("opta");
                    b=rs.getString("optb");
                    c=rs.getString("optc");
                    d=rs.getString("optd");
                }
                    p.print(name+"<br><hr>");
                    
                    p.print("<input type='radio' name='opt' value='a'/>"+a+"<br>");
                    p.print("<input type='radio' name='opt' value='b'/>"+b+"<br>");
                    p.print("<input type='radio' name='opt' value='c'/>"+c+"<br>");
                    p.print("<input type='radio' name='opt' value='d'/>"+d+"<br>");

                if(i<3)
                    p.printf("<input type='submit' value='NEXT' name='act1'/>");
                else
                    p.printf("<input type='submit' value='FINISH' name='act3'/>");
                   p.printf("</form>");
                    }
            catch(Exception ex){}
        }
        else if(session.getAttribute("exam").toString().equals("python") && session.getAttribute("type").toString().equals("real") )
        {
            try{
                RequestDispatcher rdd=request.getRequestDispatcher("newjsp.jsp");
            rdd.include(request, response);
            
            int i = Integer.parseInt(session.getAttribute("counter").toString());
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                
                if(request.getParameter("opt")!=null)
                {
                    array[i]=request.getParameter("opt");
                }
                else
                    array[i]="e";
                
                i++;
                session.setAttribute("counter",i);
           
                if(i==4)
                {
                    i=0;
                    session.setAttribute("counter",0);
                    session.setAttribute("answers", array);
                    RequestDispatcher rd = request.getRequestDispatcher("submitRes");
                    rd.forward(request, response);
                }

                p.print("<form action='exam'>");

                String name="",a="",b="",c="",d="";

                ResultSet rs = st.executeQuery("select * from realpython where id ="+i);

                if(rs.next()==true){
                    name = rs.getString("question");
                    a=rs.getString("opta");
                    b=rs.getString("optb");
                    c=rs.getString("optc");
                    d=rs.getString("optd");
                }
                    p.print(name+"<br><hr>");
                    
                    p.print("<input type='radio' name='opt' value='a'/>"+a+"<br>");
                    p.print("<input type='radio' name='opt' value='b'/>"+b+"<br>");
                    p.print("<input type='radio' name='opt' value='c'/>"+c+"<br>");
                    p.print("<input type='radio' name='opt' value='d'/>"+d+"<br>");

                if(i<3)
                    p.printf("<input type='submit' value='NEXT' name='act1'/>");
                else
                    p.printf("<input type='submit' value='FINISH' name='act3'/>");
                   p.printf("</form>");
                    }
            catch(Exception ex){}
        }
        else if(session.getAttribute("exam").toString().equals("python") && session.getAttribute("type").toString().equals("sample") )
        {
            try{
                RequestDispatcher rdd=request.getRequestDispatcher("newjsp.jsp");
            rdd.include(request, response);
            
            int i = Integer.parseInt(session.getAttribute("counter").toString());
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                
                if(request.getParameter("opt")!=null)
                {
                    array[i]=request.getParameter("opt");
                }
                else
                    array[i]="e";
                
                i++;
                session.setAttribute("counter",i);
           
                if(i==4)
                {
                    i=0;
                    session.setAttribute("counter",0);
                    session.setAttribute("answers", array);
                    RequestDispatcher rd = request.getRequestDispatcher("submitRes");
                    rd.forward(request, response);
                }

                p.print("<form action='exam'>");

                String name="",a="",b="",c="",d="";

                ResultSet rs = st.executeQuery("select * from python where id ="+i);

                if(rs.next()==true){
                    name = rs.getString("question");
                    a=rs.getString("opta");
                    b=rs.getString("optb");
                    c=rs.getString("optc");
                    d=rs.getString("optd");
                }
                    p.print(name+"<br><hr>");
                    
                    p.print("<input type='radio' name='opt' value='a'/>"+a+"<br>");
                    p.print("<input type='radio' name='opt' value='b'/>"+b+"<br>");
                    p.print("<input type='radio' name='opt' value='c'/>"+c+"<br>");
                    p.print("<input type='radio' name='opt' value='d'/>"+d+"<br>");

                if(i<3)
                    p.printf("<input type='submit' value='NEXT' name='act1'/>");
                else
                    p.printf("<input type='submit' value='FINISH' name='act3'/>");
                   p.printf("</form>");
                    }
            catch(Exception ex){}
        }
        else if(session.getAttribute("exam").toString().equals("c") && session.getAttribute("type").toString().equals("real") )
        {
            try{
                RequestDispatcher rdd=request.getRequestDispatcher("newjsp.jsp");
            rdd.include(request, response);
            
            int i = Integer.parseInt(session.getAttribute("counter").toString());
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                
                if(request.getParameter("opt")!=null)
                {
                    array[i]=request.getParameter("opt");
                }
                else
                    array[i]="e";
                
                i++;
                session.setAttribute("counter",i);
           
                if(i==4)
                {
                    i=0;
                    session.setAttribute("counter",0);
                    session.setAttribute("answers", array);
                    RequestDispatcher rd = request.getRequestDispatcher("submitRes");
                    rd.forward(request, response);
                }

                p.print("<form action='exam'>");

                String name="",a="",b="",c="",d="";

                ResultSet rs = st.executeQuery("select * from realc where id ="+i);

                if(rs.next()==true){
                    name = rs.getString("question");
                    a=rs.getString("opta");
                    b=rs.getString("optb");
                    c=rs.getString("optc");
                    d=rs.getString("optd");
                }
                    p.print(name+"<br><hr>");
                    
                    p.print("<input type='radio' name='opt' value='a'/>"+a+"<br>");
                    p.print("<input type='radio' name='opt' value='b'/>"+b+"<br>");
                    p.print("<input type='radio' name='opt' value='c'/>"+c+"<br>");
                    p.print("<input type='radio' name='opt' value='d'/>"+d+"<br>");

                if(i<3)
                    p.printf("<input type='submit' value='NEXT' name='act1'/>");
                else
                    p.printf("<input type='submit' value='FINISH' name='act3'/>");
                   p.printf("</form>");
                    }
            catch(Exception ex){}
        }
        else if(session.getAttribute("exam").toString().equals("c") && session.getAttribute("type").toString().equals("sample") )
        {
            try{
                RequestDispatcher rdd=request.getRequestDispatcher("newjsp.jsp");
            rdd.include(request, response);
            
            int i = Integer.parseInt(session.getAttribute("counter").toString());
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                
                if(request.getParameter("opt")!=null)
                {
                    array[i]=request.getParameter("opt");
                }
                else
                    array[i]="e";
                
                i++;
                session.setAttribute("counter",i);
           
                if(i==4)
                {
                    i=0;
                    session.setAttribute("counter",0);
                    session.setAttribute("answers", array);
                    RequestDispatcher rd = request.getRequestDispatcher("submitRes");
                    rd.forward(request, response);
                }

                p.print("<form action='exam'>");

                String name="",a="",b="",c="",d="";

                ResultSet rs = st.executeQuery("select * from c where id ="+i);

                if(rs.next()==true){
                    name = rs.getString("question");
                    a=rs.getString("opta");
                    b=rs.getString("optb");
                    c=rs.getString("optc");
                    d=rs.getString("optd");
                }
                    p.print(name+"<br><hr>");
                    
                    p.print("<input type='radio' name='opt' value='a'/>"+a+"<br>");
                    p.print("<input type='radio' name='opt' value='b'/>"+b+"<br>");
                    p.print("<input type='radio' name='opt' value='c'/>"+c+"<br>");
                    p.print("<input type='radio' name='opt' value='d'/>"+d+"<br>");

                if(i<3)
                    p.printf("<input type='submit' value='NEXT' name='act1'/>");
                else
                    p.printf("<input type='submit' value='FINISH' name='act3'/>");
                   p.printf("</form>");
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
