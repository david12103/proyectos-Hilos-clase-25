
// Clase interna para organizar los libros en una estanter�a

import java.util.ArrayList;
import java.util.List;

public class Estanteria {
    private List<Libro> libros;

    public Estanteria() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("La estanter�a est� vac�a.");
        } else {
            System.out.println("Libros en la estanter�a:");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}