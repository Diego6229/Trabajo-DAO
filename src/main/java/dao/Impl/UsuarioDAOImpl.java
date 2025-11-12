package dao.Impl;

import dao.ConnectionManager;
import dao.UsuarioDAO;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void addUsuario(Usuario u) {
        String sql = "INSERT INTO Usuario (nombre) VALUES (?)";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción añadiendo usuario: " + e);
        }
    }

    @Override
    public void updateUsuario(Usuario u) {
        String sql = "UPDATE Usuario SET nombre=? WHERE id=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción actualizando usuario: " + e);
        }
    }

    @Override
    public void deleteUsuario(int id) {
        String sql = "DELETE FROM Usuario WHERE id=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción eliminando usuario: " + e);
        }
    }

    @Override
    public Usuario getUsuarioById(int id) {
        String sql = "SELECT id, nombre FROM Usuario WHERE id=?";
        Usuario usuario = null;
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Excepción obteniendo usuario: " + e);
        }
        return usuario;
    }

    @Override
    public List<Usuario> listAllUsuario() {
        String sql = "SELECT id, nombre FROM Usuario ORDER BY id";
        List<Usuario> lista = new ArrayList<>();
        try (Connection c = ConnectionManager.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Excepción listando usuarios: " + e);
        }
        return lista;
    }
}
