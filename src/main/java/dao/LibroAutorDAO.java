package dao;

import java.util.List;

public interface LibroAutorDAO {
    void addLibroAutor(int libroId, int autorId);

    void deleteLibroAutor(int libroId, int autorId);

    List<Integer> getAutoresByLibro(int libroId);

    List<Integer> getLibrosByAutor(int autorId);
}
