package dao.Impl;

import dao.ConnectionManager;
import dao.PrestamoDAO;
import model.Prestamo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAOImpl implements PrestamoDAO {

    @Override
    public void addPrestamo(Prestamo p) {
        String sql = "INSERT INTO Prestamo (fechaInicio, fechaFin, usuario_id, libro_id) VALUES (?, ?, ?, ?)";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(p.getFechaInicio()));
            if (p.getFechaFin() != null)
                ps.setDate(2, Date.valueOf(p.getFechaFin()));
            else
                ps.setNull(2, Types.DATE);
            ps.setInt(3, p.getUsuarioId());
            ps.setInt(4, p.getLibroId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Excepción añadiendo préstamo: " + e);
        }
    }

    @Override
    public void updatePrestamo(Prestamo p) {
        String sql = "UPDATE Prestamo SET fechaInicio=?, fechaFin=?, usuario_id=?, libro_id=? WHERE id=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(p.getFechaInicio()));
            if (p.getFechaFin() != null)
                ps.setDate(2, Date.valueOf(p.getFechaFin()));
            else
                ps.setNull(2, Types.DATE);
            ps.setInt(3, p.getUsuarioId());
            ps.setInt(4, p.getLibroId());
            ps.setInt(5, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Excepción actualizando préstamo: " + e);
        }
    }

    @Override
    public void deletePrestamo(int id) {
        String sql = "DELETE FROM Prestamo WHERE id=?";
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Excepción eliminando préstamo: " + e);
        }
    }

    @Override
    public Prestamo getPrestamoById(int id) {
        String sql = "SELECT * FROM Prestamo WHERE id=?";
        Prestamo p = null;
        try (Connection c = ConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Prestamo();
                p.setId(rs.getInt("id"));
                p.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                Date fFin = rs.getDate("fechaFin");
                if (fFin != null) p.setFechaFin(fFin.toLocalDate());
                p.setUsuarioId(rs.getInt("usuario_id"));
                p.setLibroId(rs.getInt("libro_id"));
            }
        } catch (SQLException e) {
            System.out.println("Excepción obteniendo préstamo: " + e);
        }
        return p;
    }

    @Override
    public List<Prestamo> listAllPrestamo() {
        String sql = "SELECT * FROM Prestamo ORDER BY id";
        List<Prestamo> lista = new ArrayList<>();
        try (Connection c = ConnectionManager.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setId(rs.getInt("id"));
                p.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                Date fFin = rs.getDate("fechaFin");
                if (fFin != null) p.setFechaFin(fFin.toLocalDate());
                p.setUsuarioId(rs.getInt("usuario_id"));
                p.setLibroId(rs.getInt("libro_id"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Excepción listando préstamos: " + e);
        }
        return lista;
    }
}
