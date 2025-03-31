/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectofinal.servlet;

import com.mycompany.proyectofinal.constructor.constructorUsuario;
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
import java.sql.SQLException;

/**
 *
 * @author G1
 */
@WebServlet("/register")

public class RegistroServlet extends HttpServlet {

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
            out.println("<title>Servlet RegistroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String repetirPassword = request.getParameter("repetirPassword");

        if (nombre != null && apellido != null && correo != null && password != null && repetirPassword != null) {
            if (password.equals(repetirPassword)) {
                constructorUsuario nuevoUsuario = new constructorUsuario(nombre, apellido, correo, password);
                Connection conn = null;
                PreparedStatement pstmt = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/la_casa_de_los_lentes", "root", "root");

                    String sql = "INSERT INTO usuario (nombreUsuario, apellidoUsuario, correo, contraseña) VALUES (?, ?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, nuevoUsuario.getNombre());
                    pstmt.setString(2, nuevoUsuario.getApellido());
                    pstmt.setString(3, nuevoUsuario.getCorreo());

                    int rowsInserted = pstmt.executeUpdate();

                    if (rowsInserted > 0) {
                        response.sendRedirect("login.jsp");
                    } else {
                        request.setAttribute("mensajeError", "Error al registrar el usuario.");
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("mensajeError", "Error en la base de datos: " + e.getMessage());
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    request.setAttribute("mensajeError", "Error al cargar el controlador de la base de datos.");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } finally {
                    try {
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                request.setAttribute("mensajeError", "Las contraseñas no coinciden.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mensajeError", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    
    
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
