package module;

import controller.Biblioteca;

import java.util.ArrayList;

public class Policial extends Libro {

    private TipoPolicial trama;
    private ArrayList<Personaje> personajes;



    public Policial(){
        this.trama = trama;
        this.personajes = new ArrayList<>();
    }
    public Policial(String nombreDelLibro, String autor, int numeroPaginas, String iSBN, TipoPolicial trama) {
        super(nombreDelLibro, autor, numeroPaginas, iSBN);
        this.trama = trama;
        this.personajes = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("El genero es "+ Tipo.Policial);
        System.out.println("La trama es "+ trama);
        mostrarDatosPersona();



    }

    public void mostrarDatosPersona(){

        System.out.println("Los personajes son: " );
        for (Personaje item: personajes){
            System.out.printf(item.getNombre() + ", "+item.getApellido()+ ". " );
        }
        System.out.println(" ");
    }


    public void anadirPersonaje(String nombre, String apellido){
        Personaje personaje = new Personaje(nombre,apellido);
        if(listaDePersonas(nombre, apellido)!=null){
            System.out.println("Personaje ya creado dentro de este libro");
            return;
        }
        personajes.add(personaje);
        System.out.println("Felicidades, ha añadido " +nombre+ " "+apellido+" al libro " + this.getNombreDelLibro());

    }

    public void eliminarPersonaje(String nombre, String apellido){
        Personaje personaje = new Personaje(nombre,apellido);
        if(listaDePersonas(nombre, apellido)!=null){

            System.out.println(nombre+" "+ apellido+ " fue eliminado");
            personajes.remove(listaDePersonas(nombre,apellido));

        }
        System.out.println("Personaje no encontrado ");

    }

    private Personaje listaDePersonas(String nombre, String apellido ){
        ArrayList<Personaje> persona = this.personajes;
        for (Personaje l  : persona){
            if (l.getNombre().equalsIgnoreCase(nombre) && l.getApellido().equalsIgnoreCase(apellido)){
                return l;
            }

        }
        return null;
    }





    public Tipo getTipo(){
        return Tipo.Policial; //IDENTIFICADOR PARA PODER HACER FILTRADO
    }

    public class Personaje{

        String nombre, apellido;

        public Personaje(){

        }

        public Personaje(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }



        public void mostrarDatos() {

            System.out.println("El nombre es "+ nombre +","+ apellido );

        }




        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
    }
}
