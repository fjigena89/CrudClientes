<%-- 
    Document   : clientes
    Created on : 27 dic 2022, 20:20:00
    Author     : Florencia
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Clientes" %>
<%@page import="modelo.ClientesDAO" %>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/2cbbc87d30.js" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1>Listado de Clientes</h1>


        <div class="container">
            <div class="row">   
                <a class="btn btn-primary col-4 m-4" href="ClientesController?accion=alta">Agregar Cliente</a>

                <table class="table table-primary">
                    <thead>
                            <th>id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                             <th>Dirección</th>
                             <th>Localidad</th>
                             <th>Fecha Nac.</th>
                             <th>Teléfono</th>
                             <th>E-Mail</th>
                             <th>Modificar</th>
                             <th>Eliminar</th>
                    </thead>

                    <%
                    List<Clientes> resultado=null;
                    ClientesDAO c1=new ClientesDAO();
                    resultado=c1.listarClientes();
                    
                                for(int i=0;i<resultado.size();i++)
				{
				String ruta="ClientesController?accion=editar&id="+resultado.get(i).getIdCliente();	
				String rutaE="ClientesController?accion=eliminar&id="+resultado.get(i).getIdCliente();
				%>                


                    <tr>
                         <td><%=resultado.get(i).getIdCliente()%></td>
                         <td><%=resultado.get(i).getNombre()%></td>
                         <td><%=resultado.get(i).getApellido()%></td>
                         <td><%=resultado.get(i).getDireccion()%></td>
                         <td><%=resultado.get(i).getLocalidad()%></td>
                         <td><%=resultado.get(i).getFnac()%></td>
                         <td><%=resultado.get(i).getTelefono()%></td>
                         <td><%=resultado.get(i).getMail()%></td>
                         <td class="text-center"><a href=<%=ruta%>> <i class="fa-solid fa-arrow-right-arrow-left"></i> </a></td>
			 <td class="text-center"><a href=<%=rutaE%>><i class="fa-solid fa-arrow-down"></i> </a></td>
                    </tr>
                    <%
                        }
                    %>

                </table>




            </div>


        </div>




    </body>
</html>