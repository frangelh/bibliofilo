/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliofilo.feed;

/**
 *
 * @author mrmomo
 */
public class FiltroRSS {
	private String Precio = "";
	private final String rPrecio = ".*<font .*><b>.(.*)</b></font>.*";
	
	private String Titulo = "";
	private final  String rTitulo = ".*<span class=\"riRssTitle\"><a.*>(.*)</a></span>.*";
	
	private String Autor = "";
	private final String  rAutor = ".*<span class=\"riRssContributor\"><a.*>(.*)</a>.*<span.*>.*</span></span>.*";
	private final String arAutor = ".*<span class=\"riRssContributor\">(.*)<span.*>.*</span></span>.*";
        private final String brAutor = ".*<span class=\"riRssContributor\">(.*)</span>.*";

	private String Estrella = "";
	private final String rEstrella = ".*<img src=\".*stars-(\\d)-(\\d).*\\.gif\".*/>.*";
	
	private String Fuente;
	
	public void setFuente(String Fuente){
		this.Fuente = Fuente;
	}
	
	public String getPrecio(){
		if(Fuente.matches(rPrecio))Precio = Fuente.replaceAll(rPrecio,"$1");
		else Precio = "";
		return Precio;
	}
	
	public String getTitulo(){
		if(Fuente.matches(rTitulo))Titulo = Fuente.replaceAll(rTitulo,"$1");
		else Titulo = "";
		return Titulo;
	}
	
	public String getEstrellas(){
		if(Fuente.matches(rEstrella))Estrella = Fuente.replaceAll(rEstrella,"$1.$2");
		else Estrella = "0.0";
		return Estrella;
	}
		
	public String getAutor(){
		if(Fuente.matches(rAutor))Autor = Fuente.replaceAll(rAutor,"$1");
                else if(Fuente.matches(arAutor))Autor = Fuente.replaceAll(arAutor,"$1");
                else if(Fuente.matches(brAutor))Autor = Fuente.replaceAll(brAutor,"$1");
		else Autor = "";	
		return Autor;
	}
	
	@Override
	public String toString(){
		String tFuente = Fuente;
		tFuente= tFuente.replaceAll("<span class=\"riRssReleaseDate\">.*","");
		tFuente += "<span class=\"price\"><font color=\"red\"><b>$";
		tFuente += getPrecio();
		tFuente += "</b></font></span><br /><br/><br/><br/><br/><br/>";
		return tFuente;
	}
}
