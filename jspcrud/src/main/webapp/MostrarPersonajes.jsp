
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
        <div class="container-md text-center mt-5">
            <h1 class="h1 mb-5">Personajes</h1>
            <div class="mb-5">
                <h2 class="h2">Insertar un Personaje Nuevo</h2>
                <form class="border p-5 mt-3" action="MostrarPersonasController" method="POST">
                    <div class="form-floating m-3">
                        <input type="text" class="form-control pt-4 fs-3" id="floatingInput">
                        <label for="floatingInput">Nombre del personaje</label>
                    </div>
                    <button class="btn btn-primary" type="submit">Insertar</button>
                </form>
            </div>

            <div>
                <h2 class="h2">Lista de todos los personajes</h2>
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
                            for (Personaje personaje : personajes) {
                        %>
                        <tr>
                            <th scope="row"><%= count%></th>
                            <td class="fs-4"><%= personaje.getNombre()%></td>
                            <td>
                                <button type="button" class="btn btn-outline-primary">
                                    <a class="nav-link"  href="ModificarPersonajesController?id=<%= personaje.getId()%>">Modificar</a>
                                </button>
                                <button type="button" class="btn btn-outline-danger ms-5">
                                    <a class="nav-link"  href="EliminarPersonajesController?id=<%= personaje.getId()%>">Eliminar</a>
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
