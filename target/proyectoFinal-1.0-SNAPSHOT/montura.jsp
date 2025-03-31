<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.proyectofinal.constructor.constructorMontura" %>
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
        
        <!-- MONTURAS BODY -->
        <div class="monturas_body">
            <div class="datos_div">
                <div class="categoria_div">
                    <h2>Categoría de Montura</h2>
                    <select class="form-control select_montura">
                        <option value="">Todas</option>
                        <option value="metal">Metal</option>
                        <option value="titano">Titanio</option>
                        <option value="aleaciones_titanio">Aleaciones de Titanio</option>
                        <option value="aluminio">Aluminio</option>
                        <option value="acero_inoxidable">Acero Inoxidable</option>
                        <option value="monel">Monel</option>
                        <option value="berilio">Berilio</option>
                        <option value="plastico">Plastico</option>
                        <option value="acetato">Acetato</option>
                        <option value="tr90">TR90</option>
                        <option value="nylon">Nylon</option>
                        <option value="zyl">Zyl</option>
                    </select>
                </div>
                <div class="añadir_div">
                    <h2>Añadir Montura</h2>
                    <form action="monturas" method="post">
        <input type="number" name="codigoMontura" class="form-control input_montura" placeholder="Código" required>
        <select name="tipoMontura" class="form-control select_montura" required>
            <option value="" disabled selected>Tipo de Montura</option>
            <option value="Metal">Metal</option>
            <option value="Titanio">Titanio</option>
            <option value="Aleaciones Titanio">Aleaciones de Titanio</option>
            <option value="Aluminio">Aluminio</option>
            <option value="Acero Inoxidable">Acero Inoxidable</option>
            <option value="Monel">Monel</option>
            <option value="Berilio">Berilio</option>
            <option value="Plastico">Plastico</option>
            <option value="Acetato">Acetato</option>
            <option value="TR90">TR90</option>
            <option value="Nylon">Nylon</option>
            <option value="Zyl">Zyl</option>
        </select>
        <input type="number" step="0.01" name="precio" class="form-control input_montura" placeholder="Precio" required>
        <input type="number" step="0.01" name="longitudMontura" class="form-control input_montura" placeholder="Longitud de montura" required>
        <input type="number" step="0.01" name="anchoPuente" class="form-control input_montura" placeholder="Ancho de puente" required>
        <input type="number" step="0.01" name="longitudVarilla" class="form-control input_montura" placeholder="Longitud de varilla" required>
        <input type="number" step="0.01" name="longitudLente" class="form-control input_montura" placeholder="Longitud de la lente" required>
        <input type="text" name="linkFoto" class="form-control input_montura" placeholder="URL de la Foto" required>
                        <div class="div_invisible"></div>
                <button type="submit" class="botones_general text-light">Añadir</button>
                <div class="div_invisible"></div>
                    </form>
                </div>
                
            </div>
            
            <div class='contenedor_montura'>
                <h2>Monturas</h2>
                <div class="contenedor_montura_div">
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
                                    String sql = "SELECT * FROM montura";
                                    stmt = conn.createStatement();
                                    rs = stmt.executeQuery(sql);

                                    // Iterar los resultados
                                    while (rs.next()) {
                            %>
                        <div class='carta_montura_div'>
                            <img src="<%= rs.getString("linkFoto") %>"/>
                            <h5 class='codigo_montura'>Código: <%= rs.getString("codigoMontura") %></h5>
                            <p>Tipo de montura: <%= rs.getString("tipoMontura") %></p>
                            <p class="precio_montura">Precio: S/<%= rs.getString("precio") %></p>
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
                </div>
            </div>
            
            
        </div
    </body>
</html>
