/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class weAddQuest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    int i;
    
    @Override
    public void init()
            throws ServletException {
        i=1;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter p =response.getWriter();
        
        HttpSession session =request.getSession(false);
        if(session==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
        else if(session.getAttribute("type").toString().equals("real") && session.getAttribute("category").toString().equals("java")){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();

                String quest = request.getParameter("quest");
                String op1 = request.getParameter("op1");
                String op2 = request.getParameter("op2");
                String op3 = request.getParameter("op3");
                String op4 = request.getParameter("op4");
                String ans = request.getParameter("ans");
                String tg1 = request.getParameter("tg1");
                String tg2 = request.getParameter("tg2");

                st.executeUpdate("insert into realjava values("+i+",'"+quest+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+ans+"')");
                i++;

                if(i==4)
                {
                    i=1;
                    RequestDispatcher rd = request.getRequestDispatcher("loggedInTeacher.html");
                    rd.forward(request, response);
                }
                RequestDispatcher rd = request.getRequestDispatcher("questions.html");
                rd.forward(request, response);

            }
            catch(Exception ex){}
        }
        else if(session.getAttribute("type").toString().equals("sample") && session.getAttribute("category").toString().equals("java")){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();

                String quest = request.getParameter("quest");
                String op1 = request.getParameter("op1");
                String op2 = request.getParameter("op2");
                String op3 = request.getParameter("op3");
                String op4 = request.getParameter("op4");
                String ans = request.getParameter("ans");
                String tg1 = request.getParameter("tg1");
                String tg2 = request.getParameter("tg2");

                p.print("YO");

                st.executeUpdate("insert into java values("+i+",'"+quest+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+ans+"','"+tg1+"','"+tg2+"')");
                i++;

                if(i==4)
                {
                    i=1;
                    RequestDispatcher rd = request.getRequestDispatcher("loggedInTeacher.html");
                    rd.forward(request, response);
                }
                RequestDispatcher rd = request.getRequestDispatcher("questions.html");
                rd.forward(request, response);

            }
            catch(Exception ex){}
        }
        else if(session.getAttribute("type").toString().equals("real") && session.getAttribute("category").toString().equals("python")){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();

                String quest = request.getParameter("quest");
                String op1 = request.getParameter("op1");
                String op2 = request.getParameter("op2");
                String op3 = request.getParameter("op3");
                String op4 = request.getParameter("op4");
                String ans = request.getParameter("ans");
                String tg1 = request.getParameter("tg1");
                String tg2 = request.getParameter("tg2");

                p.print("YO");

                st.executeUpdate("insert into realpython values("+i+",'"+quest+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+ans+"')");
                i++;

                if(i==4)
                {
                    i=1;
                    RequestDispatcher rd = request.getRequestDispatcher("loggedInTeacher.html");
                    rd.forward(request, response);
                }
                RequestDispatcher rd = request.getRequestDispatcher("questions.html");
                rd.forward(request, response);

            }
            catch(Exception ex){}
        }
        else if(session.getAttribute("type").toString().equals("sample") && session.getAttribute("category").toString().equals("python")){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();

                String quest = request.getParameter("quest");
                String op1 = request.getParameter("op1");
                String op2 = request.getParameter("op2");
                String op3 = request.getParameter("op3");
                String op4 = request.getParameter("op4");
                String ans = request.getParameter("ans");
                String tg1 = request.getParameter("tg1");
                String tg2 = request.getParameter("tg2");

                p.print("YO");

                st.executeUpdate("insert into python values("+i+",'"+quest+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+ans+"','"+tg1+"','"+tg2+"')");
                i++;

                if(i==4)
                {
                    i=1;
                    RequestDispatcher rd = request.getRequestDispatcher("loggedInTeacher.html");
                    rd.forward(request, response);
                }
                RequestDispatcher rd = request.getRequestDispatcher("questions.html");
                rd.forward(request, response);

            }
            catch(Exception ex){}
        }
        else if(session.getAttribute("type").toString().equals("real") && session.getAttribute("category").toString().equals("c")){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();

                String quest = request.getParameter("quest");
                String op1 = request.getParameter("op1");
                String op2 = request.getParameter("op2");
                String op3 = request.getParameter("op3");
                String op4 = request.getParameter("op4");
                String ans = request.getParameter("ans");
                String tg1 = request.getParameter("tg1");
                String tg2 = request.getParameter("tg2");

                p.print("YO");

                st.executeUpdate("insert into realc values("+i+",'"+quest+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+ans+"')");
                i++;

                if(i==4)
                {
                    i=1;
                    RequestDispatcher rd = request.getRequestDispatcher("loggedInTeacher.html");
                    rd.forward(request, response);
                }
                RequestDispatcher rd = request.getRequestDispatcher("questions.html");
                rd.forward(request, response);

            }
            catch(Exception ex){}
        }
        else if(session.getAttribute("type").toString().equals("sample") && session.getAttribute("category").toString().equals("c")){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();

                String quest = request.getParameter("quest");
                String op1 = request.getParameter("op1");
                String op2 = request.getParameter("op2");
                String op3 = request.getParameter("op3");
                String op4 = request.getParameter("op4");
                String ans = request.getParameter("ans");
                String tg1 = request.getParameter("tg1");
                String tg2 = request.getParameter("tg2");

                p.print("YO");

                st.executeUpdate("insert into c values("+i+",'"+quest+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+ans+"','"+tg1+"','"+tg2+"')");
                i++;

                if(i==4)
                {
                    i=1;
                    RequestDispatcher rd = request.getRequestDispatcher("loggedInTeacher.html");
                    rd.forward(request, response);
                }
                RequestDispatcher rd = request.getRequestDispatcher("questions.html");
                rd.forward(request, response);

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
