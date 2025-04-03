package module;

 abstract public class Libro {

    private String autor, nombreDelLibro, iSBN;
    private int numeroPaginas;

    public Libro(){

    }

    public Libro(String nombreDelLibro, String autor, int numeroPaginas, String iSBN){
        this.nombreDelLibro = nombreDelLibro;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.iSBN = iSBN;
    }


     public void mostrarDatos(){
        System.out.printf("El nombre del libro es: %s %n",nombreDelLibro);
        System.out.printf("El autor es: %s %n",autor);
        System.out.printf("Tiene %d: %n",numeroPaginas);
        System.out.printf("Su ISBN ES: %s %n",iSBN);

    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }
}
