<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.proyectofinal.constructor.constructorPaciente" %>
<%@ page import="java.sql.*" %>



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
                <p class="texto_navbar"><a class="texto_navbar" href="pacientes.jsp">Pacientes</a></p>
                <p class="texto_navbar"><a class="texto_navbar" href="venta.jsp">Ventas</a></p>
            </div>
            <div class="sesion_navbar">
                <button class="botones_general text-light"><a class="texto_navbar" href="index.html">Cerrar Sesión</a></button>
            </div>
        </nav>
        
        <!-- PACIENTES BODY -->
        <div class="pacientes_body">
            <div class="pacientes_datos_div">
                <div class="buscador_div">
                    <input type="text" class="form-control input_pacientes" placeholder="Buscar Paciente">
                </div>
                <div class="pacientes_añadir_div">
                    <h2>Añadir Paciente</h2>
                    <form action="pacientes" method="post">
                        <input type="number" name="dniPaciente" id="dniPaciente" class="form-control input_pacientes" placeholder="DNI" required>

                        <input type="text" name="nombrePaciente" class="form-control input_pacientes" placeholder="Nombre" required>
                        <input type="text" name="direccion" class="form-control input_pacientes" placeholder="Direccion" required>
                        <input type="number" name="telefono" class="form-control input_pacientes" placeholder="Telefono" required>
                        <input type="text" name="fechaVisita" class="form-control input_pacientes" placeholder="Fecha de Visita (DD/MM/AAAA)" required>
                        <input type="text" name="razonVisita" class="form-control input_pacientes" placeholder="Razon de Visita" required>
                        <select name="enfermedades" class="form-control select_pacientes" required>
                            <option value="" disabled selected>Enfermedades</option>
                            <option value="Daltonismo">Daltonismo</option>
                            <option value="Miopia">Miopia</option>
                            <option value="Astigmatismo">Astigmatismo</option>
                            <option value="Catarata">Catarata</option>
                            <option value="Ojo Seco">Ojo Seco</option>
                            <option value="Ninguno">Ninguno</option>
                        </select>
                        <div class="div_invisible"></div>
                        <button type="submit" class="botones_general text-light">Añadir</button>
                    </form>
                </div>



            </div>
            
            <div class='contenedor_montura'>
                <h2>Pacientes</h2>
                <div class="tabla_div">
                    <table border="1">
                        <thead class="justify-content-between">
                            <tr>
                                <th>DNI</th>
                                <th>Nombre</th>
                                <th>Direccion</th>
                                <th>Telefono</th>
                                <th>F. de Visita</th>
                                <th>R. de Visita</th>
                                <th>Enfermedad</th>
                            </tr>    
                        </thead>
                        <tbody>
                            <%
                                Connection conn = null;
                                Statement stmt = null;
                                ResultSet rs = null;
                                try {
                                    // Cargar el controlador de MySQL
                                    Class.forName("com.mysql.cj.jdbc.Driver");

                                    // Conexión a la base de datos
                                    conn = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/la_casa_de_los_lentes", "root", "root");

                                    // Crear consulta SQL
                                    String sql = "SELECT * FROM paciente";
                                    stmt = conn.createStatement();
                                    rs = stmt.executeQuery(sql);

                                    // Iterar los resultados
                                    while (rs.next()) {
                            %>
                                        <tr>
                                            <td><%= rs.getString("dniPaciente") %></td>
                                            <td><%= rs.getString("nombrePaciente") %></td>
                                            <td><%= rs.getString("direccion") %></td>
                                            <td><%= rs.getString("telefono") %></td>
                                            <td><%= rs.getDate("fechaVisita") %></td>
                                            <td><%= rs.getString("razonVisita") %></td>
                                            <td><%= rs.getString("enfermedades") %></td>
                                        </tr>
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
                        </tbody>
                    </table>
                </div>
            </div>
            
            <br>
            <br>
            <br>
        </div
    </body>
</html>