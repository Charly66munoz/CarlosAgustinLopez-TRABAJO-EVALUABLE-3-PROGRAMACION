package controller;
import module.Libro;
import module.Policial;
import module.Tipo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
    private ArrayList<Libro> biblioteca;
    private ArrayList<Catalogo> catalogos;


    public Biblioteca() {
        this.biblioteca = new ArrayList<>();
        this.catalogos = new ArrayList<>();
    }

    public Catalogo crearCatalogoMixto(String nombre, int tamaño) {
        CatalogoMixto catalogoMixto = new CatalogoMixto(nombre, tamaño);
        catalogos.add(catalogoMixto);
        System.out.println("Catálogo mixto " + nombre + " creado.");
        return catalogoMixto;
    }

    // Crear un catálogo específico (por tipo de género)
    public Catalogo crearCatalogoEspecifico(String nombre, int tamaño, Tipo tipo) {
        CatalogoEspecifico catalogoEspecifico = new CatalogoEspecifico(nombre, tamaño, tipo);
        catalogos.add(catalogoEspecifico);
        System.out.println("Catálogo específico " + nombre + " creado para el tipo: " + tipo);
        return catalogoEspecifico;
    }

    public void agregarLibro(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }
        if (estaLibro(libro.getiSBN(), this.biblioteca) != null) {
            System.out.println("Lo siento el libro esta en la biblioteca");
        } else {
            biblioteca.add(libro);
            System.out.println("Ha añadido un libro a la biblioteca");
        }

    }

    public void elimnarLibro(String id) throws NoEncuentroLibro {
        Libro libroClr = estaLibro(id, biblioteca);
        if (estaLibro(libroClr.getiSBN(), this.biblioteca) != null) {
            biblioteca.remove(libroClr);
            System.out.println("Libro " + libroClr.getNombreDelLibro() + " eliminado de la biblioteca");

        } else {

            throw new NoEncuentroLibro("No existe el libro " + libroClr.getiSBN());
        }

    }

    public Libro consultarLibro(String id) {
        for (Libro l : biblioteca) {
            if (l.getiSBN().equalsIgnoreCase(id)) {
                int posicion = biblioteca.indexOf(l);
                System.out.println("Hemos encontrado su libro. Aqui tiene los datos guardado en la posicion: " + posicion);


                l.mostrarDatos();
                return l;
            }
        }
        System.out.println("No hemos encontrado su libro.");
        return null;
    }

    public void mostrarLibros() {
        if (biblioteca.isEmpty()) {
            System.out.println("Biblioteca vacia");
        }
        for (Libro item : biblioteca) {
            item.mostrarDatos();
            System.out.println("-----------------");
        }
    }

    private Libro estaLibro(String id, ArrayList<Libro> lista) {

        for (Libro l : lista) {

            if (l.getiSBN().equalsIgnoreCase(id)) {
                return l;
            }
        }
        return null;
    }

    //metodo exportar libro.
    public void exportarLibros() {
        if (catalogos.isEmpty()) {
            throw new CatalogoNoExistente("No existe un catálogo en esta biblioteca.");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("libros.obj"))) {
            // Recorrer todos los catálogos de la biblioteca
            for (Catalogo catalogo : catalogos) {
                // Escribir los libros de cada catálogo
                writer.println("Catálogo: " + catalogo.getNombre());
                for (Libro libro : catalogo.getLibros()) {
                    writer.println(libro.toString());
                }
                writer.println("");
            }
            System.out.println("Catálogo exportado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar el catálogo: " + e.getMessage());
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





    //catalogo -> clase anidada
    public static abstract class Catalogo {
        private String nombre;
        private int size;
        private ArrayList<Libro> libros;


        public Catalogo() {
            this.libros = new ArrayList<>();
        }

        public Catalogo(String nombre, int size) {
            this.nombre = nombre;
            this.size = size;
            this.libros = new ArrayList<>();

        }

        public abstract void anadirLibroCatalogo(Libro libro);

        public void eliminarLibroCatalogo(Libro libro) {

            String id = libro.getiSBN();
            if (libro == null) {
                throw new NoEncuentroLibro("No se encontró el libro con ISBN " + id + " en la biblioteca");
            }

            if (estaLibro1(id) != null) {

                libros.remove(libro);
                System.out.println("Ha eliminado un libro del catalogo " + nombre);
                System.out.println("Espacio restante del catalago " + nombre + ": " + (this.size - libros.size()));
                return;
            }else {
                throw new NoEncuentroLibro("No se encontró el libro con ISBN " + id + " en la biblioteca, no se ha podido eliminar.");
            }


        }

        private Libro estaLibro1(String id) {
            for (Libro l : this.libros) {
                if (l.getiSBN().equalsIgnoreCase(id)) {
                    return l;
                }

            }
            return null;
        }

        public void mostrarLibros() {
            for (Libro l : libros) {
                l.mostrarDatos();
            }
        }

        public void mostrarCatalogo() {
            System.out.println("El nombre del catalogo es: " + nombre);
            System.out.println("El tamaño del catalogo es: " + size);
            System.out.println("Memoria restante " + (size - libros.size()));

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

    public static class CatalogoMixto extends Catalogo {

        public CatalogoMixto(String nombre, int size) {
            super(nombre, size);
        }

        @Override
        public void anadirLibroCatalogo(Libro libro) {

            if (getLibros().size() >= getSize()) {
                throw new NoHayMasEspacio("No queda mas espacio, catalogo completo. El espacio disponible es: " + getSize());
            }


            if (estaLibroEnCatalogo(libro)) {
                throw new YaEstaLibro("El libro ya se encuentra en el catalogo");
            }

            System.out.println("Ha añadido un libro al catalogo " + getNombre());
            getLibros().add(libro);
            System.out.println("Espacio restante del catalgo " + getNombre() + ": " + (this.getSize() - getLibros().size()));

        }

        private boolean estaLibroEnCatalogo(Libro libro) {
            for (Libro l : this.getLibros()) {
                if (l.getiSBN().equalsIgnoreCase(libro.getiSBN())) {
                    return true;
                }
            }
            return false;
        }



    }


    public class CatalogoEspecifico extends Catalogo {

        private Tipo tipo;

        public CatalogoEspecifico(String nombre, int size, Tipo tipo) {
            super(nombre, size);
            this.tipo = tipo;
        }

        @Override
        public void anadirLibroCatalogo(Libro libro) {
            if (this.tipo != libro.getTipo()){
                System.out.println("No se puede ingresar este libro, tipo de libro de este catalogo: " + this.tipo +
                        " esta intentado ingresar un libro de tipo: "+ libro.getTipo());
                return;
            }

            if (getLibros().size() >= getSize()) {
                throw new NoHayMasEspacio("No queda mas espacio, catalogo completo. El espacio disponible es: " + getSize());

            }

            if (estaLibroEnCatalogo(libro)) {
                throw new YaEstaLibro("El libro ya se encuentra en el catalogo");
            }

            getLibros().add(libro);
            System.out.println("Ha añadido un libro al catalogo " + getNombre() +": "+libro.getNombreDelLibro());
            System.out.println("Espacio restante del catalgo " + getNombre() + ": " + (this.getSize() - getLibros().size()));

        }
        private boolean estaLibroEnCatalogo(Libro libro) {
            for (Libro l : this.getLibros()) {
                if (l.getiSBN().equalsIgnoreCase(libro.getiSBN())) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class NoEncuentroLibro extends RuntimeException {
        public NoEncuentroLibro(String message) {
            super(message);
        }
    }

    public static class NoHayMasEspacio extends IndexOutOfBoundsException {
        public NoHayMasEspacio(String message) {
            super(message);
        }
    }

    public static class YaEstaLibro extends IllegalArgumentException {
        public YaEstaLibro(String message) {
            super(message);
        }
    }

    public static class CatalogoNoExistente extends RuntimeException {
        public CatalogoNoExistente(String message) {
            super(message);
        }
    }
}

/*
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


    } */