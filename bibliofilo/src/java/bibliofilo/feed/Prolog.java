/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliofilo.feed;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    public void CrearProlog(String url,String Guid){
        String librotitulo = "assertz(librotitulo(\'"+ Info.getTitulo()+ "\',\'" + Guid +"\')),";
        String autorlibro = "assertz(autorlibro(\'"+ Info.getAutor()+ "\',\'" + Guid +"\'))," ;
        String libroestrellas = "assertz(libroestrellas(\'"+ Info.getEstrellas()+ "\',\'" + Guid +"\'))," ;
        String preciolibro = "assertz(preciolibro(\'"+ Info.getPrecio()+ "\',\'" + Guid +"\'))," ;
        Runtime r = Runtime.getRuntime();
        Process p;
        try{		
                p = r.exec("ls hechos.pl");
                p.waitFor();
                if(p.exitValue() > 0){
                    p = r.exec("touch hechos.pl");
                    p.waitFor();
                }
                //System.out.println("what "+librotitulo);
                String toProlog = "consult('hecho.pl'),"+librotitulo+autorlibro+libroestrellas+preciolibro+"tell('hecho.pl'),listing,told.";
                //String [] run =new String[]{"swipl","-g",toProlog,"-t","halt"};
                String [] run =new String[]{"swipl","-g",toProlog,"-t","halt"};
                //System.out.println(librotitulo);
                //String run ="swipl -f hechos.pl -g " +librotitulo+" -t halt ";
               // System.out.println("["+run+"]");
                p = r.exec(run);
                p.waitFor();
                BufferedReader c = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                String line;
                while ((line = c.readLine()) != null) {
                 System.out.println("ERROR: "+line+"\n");
                }
                //System.out.println(p.exitValue());
        }

        catch (Exception e){System.out.println(e);}
    }
    
    public void EnviarARchivo(String url,String Guid){
        try{
            String librotitulo = "librotitulo(\'"+ Info.getTitulo()+ "\',\'" + Guid +"\').\n";
            String autorlibro = "autorlibro(\'"+ Info.getAutor()+ "\',\'" + Guid +"\').\n" ;
            String libroestrellas = "libroestrellas(\'"+ Info.getEstrellas()+ "\',\'" + Guid +"\').\n" ;
            String preciolibro = "preciolibro(\'"+ Info.getPrecio()+ "\',\'" + Guid +"\').\n\n\n\n" ;
            
            test  = new RandomAccessFile("test.pl","rwd");
            test.seek(test.length());
            test.write(("%"+url+"\n").getBytes());
            test.write(  librotitulo.getBytes()  );
            test.write( autorlibro.getBytes());
            test.write( libroestrellas.getBytes());
            test.write( preciolibro.getBytes());
          
            test.close();
                        
        }
        catch(Exception r){}
    }
}
