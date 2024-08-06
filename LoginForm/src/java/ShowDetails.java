
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class ShowDetails extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException ,ServletException, SQLException
    {
        res.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out=res.getWriter();
        out.println("<html lang=\"en\">\n" +
                    "  <head>\n" +
                    "    <!-- Required meta tags -->\n" +
                    "    <meta charset=\"utf-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                    "\n" +
                    "    <!-- Bootstrap CSS -->\n" +
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                    "\n" +
                    "    <title>show details</title>\n" +
                    "  </head>\n" +
                    "  <body>");
        HttpSession session=req.getSession();
        String mal=(String)session.getAttribute("email");
        //String pass=(String)session.getAttribute("password");
        
        try
        {
            try (Connection conn = DatabaseConnection .IntilizeConnection()) {
                Statement s=conn.createStatement();
                ResultSet rs=s.executeQuery("select * from formfill where email='"+mal+"';");
                out.println("<body><table class=\"table\">\n" +
                            "  <thead class=\"thead-light\">");
                out.println("<tr><th>Id</th><th>User ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile</th><th>Gender</th><th>Date Of Birth</th><th>Address</th><th>City</th><th>Pin Code</th><th>State</th><th>Registered On</th><tr></thread>");
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
                    String res_date=rs.getString("Regis_date");
                    out.println("<tr><td>"+id+"</td><td>"+userid+"</td><td>"+fname+"</td><td>"+lname+"</td><td>"+mail+"</td><td>"+mobile+"</td><td>"+gender+"</td><td>"+dob+"</td><td>"+address+"</td><td>"+city+"</td><td>"+pin+"</td><td>"+state+"</td><td>"+res_date+"</td></tr>");
                }
                out.println("</table>");
                out.println("</body></html>");
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
         out.println(e);
        } 
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShowDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(ShowDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      @Override
    public String getServletInfo() {
        return "Short description";
    }            
}
