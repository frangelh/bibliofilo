/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliofilo.classes;

/**
 *
 * @author frangel
 */
public class book {

    private String titulo;
    private String precio;
    private String isbn;
    private String autor;
    private String estrellas;
    private String pubDate;
    private String categoria;
    private String codigo;
    private String imagen;

    public book(String titulo, String precio, String isbn, String autor, String estrellas, String pubDate, String categoria, String codigo, String imagen) {
        this.titulo = titulo;
        this.precio = precio;
        //.isbn = isbn;
        this.autor = autor;
        this.estrellas = estrellas;
        this.pubDate = pubDate;
        this.categoria = categoria;
        // this.codigo = codigo;
        this.imagen = imagen;
    }

    public book() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }

    public String getPubDate() {
        if (pubDate.contains("-1")) {
            return " Unreleased";
        }
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    /*
    
     private String titulo;
     private String precio;
     private String isbn;
     private String autor;
     private String estrellas;
     private String pubDate;
     private String categoria;
     private String codigo;
     private String imagen;
     */

    public String GetBook() {
        if (getPubDate().contains("Unreleased")) {
            setPubDate("<strike>" + getPubDate() + "</strike>");
        }

        return ("<div class=\"list-group\"><legend><b>Titulo del libro: </b> " + titulo + "<br/></legend></div>"
                + "<div class=\"list-group-item \"><h2 class=\"text-primary\"><b>Precio: </b><span class=\"h1 text-primary\">" + precio + "</span></h2><br/> </div>"
                + "<div class=\"list-group-item \"><b>Autor: </b><span class=\"text-warning h4\">" + autor + "</span><br/> </div>"
                + "<div class=\"list-group-item \"><b>Estrellas: </b><div class=\"glyphicon glyphicon-star text-info \" style=\" font-size:20px;\">" + estrellas + "</div><br/> </div>"
                + "<div class=\"list-group-item \"><b>Fecha publicacion: </b><span class=\" text-danger\">" + getPubDate() + "</span><br/> </div>"
                + "<div class=\"list-group-item \"><b>Categoria: </b><span class=\"h4 text-success\">" + categoria).replace("'", "") + "</span></div>";
    }

}
