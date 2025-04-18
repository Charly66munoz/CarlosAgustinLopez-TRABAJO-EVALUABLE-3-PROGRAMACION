import controller.Biblioteca;
import module.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.List;

public class Entrada {

    public static void main(String[] args) {



        //Nombres de libros y personajes sacado de chat gpt, no leo mucho

        Policial libro1 = new Policial("El nombre de la rosa", "Umberto Eco", 600, "444444", TipoPolicial.INTRIGA);
        Policial libro2 = new Policial("Asesinato en el Orient Express", "Agatha Christie", 300, "555555", TipoPolicial.MISTERIO);
        Libro libro3 = new Terror("Drácula", "Bram Stoker", 450, "333333", 10);
        Libro libro4 = new Terror("Misery", "Stephen King", 420, "777777", 8);
        Libro libro5 = new Terror("El exorcista", "William Peter Blatty", 500, "888888", 9);
        Libro libro6 = new Terror("Frankenstein", "Mary Shelley", 350, "999999", 10);
        Libro libro7 = new Terror("El Resplandor", "Stephen King", 500, "222222", 9);
        Libro libro8 = new Comedia("La conjura de los necios", "John Kennedy Toole", 400, "666666", "Humor absurdo");
        Libro libro9 = new Comedia("Good Omens", "Terry Pratchett & Neil Gaiman", 350, "111111", "Sátira apocalíptica");
        Libro libro10 = new Comedia("Wilt", "Tom Sharpe", 300, "121212", "Humor negro británico");

        libro1.anadirPersonaje("Uxue", "Arregui");
        libro1.anadirPersonaje("Agustin", "Lopez");
        libro1.anadirPersonaje("Aitor", "Smith");
        libro2.anadirPersonaje("Bautista", "Muñoz");
        libro2.anadirPersonaje("Josefina", "Muñoz");
        libro2.anadirPersonaje("Catalina", "Muñoz");



        //Biblioteca creada
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro6);
        biblioteca.agregarLibro(libro7);
        biblioteca.agregarLibro(libro8);
        biblioteca.agregarLibro(libro9);
        biblioteca.agregarLibro(libro10);
        //creo un catalogo mixto
        Biblioteca.Catalogo catalogoMixto = biblioteca.crearCatalogoMixto("Mixto",4);
        //lo llevo al error

        try {
            catalogoMixto.anadirLibroCatalogo(libro1);
            catalogoMixto.anadirLibroCatalogo(libro3);
            catalogoMixto.anadirLibroCatalogo(libro5);
            catalogoMixto.anadirLibroCatalogo(libro6);
            catalogoMixto.anadirLibroCatalogo(libro7);
            catalogoMixto.anadirLibroCatalogo(libro8); //lo llevo al error
        }catch (Biblioteca.NoHayMasEspacio e){
            System.out.println("Error al añadir libro " + e.getMessage());
        }
        
        try{
            catalogoMixto.eliminarLibroCatalogo(libro9);
        }catch (Biblioteca.NoEncuentroLibro e){
            System.out.println(e.getMessage());
        }

        try {
            catalogoMixto.anadirLibroCatalogo(libro8);
        }catch (Biblioteca.NoHayMasEspacio e){
            System.out.println(e.getMessage());
        }



        System.out.println("-------");
        System.out.println("-------");
        System.out.println("-------");

        Biblioteca.Catalogo catalogoTerror = biblioteca.crearCatalogoEspecifico("Mejores de Terror",3, Tipo.Terror );
        //lo llevo al error

        try {
            catalogoTerror.anadirLibroCatalogo(libro3);
            catalogoTerror.anadirLibroCatalogo(libro4);
            catalogoTerror.anadirLibroCatalogo(libro1);//LIBRO DE OTRO TIPO PARA MOSTRAR BUEN FUNCIONAMIENTO DE CATALOGOS
            catalogoTerror.anadirLibroCatalogo(libro5);
            catalogoTerror.anadirLibroCatalogo(libro6);

            //lo llevo al error
        }catch (Biblioteca.NoHayMasEspacio e){
            System.out.println("Error al añadir libro" + e.getMessage());
        }

        try{
            catalogoTerror.eliminarLibroCatalogo(libro9);
        }catch (Biblioteca.NoEncuentroLibro e){
            System.out.println(e.getMessage());
        }

        try {
            catalogoTerror.anadirLibroCatalogo(libro8);
        }catch (Biblioteca.NoHayMasEspacio e){
            System.out.println(e.getMessage());
        }

        System.out.println("-------");
        catalogoMixto.mostrarLibros();

        System.out.println("-------");
        System.out.println("-------");
        catalogoTerror.mostrarLibros();


        biblioteca.exportarLibros();

    }
}

