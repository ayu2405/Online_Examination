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
public class modifyServlet2 extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        
        PrintWriter p =response.getWriter();
        
        if(session==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
        else
        {
            try{
                String question=request.getParameter("quest");
                String opta = request.getParameter("op1");
                String optb = request.getParameter("op2");
                String optc = request.getParameter("op3");
                String optd = request.getParameter("op4");
                String ans = request.getParameter("ans");
                String taga = request.getParameter("tg1");
                String tagb = request.getParameter("tg2");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
                Statement st = con.createStatement();
                p.print("YO");
                int i = Integer.parseInt(session.getAttribute("modify").toString());
                p.print("YO");
                String sub = session.getAttribute("sub").toString();
                p.print("YO");
                String isreal = session.getAttribute("isreal").toString();
                p.print(i+" "+sub+" "+isreal);
                if(sub.equals("java") && isreal.equals("real"))
                    st.executeUpdate("update realjava set question='"+question+"',opta='"+opta+"',optb='"+optb+"',optc='"+optc+"',optd='"+optd+"',ans='"+ans+"'  WHERE id="+i+"");
                else if(sub.equals("java") && isreal.equals("sample"))
                    st.executeUpdate("update java set question='"+question+"', opta='"+opta+"', optb='"+optb+"', optc='"+optc+"', optd='"+optd+"',ans='"+ans+"', taga='"+taga+"', tagb='"+tagb+"'  WHERE id="+i+"");
                else if(sub.equals("python") && isreal.equals("real"))
                    st.executeUpdate("update realpython set question='"+question+"', opta='"+opta+"', optb='"+optb+"', optc='"+optc+"', optd='"+optd+"',ans='"+ans+"'  WHERE id="+i+"");
                else if(sub.equals("python") && isreal.equals("sample"))
                    st.executeUpdate("update python set question='"+question+"', opta='"+opta+"', optb='"+optb+"', optc='"+optc+"', optd='"+optd+"',ans='"+ans+"', taga='"+taga+"', tagb='"+tagb+"'  WHERE id="+i+"");
                else if(sub.equals("c") && isreal.equals("real"))
                    st.executeUpdate("update realc set question='"+question+"', opta='"+opta+"', optb='"+optb+"', optc='"+optc+"', optd='"+optd+"',ans='"+ans+"'  WHERE id="+i+"");
                else if(sub.equals("c") && isreal.equals("sample"))
                    st.executeUpdate("update c set question='"+question+"', opta='"+opta+"', optb='"+optb+"', optc='"+optc+"', optd='"+optd+"',ans='"+ans+"', taga='"+taga+"', tagb='"+tagb+"'  WHERE id="+i+"");
                p.print("YO");
                RequestDispatcher rd = request.getRequestDispatcher("viewQuestTeacher");
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
