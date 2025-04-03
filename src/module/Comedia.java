package module;

public class Comedia extends Libro {

    private int calificacion;
    private Tipo tipo;

    public Comedia(){}
    public Comedia(String nombreDelLibro, String autor, int numeroPaginas, String iSBN,  Tipo tipo, int calificacion) {
        super(nombreDelLibro, autor, numeroPaginas, iSBN);
        this.tipo = tipo;
        this.calificacion = calificacion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("El genero es "+tipo);
        System.out.println("La calficacion "+calificacion);


    }

    public int getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(int calificacion){
        this.calificacion= calificacion;
    }
}
