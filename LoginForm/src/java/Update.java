
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class Update extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=res.getWriter())
        {
            out.println("<html><body>");
            HttpSession session=req.getSession();
            String mal=(String)session.getAttribute("email");
            String fname=req.getParameter("fname");
            String lname=req.getParameter("lname");
            String mail=req.getParameter("email");
            String mobile=req.getParameter("mobile");
            String gender=req.getParameter("gender");
            String dob=req.getParameter("dob");
            String address=req.getParameter("address");
            String city=req.getParameter("city");
            String pin=req.getParameter("pin");
            String state=req.getParameter("state");
            String res_date=req.getParameter("regis_date");
            out.print(res_date);
            Connection conn = DatabaseConnection .IntilizeConnection();
            PreparedStatement s=conn.prepareStatement("update formfill set first_name=? ,last_name=? , email=? , mobile=?, gender=?, dob=?,address=?,city=?, pin=?, state=?, Regis_date=? where email=?;");
            s.setString(1,fname);
            s.setString(2,lname);
            s.setString(3,mail);
            s.setString(4,mobile);
            s.setString(5,gender);
            s.setString(6,dob);
            s.setString(7,address);
            s.setString(8,city);
            s.setInt (9,Integer.parseInt(pin));
            s.setString(10,state);
            s.setString(11,res_date);
            s.setString(12,mal);
            s.executeUpdate();
            
            out.println("<html><body><b>Successfully Updated"+ "</b></body></html>"); 
        }
        catch(ClassNotFoundException | NumberFormatException | SQLException e)
        {
            out.println("error");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

      @Override
    public String getServletInfo() {
        return "Short description";
    }
}

