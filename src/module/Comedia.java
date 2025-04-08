package module;

public class Comedia extends Libro {

    private String tipoDeHumor;


    public Comedia(){}
    public Comedia(String nombreDelLibro, String autor, int numeroPaginas, String iSBN, String tipoDeHumor) {
        super(nombreDelLibro, autor, numeroPaginas, iSBN);
        this.tipoDeHumor = tipoDeHumor;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("El genero es "+Tipo.Comedia);
        System.out.println("Tipo de humor "+tipoDeHumor);


    }

    public String getTipoDeHumor() {
        return tipoDeHumor;
    }
    public void setTipoDeHumor(String tipoDeHumor){
        this.tipoDeHumor= tipoDeHumor;
    }

    public Tipo getTipo(){
        return Tipo.Comedia; //IDENTIFICADOR PARA PODER HACER FILTRADO
    }
}
