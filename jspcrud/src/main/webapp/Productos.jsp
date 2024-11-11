<%@page import="entidades.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container-md mt-5">
            <jsp:include page="IncludeNav.jsp"/>
            <h1 class="h1 mb-5 text-center">Productos</h1>
            <div class="mb-5">
                <h2 class="h2 text-center">Insertar un producto nuevo</h2>
                <form class="border p-5 mt-3 text-center" action="ProductoServlet" method="POST">
                    <div class="form-floating m-3">
                        <input type="text" class="form-control pt-4 fs-3" id="floatingInput" name="nombre">
                        <label for="floatingInput">Nombre del producto</label>
                    </div>
                    <button class="btn btn-primary ms-3" type="submit">Insertar</button>
                </form>
            </div>

            <div class="mb-5">
                <h2 class="h2 text-center">Lista de todos los productos</h2>
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
                            ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
                            if (productos != null && !productos.isEmpty()) {
                                int count = 1;
                                String param;
                                for (Producto producto : productos) {
                                    param = "?id=" + producto.getId() + "&nombre=" + producto.getNombre().replace(" ", "_");
                        %>
                        <tr>
                            <th scope="row"><%= count%></th>
                            <td class="fs-4"><%= producto.getNombre()%></td>
                            <td>
                                <button type="button" class="btn btn-outline-primary">
                                    <a class="nav-link" href="ActualizarProductoServlet<%= param%>">Modificar</a>
                                </button>
                                <button type="button" class="btn btn-outline-danger ms-5">
                                    <a class="nav-link" href="BorrarProductoServlet<%= param%>">Eliminar</a>
                                </button>
                            </td>
                        </tr>
                        <%
                                count++;
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="3" class="text-center">No hay productos disponibles.</td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
