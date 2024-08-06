
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class Filter extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=res.getWriter())
        {
            
            out.println("<html><head><title>filter</title><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"></head>");
                            
                            out.println("<body><table class=\"table\">\n" +
                            "  <thead class=\"thead-light\">");
                            out.println("<tr><th>Id</th><th>User ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile</th><th>Gender</th><th>Date Of Birth</th><th>Address</th><th>City</th><th>Pin Code</th><th>State</th><th>Registered Date</th><tr></thread>");
                            String from_date=req.getParameter("from_date");
                            String to_date=req.getParameter("to_date");
                            Connection conn = DatabaseConnection .IntilizeConnection();
                            Statement s=conn.createStatement();
                            ResultSet rs=s.executeQuery("select * from formfill where Regis_date BETWEEN '"+from_date+"' AND '"+to_date+"' ;");
                            while(rs.next())
                            {
                                String id=rs.getString("ID");

                                
                                String userid=rs.getString("userId");
                                String fname=rs.getString("first_name");
                                String lname=rs.getString("last_name");
                                String mail=rs.getString("email");
                                String mobile=rs.getString("mobile");
                                String gender=rs.getString("gender");
                                String dob=rs.getString("dob");
                                String address=rs.getString("address");
                                String city=rs.getString("city");
                                String pin=rs.getString("pin");
                                String state=rs.getString("state");
                                String re=rs.getString("Regis_date");
                                out.println("<tr><td>"+id+"</td><td>"+userid+"</td><td>"+fname+"</td><td>"+lname+"</td><td>"+mail+"</td><td>"+mobile+"</td><td>"+gender+"</td><td>"+dob+"</td><td>"+address+"</td><td>"+city+"</td><td>"+pin+"</td><td>"+state+"</td>"+
                                "<td>"+re+"</td></tr>");
                            }

                            out.println("</table>");
                            out.println("</body></html>");
            
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
