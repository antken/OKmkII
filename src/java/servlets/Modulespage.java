/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vitaly
 */
public class Modulespage extends HttpServlet {

    private HttpSession httpsession;   
    private String action;
    
    // <editor-fold defaultstate="collapsed" desc="Processes requests for both HTTP">
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modulespage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Modulespage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
    // </editor-fold>

    
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        httpsession = request.getSession();
	action = request.getParameter("instance");
        
        if(action.equals("active"))
        {
            getActiveModules(request, response);
        }
        else if(action.equals("available"))
        {
            getAvailableModules(request, response);
        }
        else
        {
            response.setContentType("text/html");
            response.sendRedirect("feil.jsp");
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("modules.jsp");
    }
    
    private void getActiveModules(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        StringBuilder answer =  new StringBuilder();
        
        answer.append("<table class=\"table table-hover\">");
        
            answer.append("<thead>");
                answer.append("<tr>");
                    answer.append("<th class=\"span6\">").append("Module name").append("</th>")
                    .append("<th class=\"span1\">")
                        .append("D")
                    .append("</th>")
                    .append("<th class=\"span1\">")
                        .append("M")
                    .append("</th>")
                    .append("<th class=\"span1\">")
                        .append("Y")
                    .append("</th>");


                    answer.append("<th class=\"span1\">")
                            .append("Status")
                            .append("</th>");
                    answer.append("<th class=\"span1\">")
                            .append("Change")
                            .append("</th>");
                    answer.append("<th class=\"span1\">")
                            .append("Delete")
                            .append("</th>");
                answer.append("</tr>");
            answer.append("</thead>");
            
            answer.append("<tbody>");
                
                //TO_DO Cikl dlya polucheniya spiska vseh moduley pol'zovatelya
            
                answer.append("<tr>")
                            .append("<td class=\"span6\">")
                                .append("1")
                            .append("</td>")
                            .append("<td class=\"span1\">")
                                .append("1")
                            .append("</td>")
                            .append("<td class=\"span1\">")
                                .append("1")
                            .append("</td>")
                            .append("<td class=\"span1\">")
                                .append("1")
                            .append("</td>")
                            .append("<td class=\"span1\">")
                                .append("1")
                            .append("</td>")
                            .append("<td class=\"span1\">")
                                .append("1")
                            .append("</td>")
                            .append("<td class=\"span1\">")
                                .append("1")
                            .append("</td>")
                        .append("</tr>");
                
                
            answer.append("</tbody>");
                    
        
        answer.append("</table>");
        
        response.setContentType("text/plain");
        response.getWriter().write(answer.toString());
    }
    
    private void getAvailableModules(HttpServletRequest request, HttpServletResponse response)
    {
    
    }

    // <editor-fold defaultstate="collapsed" desc="Short description of the servlet.">
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
