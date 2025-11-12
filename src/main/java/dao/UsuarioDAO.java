package dao;

import model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    void addUsuario(Usuario u);

    void updateUsuario(Usuario u);

    void deleteUsuario(int id);

    Usuario getUsuarioById(int id);

    List<Usuario> listAllUsuario();
}
