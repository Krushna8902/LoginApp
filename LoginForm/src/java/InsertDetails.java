
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class InsertDetails extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException ,ServletException, SQLException
    {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out=res.getWriter();
        try
        {
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                    "    <title>Application Form</title>\n" +
                    "    <!-- Bootstrap CSS -->\n" +
                    "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            background-color: #f0f0f0;\n" +
                    "        }\n" +
                    "        \n" +
                    "        form {\n" +
                    "            width: 600px;\n" +
                    "            margin: 50px auto;\n" +
                    "            padding: 20px;\n" +
                    "            background-color: #fff;\n" +
                    "            border: 1px solid #ddd;\n" +
                    "        }\n" +
                    "        \n" +
                    "        label {\n" +
                    "            display: block;\n" +
                    "            margin-top: 10px;\n" +
                    "            font-size: 16px;\n" +
                    "        }\n" +
                    "        \n" +
                    "        input[type=\"text\"],\n" +
                    "        input[type=\"email\"],\n" +
                    "        input[type=\"tel\"],\n" +
                    "        input[type=\"date\"],\n" +
                    "        input[type=\"password\"] {\n" +
                    "            width: 100%;\n" +
                    "            padding: 10px;\n" +
                    "            margin-top: 5px;\n" +
                    "            border: 1px solid #ddd;\n" +
                    "            border-radius: 5px;\n" +
                    "            box-sizing: border-box;\n" +
                    "        }\n" +
                    "        \n" +
                    "        input[type=\"submit\"] {\n" +
                    "            width: 100%;\n" +
                    "            padding: 10px;\n" +
                    "            margin-top: 20px;\n" +
                    "            background-color: #007bff;\n" +
                    "            color: #fff;\n" +
                    "            border: none;\n" +
                    "            border-radius: 5px;\n" +
                    "            cursor: pointer;\n" +
                    "        }\n" +
                    "        \n" +
                    "        input[type=\"submit\"]:hover {\n" +
                    "            background-color: #0056b3;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <div class=\"m_container\">\n" +
                    "            <h1 class=\"text-center p-4\">Entre Your Information</h1>"+
                    "            <form method=\"post\" action=\"details\" target=\"_blank\">\n" +
                    "                <label for=\"m_fname\">First Name:</label>\n" +
                    "                <input type=\"text\" id=\"m_fname\" name=\"fname\">\n" +
                    "                <label for=\"m_lname\">Last Name:</label>\n" +
                    "                <input type=\"text\" id=\"m_lname\" name=\"lname\">\n" +
                    "                <label for=\"m_email\">Email:</label>\n" +
                    "                <input type=\"email\" id=\"m_email\" name=\"email\">\n" +
                    "                <label for=\"m_mobile\">Mobile:</label>\n" +
                    "                <input type=\"tel\" id=\"m_mobile\" name=\"mobile\">\n" +
                    "                <label for=\"m_gender\">Gender:</label><br>\n" +
                    "                <input type=\"radio\" id=\"m_male\" name=\"gender\" value=\"male\">\n" +
                    "                <label for=\"m_male\">Male</label>\n" +
                    "                <input type=\"radio\" id=\"m_female\" name=\"gender\" value=\"female\">\n" +
                    "                <label for=\"m_female\">Female</label>\n" +
                    "                <label for=\"m_dob\">Date Of Birth:</label>\n" +
                    "                <input type=\"date\" id=\"m_dob\" name=\"dob\">\n" +
                    "                <label for=\"m_address\">Address:</label>\n" +
                    "                <input type=\"text\" id=\"m_address\" name=\"address\">\n" +
                    "                <label for=\"m_city\">City:</label>\n" +
                    "                <input type=\"text\" id=\"m_city\" name=\"city\">\n" +
                    "                <label for=\"m_pin\">Area PIN:</label>\n" +
                    "                <input type=\"text\" id=\"m_pin\" name=\"pin\">\n" +
                    "                <label for=\"m_state\">State:</label>\n" +
                    "                <input type=\"text\" id=\"m_state\" name=\"state\">\n" +
                    "                <label for=\"regis_date\">Registered On:</label>\n" +
                    "                <input type=\"date\" id=\"m_state\" name=\"regis_date\">\n" +
                    "                <input type=\"submit\" value=\"Save\">\n" +
                    "            </form>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>");
            
             
        }
        catch(NumberFormatException e)
        {
        
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


            
