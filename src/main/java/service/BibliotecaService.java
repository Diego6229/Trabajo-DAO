package service;

import dao.*;
import dao.Impl.*;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {

    private AutorDAO autorDAO;
    private LibroDAO libroDAO;
    private UsuarioDAO usuarioDAO;
    private PrestamoDAO prestamoDAO;
    private LibroAutorDAO libroAutorDAO;

    public BibliotecaService() {
        this.autorDAO = new AutorDAOImpl();
        this.libroDAO = new LibroDAOImpl();
        this.usuarioDAO = new UsuarioDAOImpl();
        this.prestamoDAO = new PrestamoDAOImpl();
        this.libroAutorDAO = new LibroAutorDAOImpl();
    }

    // ------ Metodos autor -------
    public void agregarAutor(String nombre) {
        autorDAO.addAutor(new Autor(nombre));
    }

    public Autor obtenerAutorPorId(int id) {
        return autorDAO.getAutorById(id);
    }

    public List<Autor> listarAutores() {
        return autorDAO.listAllAutor();
    }

    public void actualizarAutor(int id, String nombre) {
        autorDAO.updateAutor(new Autor(id, nombre));
    }

    public void eliminarAutor(int id) {
        autorDAO.deleteAutor(id);
    }

    // ------ Metodos libro -------
    public void agregarLibro(String titulo, String isbn) {
        libroDAO.addLibro(new Libro(titulo, isbn));
    }

    public Libro obtenerLibroPorId(int id) {
        return libroDAO.getLibroById(id);
    }

    public List<Libro> listarLibros() {
        return libroDAO.listAllLibro();
    }

    public void actualizarLibro(int id, String titulo, String isbn) {
        libroDAO.updateLibro(new Libro(id, titulo, isbn));
    }

    public void eliminarLibro(int id) {
        libroDAO.deleteLibro(id);
    }

    // ------ Metodos usuario -------
    public void agregarUsuario(String nombre) {
        usuarioDAO.addUsuario(new Usuario(nombre));
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioDAO.getUsuarioById(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listAllUsuario();
    }

    public void actualizarUsuario(int id, String nombre) {
        usuarioDAO.updateUsuario(new Usuario(id, nombre));
    }

    public void eliminarUsuario(int id) {
        usuarioDAO.deleteUsuario(id);
    }

    // ------ Metodos prestamo -------
    public void agregarPrestamo(LocalDate fechaInicio, LocalDate fechaFin, int usuarioId, int libroId) {
        prestamoDAO.addPrestamo(new Prestamo(fechaInicio, fechaFin, usuarioId, libroId));
    }

    public Prestamo obtenerPrestamoPorId(int id) {
        return prestamoDAO.getPrestamoById(id);
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoDAO.listAllPrestamo();
    }

    public void actualizarPrestamo(int id, LocalDate fechaInicio, LocalDate fechaFin, int usuarioId, int libroId) {
        prestamoDAO.updatePrestamo(new Prestamo(id, fechaInicio, fechaFin, usuarioId, libroId));
    }

    public void eliminarPrestamo(int id) {
        prestamoDAO.deletePrestamo(id);
    }

    // ------ Metodos libro-autor -------
    public void agregarRelacionLibroAutor(int idLibro, int idAutor) {
        libroAutorDAO.addLibroAutor(idLibro, idAutor);
    }

    public List<LibroAutor> listarRelaciones() {
        List<LibroAutor> relaciones = new ArrayList<>();
        return relaciones;
    }

    public void eliminarRelacionLibroAutor(int idLibro, int idAutor) {
        libroAutorDAO.deleteLibroAutor(idLibro, idAutor);
    }
}
