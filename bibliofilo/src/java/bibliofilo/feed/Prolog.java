/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliofilo.feed;
import java.io.RandomAccessFile;
/**
 *
 * @author mrmomo
 */
public class Prolog {
    FiltroRSS Info;
    RandomAccessFile test;
    public void setInfo(FiltroRSS Informacion){
        Info = Informacion;
    }
    public void EnviarARchivo(String url,String Guid){
        try{
            test  = new RandomAccessFile("test.pl","rw");
            test.write(("%"+url+"\n").getBytes());
            test.write( ("librotitulo(\'"+ Info.getTitulo()+ "," + Guid +"\').\n" ) .getBytes()  );
            test.write( ("autorlibro(\'"+ Info.getAutor()+ "," + Guid +"\').\n" ).getBytes());
            test.write( ("libroestrellas(\'"+ Info.getEstrellas()+ "," + Guid +"\').\n" ).getBytes());
            test.write( ("preciolibro(\'"+ Info.getPrecio()+ "," + Guid +"\').\n" ).getBytes());
            test.write( ("librotitulo(\'"+ Info.getDate()+ "," + Guid +"\').\n" ).getBytes());
            System.out.println("url:"+url);
            System.out.println("url:"+Info.getTitulo());
            System.out.println("getAutor:"+Info.getAutor());
            System.out.println("getEstrellas:"+Info.getEstrellas());
            System.out.println("getPrecio:"+Info.getPrecio());
            System.out.println("getDate:"+Info.getDate());
            
            test.close();
                        
        }
        catch(Exception r){}
    }
}
