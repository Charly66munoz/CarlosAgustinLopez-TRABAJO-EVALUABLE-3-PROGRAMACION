import controller.Biblioteca;
import module.Comedia;
import module.Libro;
import module.Tipo;

import java.util.function.Predicate;
import java.util.List;

public class Entrada {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Comedia("Alicia en el pais de las Maravillas", "TimBurton",250,"123456", Tipo.Comedia,20 ));
        biblioteca.consultarLibro("123456");




    }
}


