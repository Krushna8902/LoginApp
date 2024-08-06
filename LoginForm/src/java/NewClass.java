/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Krushna Siraskar
 */
public class NewClass extends HttpServlet{
    
    public void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html;charset=UTF-8");
        try(PrintWriter Out=res.getWriter())
        {
            
            
                
            Out.println("<<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>register</title>\n" +
            "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" +
            "    \n" +
            "    <!--Fontawesome CDN-->\n" +
            "	<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\n" +
            "\n" +
            "	<!--Custom styles-->\n" +
            "	<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n" +
            "</head>");
                        Out.println("<body>");
                        Out.println(" <div class=\"container\">\n" +
            "        <div class=\"d-flex justify-content-center h-100\">\n" +
            "          <div class=\"card\">\n" +
            "            <div class=\"card-header\">\n" +
            "              <h3>Sign Up</h3>\n" +
            "              <div class=\"d-flex justify-content-end social_icon\">\n" +
            "                <span><i class=\"fab fa-facebook-square\"></i></span>\n" +
            "                <span><i class=\"fab fa-google-plus-square\"></i></span>\n" +
            "                <span><i class=\"fab fa-twitter-square\"></i></span>\n" +
            "              </div>\n" +
            "            </div>\n" +
            "            <div class=\"card-body\">\n" +
            "              <form action=\"reg\" method=\"post\">\n" +
            "                <div class=\"input-group form-group\">\n" +
            "                  <div class=\"input-group-prepend\">\n" +
            "                    <span class=\"input-group-text\"><i class=\"fas fa-user\"></i></span>\n" +
            "                  </div>\n" +
            "                  <input type=\"text\" name=\"first_name\" class=\"form-control\" placeholder=\"First Name\">\n" +
            "                  \n" +
            "                </div>\n" +
            "                <div class=\"input-group form-group\">\n" +
            "                  <div class=\"input-group-prepend\">\n" +
            "                    <span class=\"input-group-text\"><i class=\"fas fa-user\"></i></span>\n" +
            "                  </div>\n" +
            "                  <input type=\"text\" name=\"last_name\" class=\"form-control\" placeholder=\"Last Name\">\n" +
            "                </div>\n" +
            "                <div class=\"input-group form-group\">\n" +
            "                  <div class=\"input-group-prepend\">\n" +
            "                    <span class=\"input-group-text\"><i class=\"fas fa-envelope\"></i></span>\n" +
            "                  </div>\n" +
            "                  <input type=\"text\" name=\"email\" class=\"form-control\" placeholder=\"Email\">\n" +
            "                </div>\n" +
            "                <div class=\"input-group form-group\">\n" +
            "                  <div class=\"input-group-prepend\">\n" +
            "                    <span class=\"input-group-text\"><i class=\"fas fa-key\"></i></span>\n" +
            "                  </div>\n" +
            "                  <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Password\">                 \n" +
            "                </div>\n" +
            "                \n" +
            "                <div class=\"form-group\">\n" +
            "                              <button type=\"submit\">Submit</button>\n" +        
            "                </div>\n" +
            "              </form>\n" +
            "            </div>\n" +
            "            <div class=\"card-footer\">\n" +
            "              <div class=\"d-flex justify-content-center links\">\n" +
            "                have an account?\n"+"<div><a href='index.html'>Sign In</div>" +
            "              </div>\n" +
            "              <div class=\"d-flex justify-content-center\">\n" +
            "                <a href=\"#\">Forgot your password?</a>\n" +
            "              </div>\n" +
            "            </div>\n" +
            "          </div>\n" +
            "        </div>\n" +
            "      </div>");
            
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
