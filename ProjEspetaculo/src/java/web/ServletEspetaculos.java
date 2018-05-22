/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.crud.EspetaculosCrud;

/**
 *
 * @author Work
 */
@WebServlet(name = "ServletEspetaculos", urlPatterns = {"/ServletEspetaculos"})
public class ServletEspetaculos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EspetaculosCrud espetaculos = new EspetaculosCrud(request, response);
        espetaculos.execute(request.getParameter("operation"));   
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
