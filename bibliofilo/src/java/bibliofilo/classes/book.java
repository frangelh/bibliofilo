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
        this.isbn = isbn;
        this.autor = autor;
        this.estrellas = estrellas;
        this.pubDate = pubDate;
        this.categoria = categoria;
        this.codigo = codigo;
        this.imagen = imagen;
    }
    public book(){}
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

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
