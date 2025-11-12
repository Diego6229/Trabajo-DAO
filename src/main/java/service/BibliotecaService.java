package service;

import dao.*;
import model.Autor;
import model.Libro;
import model.LibroAutor;

import java.util.List;

public class BibliotecaService {
    private AutorDAO autorDAO;
    private LibroDAO libroDAO;
    private UsuarioDAO usuarioDAO;
    private PrestamoDAO prestamoDAO;
    private LibroAutorDAO libroAutorDAO;

    public BibliotecaService(
            AutorDAO autorDAO;
            LibroDAO libroDAO;
            UsuarioDAO usuarioDAO;
            PrestamoDAO prestamoDAO;
            LibroAutorDAO libroAutorDAO;
    ) {
        this.autorDAO = autorDAO;
        this.libroDAO = libroDAO;
        this.usuarioDAO = usuarioDAO;
        this.prestamoDAO = prestamoDAO;
        this.libroAutorDAO = libroAutorDAO;
    }

    //METODOS DEL AUTOR

    public void agregarAutor(String nombre){
        autorDAO.addAutor(new Autor(nombre));
    }

    public Autor getAutorById(int id){
        return autorDAO.getAutorById(id);

    }

    public List<Autor> listAllAutor(){
        return autorDAO.listAllAutor();
    }

    public void updateAutor(int id,String nombre){
        autorDAO-updateAutor(new Autor(id, nombre));
    }

    public void deleteAutor(int id){
        autorDAO.deleteAutor(id);
    }


    //METODOS DEL LIBRO

    public void addLibro(String titulo, String isbn) {
        libroDAO.addLibro(new Libro(titulo, isbn));
    }

    public Libro obtenerLibroPorId(int id) {
        return libroDAO.obtenerLibroPorId(id);
    }

    public List<Libro> listarLibros() {
        return libroDAO.obtenerTodosLosLibros();
    }

    public void actualizarLibro(int id, String titulo, String isbn) {
        libroDAO.actualizarLibro(new Libro(id, titulo, isbn));
    }

    public void eliminarLibro(int id) {
        libroDAO.eliminarLibro(id);
    }

    //METODO USUARIO

    public void agregarUsuario(String nombre) {
        usuarioDAO.agregarUsuario(new Usuario(nombre));
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioDAO.obtenerUsuarioPorId(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.obtenerTodosLosUsuarios();
    }

    public void actualizarUsuario(int id, String nombre) {
        usuarioDAO.actualizarUsuario(new Usuario(id, nombre));
    }

    public void eliminarUsuario(int id) {
        usuarioDAO.eliminarUsuario(id);
    }

    //METODOS PRESTAMO

    public void agregarPrestamo(LocalDate fechaInicio, LocalDate fechaFin, int usuarioId, int libroId) {
        prestamoDAO.agregarPrestamo(new Prestamo(fechaInicio, fechaFin, usuarioId, libroId));
    }

    public Prestamo obtenerPrestamoPorId(int id) {
        return prestamoDAO.obtenerPrestamoPorId(id);
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoDAO.obtenerTodosLosPrestamos();
    }

    public void actualizarPrestamo(int id, LocalDate fechaInicio, LocalDate fechaFin, int usuarioId, int libroId) {
        prestamoDAO.actualizarPrestamo(new Prestamo(id, fechaInicio, fechaFin, usuarioId, libroId));
    }

    public void eliminarPrestamo(int id) {
        prestamoDAO.eliminarPrestamo(id);
    }

    //METODOS LIBRO_AUTOR

    public void agregarRelacionLibroAutor(int idLibro, int idAutor) {
        libroAutorDAO.agregarRelacion(new LibroAutor(idLibro, idAutor));
    }

    public List<LibroAutor> listarRelaciones() {
        return libroAutorDAO.obtenerTodasLasRelaciones();
    }

    public void eliminarRelacionLibroAutor(int idLibro, int idAutor) {
        libroAutorDAO.eliminarRelacion(idLibro, idAutor);
    }
}


}
