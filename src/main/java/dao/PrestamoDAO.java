package dao;

import model.Prestamo;
import java.util.List;

public interface PrestamoDAO {
    void addPrestamo(Prestamo p);

    void updatePrestamo(Prestamo p);

    void deletePrestamo(int id);

    Prestamo getPrestamoById(int id);

    List<Prestamo> listAllPrestamo();

    List<Prestamo> getPrestamoByUsuario(int usuarioId);

    List<Prestamo> getPrestamoByLibro(int libroId);
}
