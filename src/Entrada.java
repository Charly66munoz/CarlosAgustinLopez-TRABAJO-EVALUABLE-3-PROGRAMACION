import controller.Biblioteca;
import module.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.List;

public class Entrada {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Comedia("Friend", " - ",250,"123456", "20" );
        Libro libro2=new Terror("it", "Stephen King",150,"77777a", 10 );
        Libro libro3=new Terror("La monja", "Olga",150,"77772a", 10 );
        Libro libro4=new Policial("Maravillas del Señor", "Pepe Cornabillia", 200, "12457e", TipoPolicial.INTRIGA);
        Libro libro5= new Policial("SSS", "OSTRAS", 200, "655448", TipoPolicial.MISTERIO);

        Policial policial1 = (Policial) libro4;
        policial1.anadirPersonaje("Agustin", "Lopez");
        policial1.anadirPersonaje("Agustin", "Lopez");
        Policial policial2 = (Policial) libro5;
        policial2.anadirPersonaje("Uxue", "Arregui");
        libro4= policial1;
        libro5= policial2;

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);

        //puebas catalogo:


        Biblioteca.Catalogo catalogo1 = biblioteca.crearCatalogo("Lo mejor",5);
        System.out.println("-----------------");

        catalogo1.añadirLibroCatalogo("985776" , biblioteca);
        System.out.println("--------1---------");

        catalogo1.añadirLibroCatalogo("985776", biblioteca);
        System.out.println("---------2--------");

        catalogo1.añadirLibroCatalogo("123456", biblioteca);
        System.out.println("----------3-------");

        catalogo1.añadirLibroCatalogo("12457e", biblioteca);
        System.out.println("-----------4------");

        catalogo1.añadirLibroCatalogo("77777a", biblioteca);
        System.out.println("-----------5------");

        catalogo1.añadirLibroCatalogo("77772a", biblioteca);
        System.out.println("-----------6------");

        catalogo1.añadirLibroCatalogo("655448", biblioteca);

        System.out.println("-----------7------");
        catalogo1.eliminarLibroCatalogo("77777a", biblioteca);
        catalogo1.añadirLibroCatalogo("655448", biblioteca);
        System.out.println("-----------8------");
        catalogo1.mostrarLibros();






        /* prubas libros
        biblioteca.añadirPersonajeALibro("12457e", "Uxue" ,"Arregui");
        biblioteca.añadirPersonajeALibro("12457e", "Carlitos" ,"Arregui");

        biblioteca.mostrarLibros();

        System.out.println("-----------------");

        biblioteca.elimnarLibro("12457e");
        System.out.println("-----------------");

        biblioteca.mostrarLibros();



        System.out.println(" ");
        System.out.println(" ");*/











    }
}


