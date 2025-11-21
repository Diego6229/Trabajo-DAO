package dao.Impl;

import dao.ConnectionManager;
import dao.LibroDAO;
import model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public void addLibro(Libro l) {
        String sql = "INSERT INTO Libro (titulo, isbn) VALUES (?, ?)";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getIsbn());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepcion añadiendo: " + e);
        }
    }

    @Override
    public void updateLibro(Libro l) {
        String sql = "UPDATE Libro SET titulo=?, isbn=? WHERE id=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getIsbn());
            ps.setInt(3, l.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepcion acualizando: " + e);
        }
    }

    @Override
    public void deleteLibro(int id) {
        String sql = "DELETE FROM Libro WHERE id=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepcion eliminando: " + e);
        }
    }

    @Override
    public Libro getLibroById(int id) {
        String sql = "SELECT id, titulo, isbn FROM Libro WHERE id=?";
        Libro libro = null;

        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    libro = new Libro();
                    libro.setId(rs.getInt("id"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setIsbn(rs.getString("isbn"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Excepcion obteniendo: " + e);
        }

        return libro;
    }

    @Override
    public List<Libro> listAllLibro() {
        String sql = "SELECT id, titulo, isbn FROM Libro ORDER BY id";
        List<Libro> out = new ArrayList<>();

        try (Connection c = ConnectionManager.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Libro l = new Libro();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setIsbn(rs.getString("isbn"));
                out.add(l);
            }

        } catch (SQLException e) {
            System.out.println("Excepcion listando: " + e);
        }
        return out;
    }

    @Override
    public List<Libro> getLibroByTitulo(String patron) {
        String sql = "SELECT id, titulo, isbn FROM Libro WHERE titulo LIKE ? ORDER BY titulo";
        List<Libro> out = new ArrayList<>();

        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + patron + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Libro l = new Libro();
                    l.setId(rs.getInt("id"));
                    l.setTitulo(rs.getString("titulo"));
                    l.setIsbn(rs.getString("isbn"));
                    out.add(l);
                }
            }

        } catch (SQLException e) {
            System.out.println("Excepcion busncando por titulo: " + e);
        }
        return out;
    }
}
