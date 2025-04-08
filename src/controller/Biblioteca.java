package controller;
import module.Libro;
import module.Policial;
import java.util.ArrayList;
import java.util.List;


public class Biblioteca  {
    private ArrayList<Libro> biblioteca;
    private ArrayList<Catalogo> catalogos;


    public Biblioteca(){
        this.biblioteca = new ArrayList<>();
        this.catalogos = new ArrayList<>();
    }

    public Catalogo crearCatalogo(String nombre, int tamaño){/// puedo poner fallos.
        Catalogo catalogo= new Catalogo(nombre,tamaño);
        catalogos.add(catalogo);
        System.out.println("Catalogo "+nombre+" creado");
        return catalogo;
    }

    public void agregarLibro (Libro libro){
        if (estaLibro(libro.getiSBN(), this.biblioteca)!=null){
            System.out.println("Lo siento el libro esta en la biblioteca");//trtar exepciones.
        }else {
            biblioteca.add(libro);
            System.out.println("Felicitaciones, ha añadido un libro");
        }

    }

    public void elimnarLibro (String id){//trtar exepciones.
        Libro libroClr = estaLibro(id,biblioteca);
        if (estaLibro(libroClr.getiSBN(), this.biblioteca)!=null){
            biblioteca.remove(libroClr);
            System.out.println("Libro "+libroClr.getNombreDelLibro() +" libro eliminado de la biblioteca");

        }else {

            System.out.println("Libro no encotrado");//trtar exepcion.
        }

    }

    public Libro consultarLibro(String id){ //trtar exepciones.
        for (Libro l : biblioteca){
            if (l.getiSBN().equalsIgnoreCase(id)){
                int posicion = biblioteca.indexOf(l);
                System.out.println("Hemos encontrado su libro. Aqui tiene los datos guardado en la posicion: "+ posicion );


                l.mostrarDatos();
                return l;
            }
        }
        System.out.println("No hemos encontrado su libro."); //tratar expecion
        return null;
    }

    public void mostrarLibros(){
        if (biblioteca.isEmpty()){
            System.out.println("Biblioteca vacia");
        }
        for (Libro item : biblioteca){
            item.mostrarDatos();
            System.out.println("-----------------");
        }
    }

    public void añadirPersonajeALibro(String isbn, String nombre, String apellido) {
        Libro libro = estaLibro(isbn, biblioteca);

        if (libro != null) {
            if (libro instanceof Policial) {
                Policial policial = (Policial) libro;
                policial.anadirPersonaje(nombre, apellido);
            }
        }
    }

    public void eliminarPersonajeALibro(String isbn, String nombre, String apellido) {
        Libro libro = estaLibro(isbn, biblioteca);

        if (libro != null) {
            if (libro instanceof Policial) {
                Policial policial = (Policial) libro;
                String nombre1 = nombre;
                policial.eliminarPersonaje(nombre, apellido);
                policial.mostrarDatosPersona();
            }
        }


    }

    private Libro estaLibro(String id, ArrayList<Libro> lista){

        for (Libro l : lista){

            if (l.getiSBN().equalsIgnoreCase(id)){
                return l;
            }
        }
        return null;
    }

    //metodo exportar libro.


    //catalogo -> clase anidada
     public static class Catalogo{
        private String nombre;
        private int size;
        private ArrayList<Libro> libros;


        public Catalogo(){
            this.libros = new ArrayList<>();
        }

        public Catalogo(String nombre, int size) {
            this.nombre = nombre;
            this.size = size;
            this.libros = new ArrayList<>();

        }

        public void añadirLibroCatalogo(String id, Biblioteca biblioteca) { //falta excepcion.
            if (libros.size() >= size) {
                System.out.println("No hay espacio en el catálogo."); //falta excepcion.
                return;
            }
            Libro libro = biblioteca.estaLibro(id, biblioteca.biblioteca);
            if (libro == null) {
                System.out.println("Lo siento el libro no esta en la biblioteca");//falta excepcion.
                return;
            }if (estaLibro1(id)!= null){
                System.out.println("El libro esta en la biblioteca");
                return;
            }

            System.out.println("Ha añadido un libro al catalogo "+ nombre);
            libros.add(libro);
            System.out.println("Espacio restante del catalgo "+ nombre +": "+ (this.size-libros.size()));

        }

        public void eliminarLibroCatalogo(String id, Biblioteca biblioteca) {

            Libro libro = biblioteca.estaLibro(id, biblioteca.biblioteca);
            if (libro == null) {
                System.out.println("Lo siento el libro no esta en la biblioteca");///falta exepcion
                return;
            }if (estaLibro1(id)!= null){

                libros.remove(libro);
                System.out.println("Ha eliminado un libro del catalogo "+nombre);
                System.out.println("Espacio restante del catalgo "+ nombre +": "+ (this.size-libros.size()));
                return;
            }

                System.out.println("El libro esta en la biblioteca");


        } //falta excepcion.

        private Libro estaLibro1(String id){
            for (Libro l : this.libros){
                if (l.getiSBN().equalsIgnoreCase(id)){
                    return l;
                }

            }
            return null;
        }

        public void mostrarLibros(){
            for (Libro l : libros){
                l.mostrarDatos();
            }
        }


        public void mostrarCatalogo(){
            System.out.println("El nombre del catalogo es: "+ nombre);
            System.out.println("El tamaño del catalogo es: "+ size);
            System.out.println("Memoria restante "+ (size - libros.size()));

        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public ArrayList<Libro> getLibros() {
            return libros;
        }

        public void setLibros(ArrayList<Libro> libros) {
            this.libros = libros;
        }

    }
}
