/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectofinal.servlet;

import com.mycompany.proyectofinal.constructor.constructorMontura;
import com.mycompany.proyectofinal.dao.MonturaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G1
 */
@WebServlet("/monturas")
public class servletMontura extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/la_casa_de_los_lentes";
    private static final String USER = "root";
    private static final String PASS = "root"; // Cambia esto si tu contraseña es diferente

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletMontura</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletMontura at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        
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
        //processRequest(request, response);
        int codigoMontura = Integer.parseInt(request.getParameter("codigoMontura"));
        String tipoMontura = request.getParameter("tipoMontura");
        double precio = Double.parseDouble(request.getParameter("precio"));
        double longitudMontura = Double.parseDouble(request.getParameter("longitudMontura"));
        double anchoPuente = Double.parseDouble(request.getParameter("anchoPuente"));
        double longitudVarilla = Double.parseDouble(request.getParameter("longitudVarilla"));
        double longitudLente = Double.parseDouble(request.getParameter("longitudLente"));
        String linkFoto = request.getParameter("linkFoto");

        // Crear objeto Montura
        constructorMontura nuevaMontura = new constructorMontura(
                codigoMontura, tipoMontura, precio, longitudMontura,
                anchoPuente, longitudVarilla, longitudLente, linkFoto
        );

        // Insertar en la BD usando MonturaDAO
        MonturaDAO monturaDAO = new MonturaDAO();
        monturaDAO.insertMontura(nuevaMontura);

        response.sendRedirect("montura.jsp");
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
