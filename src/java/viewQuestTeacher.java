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
public class viewQuestTeacher extends HttpServlet {

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
        
        HttpSession session=request.getSession(false);
        if(session==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
        else 
        {
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/presentation","root","");
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from realjava");
            
            p.print("<div><div style=\"width:100%; position: fixed; text-align:center; border:1px solid; top:0; background-color: #333; color: #f2f2f2;\"><h2>ALL PAPERS</h2></div><div style=\"padding: 16px; margin-top: 5%; height: 1500px;\">");
            
            p.print("<br><h1>JAVA</h1><br>");
            
            while(rs.next()==true)
            {
                //p.print(rs.getString("id")+" > "+rs.getString("question")+"<br>"+rs.getString("opta")+"<br>"+rs.getString("optb")+"<br>"+rs.getString("optc")+"<br>"+rs.getString("optd")+"<br>"+rs.getString("ans")+"<br><hr><br>");
                p.print("  <fieldset>\n" +
"     <legend><h2>Question</h2></legend>\n" +
"        \n" +
"          <table width=\"100%\" cellspacing=\"10px\">\n" +
" 	<tr>\n" +
"	    <td><label>" + rs.getString("question") + "</label></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"question\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>"+rs.getString("opta")+"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs.getString("optb") +"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" +  rs.getString("optc") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs.getString("opta") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td colspan=\"2\">\n" +
"			<div>\n" +
"				<div style=\"margin-left:2%; float:left;\"><label>Answer</label></div>\n" +
"				<div style=\"margin-left:2%; float:left; color:green\"><label>" + rs.getString("ans") + "</label></div>\n" +
"			</div>\n" +
"		</td>	    \n" +
"	</tr>\n" +
"	</table>      \n"
                        + "<form action='modifyServlet1' method='post'><input type='text' value='real' hidden='' name='isreal' /><input type='text' value='java' name='sub' hidden='' /><input type='text' name='id' value='"+rs.getInt("id")+"' hidden=''/><input type='submit' value='MODIFY'/></form>" +
"  </fieldset>");
            }

            p.print("<br><h1>PYTHON</h1><br>");
            
            ResultSet rs1 = st.executeQuery("select * from realpython");
            
            //p.print("<div><div style=\"width:100%; position: fixed; text-align:center; border:1px solid; top:0; background-color: #333; color: #f2f2f2;\"><h2>PYTHON ONLINE PAPER</h2></div><div style=\"padding: 16px; margin-top: 5%; height: 1500px;\">");
            while(rs1.next()==true)
            {
                //p.print(rs.getString("id")+" > "+rs.getString("question")+"<br>"+rs.getString("opta")+"<br>"+rs.getString("optb")+"<br>"+rs.getString("optc")+"<br>"+rs.getString("optd")+"<br>"+rs.getString("ans")+"<br><hr><br>");
                p.print("  <fieldset>\n" +
"     <legend><h2>Question</h2></legend>\n" +
"        \n" +
"          <table width=\"100%\" cellspacing=\"10px\">\n" +
" 	<tr>\n" +
"	    <td><label>" + rs1.getString("question") + "</label></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"question\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>"+rs1.getString("opta")+"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs1.getString("optb") +"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" +  rs1.getString("optc") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs1.getString("opta") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td colspan=\"2\">\n" +
"			<div>\n" +
"				<div style=\"margin-left:2%; float:left;\"><label>Answer</label></div>\n" +
"				<div style=\"margin-left:2%; float:left; color:green\"><label>" + rs1.getString("ans") + "</label></div>\n" +
"			</div>\n" +
"		</td>	    \n" +
"	</tr>\n" +
"	</table>      \n"
                        + "\"<form action='modifyServlet1' method='post'><input type='text' value='real' hidden='' name='isreal' /><input type='text' value='python' name='sub' hidden='' /><input type='text' name='id' value='"+rs1.getInt("id")+"' hidden=''/><input type='submit' value='MODIFY'/></form>\" +" +
"  </fieldset>");
            }
            
            p.print("<br><h1>C++</h1><br>");
            
            ResultSet rs2 = st.executeQuery("select * from realc");
            
            //p.print("<div><div style=\"width:100%; position: fixed; text-align:center; border:1px solid; top:0; background-color: #333; color: #f2f2f2;\"><h2>C++ ONLINE PAPER</h2></div><div style=\"padding: 16px; margin-top: 5%; height: 1500px;\">");
            while(rs2.next()==true)
            {
                //p.print(rs.getString("id")+" > "+rs.getString("question")+"<br>"+rs.getString("opta")+"<br>"+rs.getString("optb")+"<br>"+rs.getString("optc")+"<br>"+rs.getString("optd")+"<br>"+rs.getString("ans")+"<br><hr><br>");
                p.print("  <fieldset>\n" +
"     <legend><h2>Question</h2></legend>\n" +
"        \n" +
"          <table width=\"100%\" cellspacing=\"10px\">\n" +
" 	<tr>\n" +
"	    <td><label>" + rs2.getString("question") + "</label></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"question\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>"+rs2.getString("opta")+"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs2.getString("optb") +"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" +  rs2.getString("optc") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs2.getString("opta") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td colspan=\"2\">\n" +
"			<div>\n" +
"				<div style=\"margin-left:2%; float:left;\"><label>Answer</label></div>\n" +
"				<div style=\"margin-left:2%; float:left; color:green\"><label>" + rs2.getString("ans") + "</label></div>\n" +
"			</div>\n" +
"		</td>	    \n" +
"	</tr>\n" +
"	</table>      \n"
                        + "\"<form action='modifyServlet1' method='post'><input type='text' value='real' hidden='' name='isreal' /><input type='text' value='c' name='sub' hidden='' /><input type='text' name='id' value='"+rs2.getInt("id")+"' hidden=''/><input type='submit' value='MODIFY'/></form>\" +" +
"  </fieldset>");
            }
            
            p.print("<br><h1>SAMPLE JAVA</h1><br>");
            
            ResultSet rs3 = st.executeQuery("select * from java");
            
            //p.print("<div><div style=\"width:100%; position: fixed; text-align:center; border:1px solid; top:0; background-color: #333; color: #f2f2f2;\"><h2>JAVA SAMPLE PAPER</h2></div><div style=\"padding: 16px; margin-top: 5%; height: 1500px;\">");
            while(rs3.next()==true)
            {
                //p.print(rs.getString("id")+" > "+rs.getString("question")+"<br>"+rs.getString("opta")+"<br>"+rs.getString("optb")+"<br>"+rs.getString("optc")+"<br>"+rs.getString("optd")+"<br>"+rs.getString("ans")+"<br><hr><br>");
                p.print("  <fieldset>\n" +
"     <legend><h2>Question</h2></legend>\n" +
"        \n" +
"          <table width=\"100%\" cellspacing=\"10px\">\n" +
" 	<tr>\n" +
"	    <td><label>" + rs3.getString("question") + "</label></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"question\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>"+rs3.getString("opta")+"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs3.getString("optb") +"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" +  rs3.getString("optc") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs3.getString("opta") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td colspan=\"2\">\n" +
"			<div>\n" +
"				<div style=\"margin-left:2%; float:left;\"><label>Answer</label></div>\n" +
"				<div style=\"margin-left:2%; float:left; color:green\"><label>" + rs3.getString("ans") + "</label></div>\n" +
"			</div>\n" +
"		</td>	    \n" +
"	</tr>\n" +
"	</table>      \n"
                        + "\"<form action='modifyServlet1' method='post'><input type='text' value='sample' hidden='' name='isreal' /><input type='text' value='java' name='sub' hidden='' /><input type='text' name='id' value='"+rs3.getInt("id")+"' hidden=''/><input type='submit' value='MODIFY'/></form>\" +" +
"  </fieldset>");
            }
            
            p.print("<br><h1>SAMPLE PYTHON</h1><br>");
            
            ResultSet rs4 = st.executeQuery("select * from python");
            
            //p.print("<div><div style=\"width:100%; position: fixed; text-align:center; border:1px solid; top:0; background-color: #333; color: #f2f2f2;\"><h2>PYTHON SAMPLE PAPER</h2></div><div style=\"padding: 16px; margin-top: 5%; height: 1500px;\">");
            while(rs4.next()==true)
            {
                //p.print(rs.getString("id")+" > "+rs.getString("question")+"<br>"+rs.getString("opta")+"<br>"+rs.getString("optb")+"<br>"+rs.getString("optc")+"<br>"+rs.getString("optd")+"<br>"+rs.getString("ans")+"<br><hr><br>");
                p.print("  <fieldset>\n" +
"     <legend><h2>Question</h2></legend>\n" +
"        \n" +
"          <table width=\"100%\" cellspacing=\"10px\">\n" +
" 	<tr>\n" +
"	    <td><label>" + rs4.getString("question") + "</label></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"question\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>"+rs4.getString("opta")+"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs4.getString("optb") +"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" +  rs4.getString("optc") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs4.getString("opta") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td colspan=\"2\">\n" +
"			<div>\n" +
"				<div style=\"margin-left:2%; float:left;\"><label>Answer</label></div>\n" +
"				<div style=\"margin-left:2%; float:left; color:green\"><label>" + rs4.getString("ans") + "</label></div>\n" +
"			</div>\n" +
"		</td>	    \n" +
"	</tr>\n" +
"	</table>      \n"
                        + "\"<form action='modifyServlet1' method='post'><input type='text' value='sample' hidden='' name='isreal' /><input type='text' value='python' name='sub' hidden='' /><input type='text' name='id' value='"+rs4.getInt("id")+"' hidden=''/><input type='submit' value='MODIFY'/></form>\" +" +
"  </fieldset>");
            }
            
            p.print("<br><h1>SAMPLE C++</h1><br>");
            
            ResultSet rs5 = st.executeQuery("select * from c");
            
            //p.print("<div><div style=\"width:100%; position: fixed; text-align:center; border:1px solid; top:0; background-color: #333; color: #f2f2f2;\"><h2>C++ SAMPLE PAPER</h2></div><div style=\"padding: 16px; margin-top: 5%; height: 1500px;\">");
            while(rs5.next()==true)
            {
                //p.print(rs.getString("id")+" > "+rs.getString("question")+"<br>"+rs.getString("opta")+"<br>"+rs.getString("optb")+"<br>"+rs.getString("optc")+"<br>"+rs.getString("optd")+"<br>"+rs.getString("ans")+"<br><hr><br>");
                p.print("  <fieldset>\n" +
"     <legend><h2>Question</h2></legend>\n" +
"        \n" +
"          <table width=\"100%\" cellspacing=\"10px\">\n" +
" 	<tr>\n" +
"	    <td><label>" + rs5.getString("question") + "</label></td>\n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"question\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>"+rs5.getString("opta")+"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs5.getString("optb") +"</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" +  rs5.getString("optc") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td><input type=\"radio\" name=\"\" placeholder=\"Enter Tag\" disabled=\"false\" /><label>" + rs5.getString("opta") + "</label></td>	    \n" +
"	</tr>\n" +
"	<tr>\n" +
"	    <td colspan=\"2\">\n" +
"			<div>\n" +
"				<div style=\"margin-left:2%; float:left;\"><label>Answer</label></div>\n" +
"				<div style=\"margin-left:2%; float:left; color:green\"><label>" + rs5.getString("ans") + "</label></div>\n" +
"			</div>\n" +
"		</td>	    \n" +
"	</tr>\n" +
"	</table>      \n"
                        + "\"<form action='modifyServlet1' method='post'><input type='text' value='sample' hidden='' name='isreal' /><input type='text' value='c' name='sub' hidden='' /><input type='text' name='id' value='"+rs5.getInt("id")+"' hidden=''/><input type='submit' value='MODIFY'/></form>\" +" +
"  </fieldset>");
            }
            p.print("<a href='loggedInTeacher.html'>BACK</a>");
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
