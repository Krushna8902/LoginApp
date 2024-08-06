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
public class Verfiy extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException ,ServletException, SQLException
    {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out=res.getWriter();
        String name=req.getParameter("username");
        String pass=req.getParameter("password");
        try
        {
            out.println("<html lang=\"en\">\n" +
                        "<head>\n" +
                        "  <title>Bootstrap Example</title>\n" +
                        "  <meta charset=\"utf-8\">\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                        "    <style>\n" +
                        "        /* Custom styles for this template */\n" +
                        "        .container {\n" +
                        "            margin-top: 50px;\n" +
                        "        }\n" +
                        "        .card {\n" +
                        "            margin-bottom: 20px;\n" +
                        "        }\n" +
                        "    </style>"+
                        " <style></style>"+
                        "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
                        "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\n" +
                        "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n" +
                        "</head>\n" +
                        "<body class\"justify-center text-center\">");
            try (Connection conn = DatabaseConnection .IntilizeConnection()) {
                Statement s=conn.createStatement();
                ResultSet rs=s.executeQuery("select password from register where email='"+name+"' and password='"+pass+"';");
                
                HttpSession session=req.getSession();
                session.setAttribute("email",name);
                if(rs.next())
                {
                    out.println("<div class=\"container\">\n" +
                            "    <div class=\"row\">\n" +
                            "        <div class=\"col-md-4\">\n" +
                            "            <div class=\"card\">\n" +
                            "                <div class=\"card-header\">\n" +
                            "                    <h3 class=\"text-center\">Insert Details</h3>\n" +
                            "                </div>\n" +
                            "                <div class=\"card-body\">\n" +
                            "                    <form action=\"insertdetails\" method=\"post\">\n" +
                            "                        <button type=\"submit\" class=\"btn btn-primary\">Insert Details</button>\n" +
                            "                    </form>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div class=\"col-md-4\">\n" +
                            "            <div class=\"card\">\n" +
                            "                <div class=\"card-header\">\n" +
                            "                    <h3 class=\"text-center\">Show Details</h3>\n" +
                            "                </div>\n" +
                            "                <div class=\"card-body\">\n" +
                            "                    <form action=\"showdetails\" method=\"post\">\n" +
                            "                        <button type=\"submit\" class=\"btn btn-primary\">Show Details</button>\n" +
                            "                    </form>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "        <div class=\"col-md-4\">\n" +
                            "            <div class=\"card\">\n" +
                            "                <div class=\"card-header\">\n" +
                            "                    <h3 class=\"text-center\">Update Details</h3>\n" +
                            "                </div>\n" +
                            "                <div class=\"card-body\">\n" +
                            "                    <form action=\"updatedetails\" method=\"post\">\n" +
                            "                        <button type=\"submit\" class=\"btn btn-primary\">Update Details</button>\n" +
                            "                    </form>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "    </div>");
                    ResultSet r=s.executeQuery("select Status from subscription where email='"+name+"';");
                    if(r.next())
                    {
                        String status=r.getString("Status");
                        if(status.equals("yes"))
                        {
                            out.println("<div class=\"container\">\n" +
                            "    <div class=\"row\">\n" +
                            "       <div class=\"col-md-4\"></div>"+
                            "        <div class=\"col-md-4\">\n" +
                            "            <div class=\"card\">\n" +
                            "                <div class=\"card-header\">\n" +
                            "                    <h3 class=\"text-center\">List For Premium Customer</h3>\n" +
                            "                </div>\n" +
                            "                <div class=\"card-body\">\n" +
                            "                   <ol>"+
                            "                    <li>Tutorials</li><li>Customer Support</li><li>Shopping</li><li>Help</li><li>Coupans</li><li>Discount</li><li>Personal Guide</li><li>Videos</li>"+
                            "                    </ol>"+
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n"+
                                "</div>");
                            out.print("");
                            
                        }
                        else
                        {
                            
                            out.println("Wait admin to give you permission" );


                        }
                        
                    }
                    else{
                        
                            
                            out.println("<div class=\"container\">\n" +
                            "    <div class=\"row\">\n" +
                            "       <div class=\"col-md-1\"></div>"+
                            "        <div class=\"col-md-4\">\n" +
                            "            <div class=\"card\">\n" +
                            "                <div class=\"card-header\">\n" +
                            "                    <h3>You are our Normal customer</h3>\n" +
                            "                </div>\n" +
                            "                <div class=\"card-body\">\n" +
                            "                   <ol>"+
                            "                    <li>Tutorials</li><li>Customer Support</li><li>Shopping</li><li>Help</li>"+
                            "                    </ol>"+
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n"+
                            "        <div class=\"col-md-2\"></div>"+
                            "        <div class=\"col-md-4\">\n" +
                            "            <div class=\"card\">\n" +
                            "                <div class=\"card-header\">\n" +
                            "                    <h3 class=\"text-center\">Premium Features</h3>\n" +
                            "                </div>\n" +
                            "                <div class=\"card-body\">\n" +
                            "                   <ol>"+
                            "                    <li>Coupans</li><li>Discount</li><li>Personal Guide</li><li>Videos</li>"+
                            "                    </ol>"+
                            "                </div>\n" +
                            "            </div>\n" +
                            "        </div>\n"+
                            "   </div></div>");
                           
                    
                    
                            out.println("<div class=\"container\">\n" +
                            "    <div class=\"card \">\n" +
                            "        <div class=\"card-header\">\n" +
                            "            <h3>Subscription</h3>\n" +
                            "        </div>\n" +
                            "        <div class=\"card-body\">\n" +
                            "            <form action=\"subscribecustomer\" method=\"post\">\n" +
                            "                <div class=\"mb-3\">\n" +
                            "                    <label for=\"email\" class=\"form-label\">Enter your email</label>\n" +
                            "                    <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\">\n" +
                            "                </div>\n" +
                            "                <div class=\"mb-3\">\n" +
                            "                    <label for=\"name\" class=\"form-label\">Name</label>\n" +
                            "                    <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\">\n" +
                            "                </div>\n" +
                            "                <p>Amount: $5000</p><br>\n" +
                            "                <button type=\"submit\" class=\"btn btn-primary\">Pay Now</button>\n" +
                            "            </form>\n" +
                            "        </div>\n" +
                            "    </div>\n" +
                            "</div>\n");
                        

                    }
                    
                    
                }
                else if((name.equals("admin")) && pass.equals("admin"))
                {
                            out.println("<div class=\"container\">");
                            out.println("<div class=\"row justify-content-center\">");
                            out.println("<div class=\"col-mg-3\"></div><div class=\"col-md-6 d-flex align-items-center justify-content-center\">"); // Add classes here
                            out.println("<div class=\"card\">");
                            out.println("<div class=\"card-body\">");
                            out.println("<div class=\"text-center\">");
                            out.println("<h1>Welcome Admin</h1>");
                            out.println("<form action=\"adminboard\" method=\"post\">");
                            out.println("<button type=\"submit\" class=\"btn btn-primary\">Show All Users</button>");
                            out.println("</form>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");

                            out.println("<div class=\"container\">");
                            out.println("<div class=\"row justify-content-center\">");
                            out.println("<div class=\"col-mg-3\"></div><div class=\"col-md-6 d-flex align-items-center justify-content-center\">"); // Add classes here
                            out.println("<div class=\"\">");
                            out.println("<div class=\"\">");
                            out.println("<div class=\"text-center\">");
                            out.println("<h1>Subscription</h1>");
                            out.println("<form action=\"subscribeadmin\" method=\"post\">");
                            out.println("<label>Email</label>");
                            out.println("<input type=\"text\" name=\"email\" class=\"form-control mb-3\">");
                            out.println("<label>Status</label>");
                            out.println("<input type=\"text\" name=\"status\" class=\"form-control mb-3\">");
                            out.println("<button type=\"submit\" class=\"btn btn-primary\">Add Subscription</button>");
                            out.println("</form>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            
                            out.println("<form class=\"containter text-center\" action=\"filter\" method=\"post\"> <label>From Date :<input type=\"date\" name=\"from_date\"></label><br>"+
                            " <label>To Date:<input type=\"date\" name=\"to_date\"><br><button type=\"submit\">Filter</button></form>");
                            
                            ResultSet k = s.executeQuery("select * from subscription where Status='yes';");

                            out.println("<div class=\"container\">");
                            out.println("<div class=\"row justify-content-center\">");
                            
                            out.println("<div class=\"col-mg-3\"></div><div class=\"col-md-6 d-flex align-items-center justify-content-center\">"); // Add classes here
                            out.println("<div class=\"card\">");
                            out.println("<div class=\"card-body\">");
                            out.println("<h1 class=\"text-center col-mg-6\">People Who Subscribed</h1>");
                            out.println("<table class=\"table table-bordered\">");
                            out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Status</th></tr>");
                            while (k.next()) {
                                String id = k.getString("ID");
                                String em = k.getString("Email");
                                String na = k.getString("Name");
                                String status = k.getString("Status");
                                out.println("<tr><td>" + id + "</td><td>" + na + "</td><td>" + em + "</td><td>" + status + "</td></tr>");
                            }
                            out.println("</table>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");

                            ResultSet n = s.executeQuery("select * from subscription where Status='no';");

                            out.println("<div class=\"container\">");
                            out.println("<div class=\"row justify-content-center\">");
                            
                            out.println("<div class=\"col-mg-3\"></div><div class=\"col-md-6 d-flex align-items-center justify-content-center\">"); // Add classes here
                            out.println("<div class=\"card\">");
                            out.println("<div class=\"card-body\">");
                            out.println("<h1 class=\"text-center col-mg-6\">People Who Subscribed</h1>");
                            out.println("<table class=\"table table-bordered\">");
                            out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Status</th></tr>");
                            while (k.next()) {
                                String id = n.getString("ID");
                                String em = n.getString("Email");
                                String na = n.getString("Name");
                                String status = n.getString("Status");
                                out.println("<tr><td>" + id + "</td><td>" + na + "</td><td>" + em + "</td><td>" + status + "</td></tr>");
                            }
                            out.println("</table>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");

                    
                }
                else
                {
                    res.sendRedirect("index.html");
                }
                
                out.println("<!-- Bootstrap JS (optional, if needed) -->\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                "</body>\n" +
                "</html>");
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
            Logger.getLogger(Verfiy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(Verfiy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      @Override
    public String getServletInfo() {
        return "Short description";
    }            
}


            