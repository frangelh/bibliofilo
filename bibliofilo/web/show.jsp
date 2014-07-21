<%@page import="bibliofilo.classes.book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bibliofilo.feed.Prolog"%>
<%@ include file="template/header.jsp" %>

<div class=" panel panel-primary">
    <div class="panel-heading">Sus libros:</div>
    <div class="panel-body" >
        <div class="list-group list">
            <%
                Float sueldo = Float.valueOf((String) session.getAttribute("sueldo"));
                Prolog pl = new Prolog(); //ConsultarProlog("sueldo10pociento("+Sueldo+",\'"+Categoria+"\')");
                String categoria = request.getParameter("select");
                String autor = request.getParameter("autor");
                String opcion = request.getParameter("opcion");
                String palabra = request.getParameter("palabra");
                String inferior = request.getParameter("minima");
                String superior = request.getParameter("maximo");
                String preciomenor = request.getParameter("preciomenor");
                String preciomayor = request.getParameter("preciomayor");
                Float extra = Float.valueOf((String) request.getParameter("extra"));

                String query = "";
                if (opcion.equals("1")) {
                    //findbookfecha(Sueldo,Dias)
                    query = "findbookfecha(" + extra + ",7)";
                    System.out.print(query);
                } else if (opcion.equals("2")) {
                    query = "sueldo10pociento(" + (extra + (sueldo * 0.1)) + ",\'" + categoria.replace("'", "\\'") + "\')";
                    System.out.print(query);
                } else if (opcion.equals("3")) {
                    //usado50porciento(Sueldo)
                    query = "usado50porciento(" + extra + ")";
                } else if (opcion.equals("4")) {
                    //libroCategoriaAutor20(Presupuesto,Autor,Categoria,NoContiene) 
                    query = "libroCategoriaAutor20(" + (sueldo*0.2) + ",\'" + autor.replace("'", "\\'") + "\'" + ",\'" + categoria.replace("'", "\\'") + "\'" + "," + "\'" + palabra.replace("'", "\\'") + "\'" + ")";
                    System.out.print(query);
                } else if (opcion.equals("5")) {
                    //encontrarCategoria5Estellas(Categoria)
                    query = "encontrarCategoria5Estellas(" + "\'" + categoria.replace("'", "\\'") + "\')";
                    System.out.print(query);
                } else if (opcion.equals("6")) {
                    //todacategoriarango(Categoria,Estrellainferior,Estrellasuperior):-
                    query = "todacategoriarango(" + "\'" + categoria.replace("'", "\\'") + "\'" + "," + inferior + "," + superior + " )";
                    System.out.print(query);
                } else if (opcion.equals("7")) {
                    //commingsoon:-
                    query = "commingsoon";
                    System.out.print(query);

                } else if (opcion.equals("8")) {
                    //autortotal(Autor)
                    query = "autortotal(" + "\'" + autor.replace("'", "\\'") + "'," + preciomenor + "," + preciomayor + ")";
                    System.out.print(query);
                }

                ArrayList<book> consulta = pl.ConsultarProlog(query);
                System.out.print(consulta.size());
                for (book actual : consulta) {
                    //System.out.print(actual.GetBook());
%>


            <div class="list-group-item">
                <%=actual.GetBook()%>  

            </div>
            <% }%>
        </div>
    </div>
</div>


<%@ include file="template/footer.jsp"%>