/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliofilo.feed;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
/**
 *
 * @author mrmomo
 */
public class Prolog {
    FiltroRSS Info;
    RandomAccessFile test;
    String PrologStuff="";
    public void setInfo(FiltroRSS Informacion){
        Info = Informacion;
    }
    public ArrayList<String> ConsultarProlog(String Consulta) {
		Runtime r = Runtime.getRuntime();
        ArrayList<String> aRetornar = new ArrayList<String>();
        Process p;
        try{
			p = r.exec("ls reglas.pl");
			p.waitFor();
			if(p.exitValue() > 0){
				try{
					RandomAccessFile tmp = new RandomAccessFile("reglas.pl","rw");
					tmp.write("init:-consult('hechos.pl').".getBytes());
					tmp.close();
				}
				catch(Exception e){}
				
			}
			String toProlog ="init,"+Consulta;
			String [] run =new String[]{"swipl","-f","reglas.pl","-g",toProlog,"-t","halt"};
			p = r.exec(run);
			p.waitFor();
			BufferedReader c = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader d = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			String line;
			
			while ((line = c.readLine()) != null) {
				aRetornar.add(line);
			}
			while ((line = d.readLine()) != null) {
				//System.out.println("Error From Prolog"+line);
			}
        }
		catch(Exception e){}
		return aRetornar;
    }
    public void  Save(){
        Runtime r = Runtime.getRuntime();
        Process p;
        try{
			p = r.exec("ls hechos.pl");
			p.waitFor();
			if(p.exitValue() > 0){
				p = r.exec("touch hechos.pl");
				p.waitFor();
			}
			String [] run =new String[]{"swipl","-f","hechos.pl","-g",PrologStuff+"tell('hechos.pl'),listing(librotitulo),listing(autorlibro),listing(libroestrellas),listing(preciolibro),listing(fechalibro),listing(categorialibro),told.","-t","halt"};
			p = r.exec(run);
			p.waitFor();
			BufferedReader c = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader d = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			String line;
			while ((line = c.readLine()) != null) {
				System.out.println(line);
			}
			while ((line = d.readLine()) != null) {
				//if(line.contains("compile"))System.out.println(line);
				if(!line.contains("compile"))System.out.println("Error "+line);
			}
        }
		catch(Exception e){}
		//System.out.println(PrologStuff);
		try{
			RandomAccessFile a = new RandomAccessFile("log","rw");
			a.write(PrologStuff.getBytes());
			a.close();
		}
		catch(Exception e){}
		PrologStuff=null;
                PrologStuff="";
                
    }
    public void CrearProlog(String url,String Guid,String Categoria){
        String librotitulo = "assertz(librotitulo(\'"+ Info.getTitulo()+ "\',\'" + Guid +"\')),";
        String autorlibro="";
        for (String CadaAutor: Info.getAutor().split(",")) {
            if(CadaAutor.equals(""))continue;
            //System.out.println(CadaAutor.trim().replace("'","\\'"));
            autorlibro += "assertz(autorlibro(\'"+ CadaAutor.trim().replace("'","\\'")+ "\',\'" + Guid +"\'))," ;
        }
        //System.out.println(autorlibro);
        String libroestrellas = "assertz(libroestrellas("+ Info.getEstrellas()+ ",\'" + Guid +"\'))," ;
        String preciolibro = "assertz(preciolibro("+ Info.getPrecio()+ ",\'" + Guid +"\'))," ;
        String fechapublicacion = "assertz(fechalibro("+ Info.getDate()+ ",\'" + Guid +"\'))," ;
        String CategoriaLibro = "assertz(categorialibro(\'"+Categoria.replace("'","\\'")+"\',\'" + Guid +"\'))," ;
        //librotitulo + autorlibro +   libroestrellas +  preciolibro + fechapublicacion +CategoriaLibro
        PrologStuff +=  librotitulo + autorlibro  +   libroestrellas + preciolibro  +fechapublicacion + CategoriaLibro; 
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
