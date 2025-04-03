package controller;
import module.Libro;

import java.util.ArrayList;
import java.util.List;
public class Biblioteca {
    private List<Libro> biblioteca;

    public Biblioteca(){
        this.biblioteca = new ArrayList<>();
    }



    public void agregarLibro (Libro libro){
        if (estaLibro(libro.getiSBN())!=null){
            System.out.println("Lo siento el libro esta en la biblioteca");
        }else {
            biblioteca.add(libro);
            System.out.println("Felicitaciones, a añadido un libro");
        }

    }

    private Libro estaLibro(String id){
        for (Libro l : biblioteca){
            if (l.getiSBN().equalsIgnoreCase(id)){
                return l;
            }
        }
        return null;
    }

    public Libro consultarLibro(String id){
        for (Libro l : biblioteca){
            if (l.getiSBN().equalsIgnoreCase(id)){
                System.out.println("Hemos encontrado su libro. Aqui tiene los datos:");
                l.mostrarDatos();
                return l;
            }
        }
        System.out.println("No hemos encontrado su libro.");
        return null;
    }


    //catalogo -> clase anidadd
    class ClaseInterna{
        private String nombreCatalogo;
        private int tamañoDelCatalago;
        // definición de todos los elementos de la clase interna
        public  ClaseInterna(){}

        public ClaseInterna(String nombreCatalogo, int tamañoDelCatalago) {
            this.nombreCatalogo = nombreCatalogo;
            this.tamañoDelCatalago = tamañoDelCatalago;
        }




    }
}
