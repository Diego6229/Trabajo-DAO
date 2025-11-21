package dao.Impl;

import dao.ConnectionManager;
import dao.LibroAutorDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroAutorDAOImpl implements LibroAutorDAO {

    @Override
    public void addLibroAutor(int libroId, int autorId) {
        String sql = "INSERT INTO Libro_Autor (idLibro, idAutor) VALUES (?, ?)";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, libroId);
            ps.setInt(2, autorId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción añadiendo relación libro-autor: " + e);
        }
    }

    @Override
    public void deleteLibroAutor(int libroId, int autorId) {
        String sql = "DELETE FROM Libro_Autor WHERE idLibro=? AND idAutor=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, libroId);
            ps.setInt(2, autorId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción eliminando relación libro-autor: " + e);
        }
    }

    @Override
    public List<Integer> getAutoresByLibro(int libroId) {
        List<Integer> autores = new ArrayList<>();
        String sql = "SELECT idAutor FROM Libro_Autor WHERE idLibro=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, libroId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                autores.add(rs.getInt("idAutor"));
            }
        } catch (SQLException e) {
            System.out.println("Excepción obteniendo autores del libro: " + e);
        }
        return autores;
    }

    @Override
    public List<Integer> getLibrosByAutor(int autorId) {
        List<Integer> libros = new ArrayList<>();
        String sql = "SELECT idLibro FROM Libro_Autor WHERE idAutor=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, autorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                libros.add(rs.getInt("idLibro"));
            }
        } catch (SQLException e) {
            System.out.println("Excepción obteniendo libros del autor: " + e);
        }
        return libros;
    }
}
