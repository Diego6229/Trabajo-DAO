package dao;

import model.Libro;
import java.util.List;

public interface LibroDAO {
    void addLibro(Libro l);

    void updateLibro(Libro l);

    void deleteLibro(int id);

    Libro getLibroById(int id);

    List<Libro> listAllLibro();

    List<Libro> getLibroByTitulo(String patron);
}
