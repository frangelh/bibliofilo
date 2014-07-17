/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliofilo.feed;

import bibliofilo.feed.FeedParser;
import java.util.ArrayList;

/**
 *
 * @author frangel
 */
public class FeedReader {

    public static String url1 = "http://www.amazon.com/gp/rss/new-releases/books/";
    private static ArrayList<String> url = new ArrayList<>();

    public static void llenarurl() {
        url.add("http://www.amazon.com/gp/rss/new-releases/books/1");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/2");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/3");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/4");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/5");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/6");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/7");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/9");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/10");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/20");
    }

    public static String imprimir() {
        llenarurl();
        int conta = 1;
        String msg = "";
        for (String UrlActual : url) {
            FeedParser parser = new FeedParser(UrlActual);
            Feed feed = parser.readFeed();
            FiltroRSS fr = new FiltroRSS();          
            for (FeedMessage message : feed.getMessages()) {
                fr.setFuente(message.getDescription());
                // aprolog(fr..,message.getGuig())
                msg += fr.toString();
            }

        }
        return msg;
    }
    
    public static void main(String[] args) {
        llenarurl();
        int conta = 1;
        for (String UrlActual : url) {
            FeedParser parser = new FeedParser(UrlActual);
            Feed feed = parser.readFeed();
            FiltroRSS fr = new FiltroRSS();

            for (FeedMessage message : feed.getMessages()) {
                fr.setFuente(message.description);

        
                    System.out.println(conta++ + "  Titulo: " + fr.getTitulo());
                 //   System.out.println("\t Precio: " + fr.getPrecio());
                     System.out.print(UrlActual);
                    System.out.println("\t Fecha: "+fr.getDate());
                   // System.out.println("\t Author: " + fr.getAutor());
                 //   System.out.println("\t Estrellas: " + fr.getEstrellas());

                    //System.out.println(message.title);
                
            }
        }
    }
}
