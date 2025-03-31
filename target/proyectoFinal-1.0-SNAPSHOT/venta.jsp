<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <img class="logo_img" src="https://scontent.flim17-1.fna.fbcdn.net/v/t39.30808-6/307495481_506637318143583_8034179687348594998_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeGa81lEQJYYfvC4Fa_8QWdtS_ISqpktjKNL8hKqmS2MozyzdBtR2JSSN1Sp6THZfKQiqmvsdLajkZTqvBjYll_9&_nc_ohc=edLJg6pf5hoQ7kNvgG1GmjT&_nc_oc=AdgMDk9xJazC1fiLM7JtWOuEKe0YHOMeQgzRFST6Y3VYvpTjYPm-9WnMWiHhNq5EktE&_nc_zt=23&_nc_ht=scontent.flim17-1.fna&_nc_gid=AGqG7eEgkhTm0zdyHndda_b&oh=00_AYApdglxSsmL6J1AmNrDmcD2ooVWlxHmsVMaKsHNSyjUsw&oe=67A9FCF6">
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
        
        <!-- BODY -->
        <div class="ventas_body">
            <h1 class="text-center">Registro de Ventas</h1>
            <div class="h2_body mb-3">
                <h2>Cabecera</h2>
                <form action="ventas" method="post">
                    <div class="input_div">
                        <input type="number" name="codigoBoleta" class="form-control input_text" placeholder="Código de Boleta" required>
                        <input type="text" name="fechaCreacion" class="form-control input_text" placeholder="Fecha de Creación" required>
                        <input type="number" name="dniPaciente" class="form-control input_text" placeholder="DNI del paciente" required>
                    </div>
                </div>
                <div class="h2_body mb-3">
                    <h2>Agudeza Visual</h2>
                    <h4>Ojo Izquierdo</h4>
                    <div class="input_div">
                        <input type="number" name="esferaIzq" class="form-control input_text" placeholder="Esfera" required step="any">
                        <input type="number" name="cilindroIzq" class="form-control input_text" placeholder="Cilindro" required step="any">
                        <input type="number" name="gradoIzq" class="form-control input_text" placeholder="Grado" required step="any">
                        <input type="number" name="distanciaIzq" class="form-control input_text" placeholder="Distancia Pupilar" required step="any">
                    </div>
                    <h4>Ojo Derecho</h4>
                    <div class="input_div">
                        <input type="number" name="esferaDer" class="form-control input_text" placeholder="Esfera" required step="any">
                        <input type="number" name="cilindroDer" class="form-control input_text" placeholder="Cilindro" required step="any">
                        <input type="number" name="gradoDer" class="form-control input_text" placeholder="Grado" required step="any">
                        <input type="number" name="distanciaDer" class="form-control input_text" placeholder="Distancia Pupilar" required step="any">
                    </div>
                </div>
                <div class="h2_body mb-3">
                    <h2>Detalle</h2>
                    <div class="input_div">
                        <input type="number" name="codigoMontura" class="form-control input_text" placeholder="Codigo de Montura" required>
                        <select name="tipoLuna" class="form-control select_text" required>
                            <option value="" disabled selected>Tipos de Lunas</option>
                            <option value="cristal">Cristal</option>
                            <option value="cr_39">CR-39</option>
                            <option value="policarbonato">Policarbonato</option>
                            <option value="trivex">Trivex</option>
                            <option value="futurex">Futurex</option>
                        </select>
                        <input type="number" name="costoTotal" class="form-control input_text" placeholder="Costo Total" required>
                        <input type="text" name="fechaEntrega" class="form-control input_text" placeholder="Fecha de Entrega" required>
                    </div>
                </div>
                <div class="boton_div_2">
                    <div class="div_invisible"></div>
                    <button type="submit" class="botones_general text-light">Añadir</button>
                    <div class="div_invisible"></div>
                </div>
            </form>
            </div>
            <br>
            <br>
            <br>
        </div>
        
    </body>
    
</html>
