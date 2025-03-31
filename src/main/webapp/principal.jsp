<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.proyectofinal.constructor.constructorMontura" %>
<%@ page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./css2/styles.css">
    </head>
    <body>
        <!-- NAVBAR -->
        <nav class="body_navbar w-100 px-5">
            <!-- class="navbar navbar-inverse px-5 position-fixed" -->
            <div class="logo_navbar d-flex">
                <img class="logo_img" src="
                     https://scontent.flim17-1.fna.fbcdn.net/v/t39.30808-6/307495481_506637318143583_8034179687348594998_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeGa81lEQJYYfvC4Fa_8QWdtS_ISqpktjKNL8hKqmS2MozyzdBtR2JSSN1Sp6THZfKQiqmvsdLajkZTqvBjYll_9&_nc_ohc=edLJg6pf5hoQ7kNvgG1GmjT&_nc_oc=AdgMDk9xJazC1fiLM7JtWOuEKe0YHOMeQgzRFST6Y3VYvpTjYPm-9WnMWiHhNq5EktE&_nc_zt=23&_nc_ht=scontent.flim17-1.fna&_nc_gid=AGqG7eEgkhTm0zdyHndda_b&oh=00_AYApdglxSsmL6J1AmNrDmcD2ooVWlxHmsVMaKsHNSyjUsw&oe=67A9FCF6">
            </div>
            <div class="pages_navbar">
                <p class="texto_navbar"><a class="texto_navbar" href="principal.jsp">Principal</a></p>
                <p class="texto_navbar"><a class="texto_navbar" href="montura.jsp">Monturas</a></p>
                <p class="texto_navbar"><a class="texto_navbar" href="pacientesLista.xhtml">Pacientes</a></p>
                <p class="texto_navbar"><a class="texto_navbar" href="venta.jsp">Ventas</a></p>
            </div>
            <div class="sesion_navbar">
                <button class="botones_general text-light"><a class="texto_navbar" href="index.html">Cerrar Sesión</a></button>
            </div>
        </nav>
        
        <!-- PRINCIPAL DIV -->
        
        <div class="principal_body">
            <div class="contenedor_carta_div">
                <%
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs = null;

                    // Eliminación
                    String codigoBoletaParam = request.getParameter("codigoBoleta");
                    if (codigoBoletaParam != null) {
                        int codigoBoleta = Integer.parseInt(codigoBoletaParam);
                        try {
                            // Cargar el controlador de MySQL
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/la_casa_de_los_lentes", "root", "root");

                            // Crear consulta SQL para eliminar
                            String sql = "DELETE FROM registroventa WHERE codigoBoleta = " + codigoBoleta;
                            stmt = conn.createStatement();
                            stmt.executeUpdate(sql);
                        } catch (Exception e) {
                            out.println("Error al eliminar el registro: " + e.getMessage());
                        } finally {
                            try {
                                if (stmt != null) stmt.close();
                                if (conn != null) conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // Actualización
                    String actualizarBoletaParam = request.getParameter("actualizarBoleta");
                    if (actualizarBoletaParam != null) {
                        // Aquí se procesará la actualización
                        String fechaCreacion = request.getParameter("fechaCreacion");
                        String dniPaciente = request.getParameter("dniPaciente");
                        String esferaIzq = request.getParameter("esferaIzq");
                        String cilindroIzq = request.getParameter("cilindroIzq");
                        String gradoIzq = request.getParameter("gradoIzq");
                        String distanciaIzq = request.getParameter("distanciaIzq");
                        String esferaDer = request.getParameter("esferaDer");
                        String cilindroDer = request.getParameter("cilindroDer");
                        String gradoDer = request.getParameter("gradoDer");
                        String distanciaDer = request.getParameter("distanciaDer");
                        String codigoMontura = request.getParameter("codigoMontura");
                        String tipoLuna = request.getParameter("tipoLuna");
                        String costoTotal = request.getParameter("costoTotal");

                        try {
                            // Cargar el controlador de MySQL
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/la_casa_de_los_lentes", "root", "root");

                            // Crear consulta SQL para actualizar
                            String sql = "UPDATE registroventa SET fechaCreacion=?, dniPaciente=?, esferaIzq=?, cilindroIzq=?, gradoIzq=?, distanciaIzq=?, esferaDer=?, cilindroDer=?, gradoDer=?, distanciaDer=?, codigoMontura=?, tipoLuna=?, costoTotal=? WHERE codigoBoleta=?";
                            PreparedStatement pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1, fechaCreacion);
                            pstmt.setString(2, dniPaciente);
                            pstmt.setString(3, esferaIzq);
                            pstmt.setString(4, cilindroIzq);
                            pstmt.setString(5, gradoIzq);
                            pstmt.setString(6, distanciaIzq);
                            pstmt.setString(7, esferaDer);
                            pstmt.setString(8, cilindroDer);
                            pstmt.setString(9, gradoDer);
                            pstmt.setString(10, distanciaDer);
                            pstmt.setString(11, codigoMontura);
                            pstmt.setString(12, tipoLuna);
                            pstmt.setString(13, costoTotal);
                            pstmt.setString(14, actualizarBoletaParam);
                            pstmt.executeUpdate();

                        } catch (Exception e) {
                            out.println("Error al actualizar el registro: " + e.getMessage());
                        } finally {
                            try {
                                if (conn != null) conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // Conexión y consulta para mostrar los registros
                    try {
                        // Cargar el controlador de MySQL
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/la_casa_de_los_lentes", "root", "root");

                        // Crear consulta SQL
                        String sql = "SELECT * FROM registroventa";
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(sql);

                        // Iterar los resultados
                        while (rs.next()) {
                %>
                    <div class="carta_div">
                        <h3 class="text-center">Codigo de Boleta: <%= rs.getString("codigoBoleta") %></h3>
                        <form action="principal.jsp" method="post">
                            <input type="hidden" class="input_principal" name="actualizarBoleta" value="<%= rs.getString("codigoBoleta") %>">
                            <label>Fecha de Creación:</label>
                            <input type="text" class="input_principal" name="fechaCreacion" value="<%= rs.getString("fechaCreacion") %>" disabled><br>
                            <label>DNI de Cliente:</label>
                            <input type="text" class="input_principal" name="dniPaciente" value="<%= rs.getString("dniPaciente") %>" disabled><br>
                            <label>Esfera (Izq):</label>
                            <input type="text" class="input_principal" name="esferaIzq" value="<%= rs.getString("esferaIzq") %>" disabled><br>
                            <label>Cilindro (Izq):</label>
                            <input type="text" class="input_principal" name="cilindroIzq" value="<%= rs.getString("cilindroIzq") %>" disabled><br>
                            <label>Grado (Izq):</label>
                            <input type="text" class="input_principal" name="gradoIzq" value="<%= rs.getString("gradoIzq") %>" disabled><br>
                            <label>Distancia Pupilar (Izq):</label>
                            <input type="text" class="input_principal" name="distanciaIzq" value="<%= rs.getString("distanciaIzq") %>" disabled><br>
                            <label>Esfera (Der):</label>
                            <input type="text" class="input_principal" name="esferaDer" value="<%= rs.getString("esferaDer") %>" disabled><br>
                            <label>Cilindro (Der):</label>
                            <input type="text" class="input_principal" name="cilindroDer" value="<%= rs.getString("cilindroDer") %>" disabled><br>
                            <label>Grado (Der):</label>
                            <input type="text" class="input_principal" name="gradoDer" value="<%= rs.getString("gradoDer") %>" disabled><br>
                            <label>Distancia Pupilar (Der):</label>
                            <input type="text" class="input_principal" name="distanciaDer" value="<%= rs.getString("distanciaDer") %>" disabled><br>
                            <label>Código de Montura:</label>
                            <input type="text" class="input_principal" name="codigoMontura" value="<%= rs.getString("codigoMontura") %>" disabled><br>
                            <label>Tipo de Luna:</label>
                            <input type="text" class="input_principal" name="tipoLuna" value="<%= rs.getString("tipoLuna") %>" disabled><br>
                            <label>Costo Final:</label>
                            <input type="text" class="input_principal" name="costoTotal" value="<%= rs.getString("costoTotal") %>" disabled><br>
                            <label class="fecha_entrega text-center">Fecha Entrega:</label>
                            <input type="text" class="input_principal fecha_entrega text-center" name="fechaEntrega" value="<%= rs.getString("fechaEntrega") %>" disabled><br>
                            <div class="boton_div">
                                <button class="botones_general text-light" type="button" onclick="habilitarCampos(this)">Modificar</button>
                                <button class="botones_general text-light" type="submit">Actualizar</button>
                                <button class="botones_general text-light" type="submit" formaction="principal.jsp" name="codigoBoleta" value="<%= rs.getString("codigoBoleta") %>" onclick="return confirm('¿Estás seguro de que deseas eliminar este registro?');">Eliminar</button>
                            </div>
                        </form>
                    </div>
                <%
                        }
                    } catch (Exception e) {
                        out.println("Error al conectar con la base de datos: " + e.getMessage());
                    } finally {
                        try {
                            if (rs != null) rs.close();
                            if (stmt != null) stmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                %>

                <script>
                    function habilitarCampos(boton) {
                        const form = boton.closest('form');
                        const inputs = form.querySelectorAll('input[type="text"]');
                        inputs.forEach(input => {
                            input.disabled = false;
                        });
                    }
                </script>
            </div>
        </div>
    </body>
</html>
