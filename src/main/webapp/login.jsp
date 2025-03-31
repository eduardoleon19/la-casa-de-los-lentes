<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./css2/styles.css">
    </head>
    <body class="body_login">
        <div class="logo_login d-flex justify-content-center">
                <img class="login_img" src="https://scontent.flim17-1.fna.fbcdn.net/v/t39.30808-6/307495481_506637318143583_8034179687348594998_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeGa81lEQJYYfvC4Fa_8QWdtS_ISqpktjKNL8hKqmS2MozyzdBtR2JSSN1Sp6THZfKQiqmvsdLajkZTqvBjYll_9&_nc_ohc=edLJg6pf5hoQ7kNvgG1GmjT&_nc_oc=AdgMDk9xJazC1fiLM7JtWOuEKe0YHOMeQgzRFST6Y3VYvpTjYPm-9WnMWiHhNq5EktE&_nc_zt=23&_nc_ht=scontent.flim17-1.fna&_nc_gid=AGqG7eEgkhTm0zdyHndda_b&oh=00_AYApdglxSsmL6J1AmNrDmcD2ooVWlxHmsVMaKsHNSyjUsw&oe=67A9FCF6">
        </div>
        <div class="login_div">
        <form action="login" method="post">
            <div class="login_input_div">
                <div>
                    <input type="email" class="form-control input_login" name="correo" placeholder="Correo electrónico" required>
                </div>
                <div>
                    <input type="password" class="form-control input_login" name="password" placeholder="Contraseña" required>
                </div>
            </div>
            <div class="boton_div_2">
                <div class="div_invisible"></div>
                <button type="submit" class="botones_general text-light">Iniciar Sesión</button>
                <div class="div_invisible"></div>
            </div>
        </form>

        <!-- Mostrar mensaje de error si existe -->
        <% String error = request.getParameter("error"); %>
        <% if (error != null) { %>
            <div class="alert alert-danger">
                <%= "Error: " + error.replace("_", " ") %>
            </div>
        <% } %>
        <br>
        <div class="text-center">
            <p>¿No tienes una cuenta? <a href="register.jsp" class="login_register link-opacity-100">Regístrate aquí</a></p>
        </div>
    </div>
    </body>
</html>
