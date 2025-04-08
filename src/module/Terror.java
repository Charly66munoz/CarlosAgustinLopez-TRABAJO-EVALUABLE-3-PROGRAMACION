package module;

public class Terror extends Libro {

    private int calificacion;


    public Terror(){}
    public Terror(String nombreDelLibro, String autor, int numeroPaginas, String iSBN, int calificacion) {
        super(nombreDelLibro, autor, numeroPaginas, iSBN);
        this.calificacion = calificacion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("El genero es "+ Tipo.Terror);
        System.out.println("La calficacion es "+ calificacion);


    }

    public int getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(int calificacion){
        this.calificacion = calificacion;
    }

    public Tipo getTipo(){
        return Tipo.Terror; //IDENTIFICADOR PARA PODER HACER FILTRADO
    }
}
