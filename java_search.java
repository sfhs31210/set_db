package com.yiibai;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Search extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String keyword = request.getParameter("keyword");
        //int keyword = Integer.valueOf(keyword);
        if(keyword==null) {
            keyword = "";
        }
        try {
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useSSL=false&characterEncoding=utf8","root", "0000");
            } catch (Exception e) {
                System.out.println(e);
            }

            PreparedStatement ps = con.prepareStatement("SELECT * FROM `servlet_user` where name LIKE ?");
            ps.setString(1, "%"+keyword+"%");

            out.print("<table width=50% border=1>");
            out.print("<caption>Result:</caption>");

            ResultSet rs = ps.executeQuery();

            /* 列印表欄位的名稱 */
            ResultSetMetaData rsmd = rs.getMetaData();
            int total = rsmd.getColumnCount();
            out.print("<tr>");
            for (int i = 1; i <= total; i++) {
                out.print("<th>" + rsmd.getColumnName(i) + "</th>");
            }
            out.print("</tr>");

            /* Printing result */

            while (rs.next()) {
                out.print("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
                        + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td></tr>");

            }
            out.print("</table>");

        } catch (Exception e2) {
            e2.printStackTrace();
        }

        finally {
            out.close();
        }

    }
}