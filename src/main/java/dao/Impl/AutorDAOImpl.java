package dao.Impl;

import dao.ConnectionManager;
import dao.AutorDAO;
import model.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAOImpl implements AutorDAO {

    @Override
    public void addAutor(Autor a) {
        String sql = "INSERT INTO Autor (nombre) VALUES (?)";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción añadiendo autor: " + e);
        }
    }

    @Override
    public void updateAutor(Autor a) {
        String sql = "UPDATE Autor SET nombre=? WHERE id=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción actualizando autor: " + e);
        }
    }

    @Override
    public void deleteAutor(int id) {
        String sql = "DELETE FROM Autor WHERE id=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción eliminando autor: " + e);
        }
    }

    @Override
    public Autor getAutorById(int id) {
        String sql = "SELECT id, nombre FROM Autor WHERE id=?";
        Autor autor = null;
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Excepción obteniendo autor: " + e);
        }
        return autor;
    }

    @Override
    public List<Autor> listAllAutor() {
        String sql = "SELECT id, nombre FROM Autor ORDER BY id";
        List<Autor> lista = new ArrayList<>();
        try (Connection c = ConnectionManager.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Autor a = new Autor();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Excepción listando autores: " + e);
        }
        return lista;
    }

    @Override
    public List<Autor> getAutorByNombre(String patron) {
        String sql = "SELECT id, nombre FROM Autor WHERE nombre LIKE ? ORDER BY nombre";
        List<Autor> lista = new ArrayList<>();
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + patron + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Autor a = new Autor();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Excepción buscando autor por nombre: " + e);
        }
        return lista;
    }
}
