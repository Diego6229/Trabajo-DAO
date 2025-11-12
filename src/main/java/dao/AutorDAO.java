package dao;

import model.Autor;
import java.util.List;

public interface AutorDAO {
    void addAutor(Autor a);

    void updateAutor(Autor a);

    void deleteAutor(int id);

    Autor getAutorById(int id);

    List<Autor> listAllAutor();

    List<Autor> getAutorByNombre(String patron);
}
