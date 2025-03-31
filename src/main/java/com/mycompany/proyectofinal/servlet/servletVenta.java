/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectofinal.servlet;

import com.mycompany.proyectofinal.constructor.constructorVenta;
import com.mycompany.proyectofinal.dao.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Date;
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
@WebServlet("/ventas")
public class servletVenta extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/la_casa_de_los_lentes";
    private static final String USER = "root";
     private static final String PASS = "root";
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
            out.println("<title>Servlet servletVenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletVenta at " + request.getContextPath() + "</h1>");
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
        try {
            int codigoBoleta = Integer.parseInt(request.getParameter("codigoBoleta"));
            String fechaCreacion = request.getParameter("fechaCreacion");
            int dniPaciente = Integer.parseInt(request.getParameter("dniPaciente"));
            double esferaIzq = Double.parseDouble(request.getParameter("esferaIzq"));
            double cilindroIzq = Double.parseDouble(request.getParameter("cilindroIzq"));
            double gradoIzq = Double.parseDouble(request.getParameter("gradoIzq"));
            double distanciaIzq = Double.parseDouble(request.getParameter("distanciaIzq"));
            double esferaDer = Double.parseDouble(request.getParameter("esferaDer"));
            double cilindroDer = Double.parseDouble(request.getParameter("cilindroDer"));
            double gradoDer = Double.parseDouble(request.getParameter("gradoDer"));
            double distanciaDer = Double.parseDouble(request.getParameter("distanciaDer"));
            int codigoMontura = Integer.parseInt(request.getParameter("codigoMontura"));
            String tipoLuna = request.getParameter("tipoLuna");
            double costoTotal = Double.parseDouble(request.getParameter("costoTotal"));
            String fechaEntrega = request.getParameter("fechaEntrega");

            // Crear objeto de venta
            constructorVenta venta = new constructorVenta(
                    codigoBoleta, fechaCreacion, dniPaciente, 
                    esferaIzq, cilindroIzq, gradoIzq, distanciaIzq, 
                    esferaDer, cilindroDer, gradoDer, distanciaDer, 
                    codigoMontura, tipoLuna, costoTotal, fechaEntrega
            );

            // Insertar venta usando el DAO
            VentaDAO ventaDAO = new VentaDAO();
            ventaDAO.insertVenta(venta);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redireccionar después de la inserción
        response.sendRedirect("principal.jsp");
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
