public class Biblioteca {

    // M�todo para crear un libro y agregarlo a una estanter�a
    public void agregarLibroAEstanteria(String titulo, String autor) {
        Estanteria estanteria = new Estanteria();
        Libro libro = new Libro(titulo, autor);
        estanteria.agregarLibro(libro);
        estanteria.mostrarLibros();
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibroAEstanteria("Cien A�os de Soledad", "Gabriel Garc�a M�rquez");
        biblioteca.agregarLibroAEstanteria("Don Quijote de la Mancha", "Miguel de Cervantes");
    }
}

