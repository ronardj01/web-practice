
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Personaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personajes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container-md mt-5">
            <h1 class="h1 mb-5 text-center">Personajes</h1>
            <div class="mb-5">
                <h2 class="h2 text-center">Insertar un Personaje Nuevo</h2>
                <form class="border p-5 mt-3 text-center" action="MostrarPersonasController" method="POST">
                    <div class="form-floating m-3">
                        <input type="text" class="form-control pt-4 fs-3" id="floatingInput" name="nombre">
                        <label for="floatingInput">Nombre del personaje</label>
                    </div>
                    <button class="btn btn-primary ms-3" type="submit">Insertar</button>
                </form>
            </div>

            <div class="mb-5">
                <h2 class="h2 text-center">Lista de todos los personajes</h2>
                <table class="table table-secondary table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nombre</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Personaje> personajes = (ArrayList<Personaje>) request.getAttribute("personajes");
                            int count = 1;
                            String param;
                            for (Personaje personaje : personajes) {
                            param ="?id=" + personaje.getId() + "&nombre=" + personaje.getNombre().replace(" ", "_");
                        %>
                        <tr>
                            <th scope="row"><%= count%></th>
                            <td class="fs-4"><%= personaje.getNombre()%></td>
                            <td>
                                <button type="button" class="btn btn-outline-primary">
                                    <a class="nav-link"  href="ModificarPersonajesController<%= param%>">Modificar</a>
                                </button>
                                <button type="button" class="btn btn-outline-danger ms-5">
                                    <a class="nav-link"  href="DeletePersonajeController<%= param%>">Eliminar</a>
                                </button>
                            </td>
                        </tr>
                        <% count++;
                            }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
