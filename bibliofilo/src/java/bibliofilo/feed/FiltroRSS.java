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
    private final String rTitulo = ".*<span class=\"riRssTitle\"><a.*>(.*)</a></span>.*";

    private String Autor = "";
    private final String rAutor = ".*<span class=\"riRssContributor\"><a.*>(.*)</a>.*<span.*>.*</span></span>.*";
    private final String arAutor = ".*<span class=\"riRssContributor\">(.*)<span.*>.*</span></span>.*";
    private final String brAutor = ".*<span class=\"riRssContributor\">(.*)</span>.*";

    private String Estrella = "";
    private final String rEstrella = ".*<img src=\".*stars-(\\d)-(\\d).*\\.gif\".*/>.*";

    private String rDate = "";
    private final String aDate = ".*<span class=\"riRssReleaseDate\">Release Date:(.*) <br /></span>.*";
    private final String bDate = ".*<span class=\"riRsseleaseDate\\\"><em class=\\\"notPublishedYet\\\">Release Date:(.*)</em><br /></span>.*";
    private String Fuente;

    public void setFuente(String Fuente) {
        this.Fuente = Fuente;
    }

    public String getPrecio() {
        if (Fuente.matches(rPrecio)) {
            Precio = Fuente.replaceAll(rPrecio, "$1");
        } else {
            Precio = "";
        }
        return Precio;
    }

    public String getTitulo() {
        if (Fuente.matches(rTitulo)) {
            Titulo = Fuente.replaceAll(rTitulo, "$1");
        } else {
            Titulo = "";
        }
        return Titulo.replace("'","\\'");
    }

    public String getEstrellas() {
        if (Fuente.matches(rEstrella)) {
            Estrella = Fuente.replaceAll(rEstrella, "$1.$2");
        } else {
            Estrella = "0.0";
        }
        return Estrella;
    }

    public String getDate() {
        if (Fuente.matches(aDate)) {
            rDate = Fuente.replaceAll(aDate, "$1");
        } else if (Fuente.matches(bDate)) {
            rDate = Fuente.replaceAll(bDate, "$1");
        } else {
            rDate = "Unreleased";
        }
		if(rDate.equals("Unreleased")){
			rDate = "-1,-1,-1";
		}
		else{
			int NumeroMes=0;
			String [] tmp = rDate.trim().split(" ");
			if(tmp[0].toLowerCase().equals("january")){ NumeroMes = 1;}
			if(tmp[0].toLowerCase().equals("february")){ NumeroMes = 2;}
			if(tmp[0].toLowerCase().equals("march")){ NumeroMes = 3;}
			if(tmp[0].toLowerCase().equals("apri")){ NumeroMes = 4;}
			if(tmp[0].toLowerCase().equals("may")){ NumeroMes = 5;}
			if(tmp[0].toLowerCase().equals("june")){ NumeroMes = 6;}
			if(tmp[0].toLowerCase().equals("july")){ NumeroMes = 7;}
			if(tmp[0].toLowerCase().equals("augusts")){ NumeroMes = 8;}
			if(tmp[0].toLowerCase().equals("septembe")){ NumeroMes = 9;}
			if(tmp[0].toLowerCase().equals("october")){ NumeroMes = 10;}
			if(tmp[0].toLowerCase().equals("november")){ NumeroMes = 11;}
			if(tmp[0].toLowerCase().equals("december")){ NumeroMes = 12;}
			rDate = NumeroMes +","+ tmp[1] + tmp[2];
		}
        
        return rDate;
    }

    public String getAutor() {
        if (Fuente.matches(rAutor)) Autor = Fuente.replaceAll(rAutor, "$1");
        else if(Fuente.matches(arAutor))Autor = Fuente.replaceAll(arAutor,"$1");
        else if (Fuente.matches(brAutor))  Autor = Fuente.replaceAll(brAutor, "$1");
        else Autor = "";
        Autor =Autor.replaceAll("<.*?>|</*?>|~|Release Date: \\w+ \\d+, \\d+|\\(\\d+\\).*|\\(.*\\)|Buy new.*|by ","");        
        return Autor;
    }

    @Override
    public String toString() {
        String tFuente = Fuente;
        tFuente = tFuente.replaceAll("<span class=\"riRssReleaseDate\">.*", "");
        tFuente += "<span class=\"price\"><font color=\"red\"><b>$";
        tFuente += getPrecio();
        tFuente += "</b></font></span><br /><br/><br/><br/><br/><br/><br/><br/>";
        return tFuente;
    }
}
