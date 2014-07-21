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

    private ArrayList<String> url = new ArrayList<>();
    Prolog test = new Prolog();

    public void llenarurl() {
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
        url.add("http://www.amazon.com/gp/rss/new-releases/books/17");
        url.add("http://www.amazon.com/gp/rss/new-releases/books/18");
    }

    public ArrayList<String> Actualizar() {
        llenarurl();
        int conta = 1;
        String msg = "";
        ArrayList<String> aRetornar = new ArrayList<>();
        for (String UrlActual : url) {
            FeedParser parser = new FeedParser(UrlActual);
            Feed feed = parser.readFeed();
            FiltroRSS fr = new FiltroRSS();
            for (FeedMessage message : feed.getMessages()) {
                fr.setFuente(message.getDescription());
                String categoria = "";
                if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/2")) {
                    categoria = "Biographies & Memoirs";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/3")) {
                    categoria = "Business & Money";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/4")) {
                    categoria = "Children\'s Books";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/5")) {
                    categoria = "Computers & Technology";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/6")) {
                    categoria = "Cookbooks, Food & Wine";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/7")) {
                    categoria = "Dance & Electronic";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/9")) {
                    categoria = "History";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/10")) {
                    categoria = "Health, Fitness & Dieting";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/20")) {
                    categoria = "Parenting & Relationships";
                } else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/1")) {
                    categoria = "Arts & Photography";
                }else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/18")) {
                    categoria = "Mystery, Thriller & Suspense";
                }else if (UrlActual.equals("http://www.amazon.com/gp/rss/new-releases/books/17")) {
                    categoria = "Literature & Fiction";
                }
                test.setInfo(fr);
                //test.ConsultarProlog();
                String nguid = message.getGuid().replaceAll("new-releases_books_.*_","");
                System.out.println(nguid);
                test.CrearProlog(UrlActual,nguid , categoria);

               //System.out.println(fr.getDate());
               /*
                 prolog(fe.getTitulo(),message.getGuid());
                 prolog(fe.getAutor(),message.getGuid());
                 prolog(fe.getEstrella(),message.getGuid());
                 prolog(fe.getCategoria(),message.getGuid());
                 prolog(fe.getFecha(),message.getGuid());
                
                 */
                aRetornar.add(fr.toString());
            }

        }
        return aRetornar;
    }

    public String imprimir() {
        String msg = "";
        for (String MsgActual : Actualizar()) {
            msg += MsgActual;
        }
        return msg;
    }

    public void Save() {
        test.Save();
    }

}
