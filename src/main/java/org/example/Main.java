package org.example;

import service.BibliotecaService;
import dao.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AutorDAO autorDAO = null;
        LibroDAO libroDAO = null;
        UsuarioDAO usuarioDAO = null;
        PrestamoDAO prestamoDAO = null;
        LibroAutorDAO libroAutorDAO = null;

        BibliotecaService service = new BibliotecaService();

        // ------- Menú principal -------
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Gestionar autores");
            System.out.println("2. Gestionar libros");
            System.out.println("3. Gestionar usuarios");
            System.out.println("4. Gestionar préstamos");
            System.out.println("5. Gestionar relación Libro-Autor");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> menuAutores(service, sc);
                case 2 -> menuLibros(service, sc);
                case 3 -> menuUsuarios(service, sc);
                case 4 -> menuPrestamos(service, sc);
                case 5 -> menuLibroAutor(service, sc);
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    // ------- Menu secundario --------

    private static void menuAutores(BibliotecaService service, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE AUTORES ---");
            System.out.println("1. Listar autores");
            System.out.println("2. Agregar autor");
            System.out.println("3. Buscar autor por ID");
            System.out.println("4. Actualizar autor");
            System.out.println("5. Eliminar autor");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> listar(service.listarAutores());
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    service.agregarAutor(nombre);
                }
                case 3 -> {
                    System.out.print("ID del autor: ");
                    int id = leerEntero(sc);
                    System.out.println(service.obtenerAutorPorId(id));
                }
                case 4 -> {
                    System.out.print("ID del autor: ");
                    int id = leerEntero(sc);
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    service.actualizarAutor(id, nuevoNombre);
                }
                case 5 -> {
                    System.out.print("ID del autor: ");
                    int id = leerEntero(sc);
                    service.eliminarAutor(id);
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuLibros(BibliotecaService service, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Listar libros");
            System.out.println("2. Agregar libro");
            System.out.println("3. Buscar libro por ID");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> listar(service.listarLibros());
                case 2 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    service.agregarLibro(titulo, isbn);
                }
                case 3 -> {
                    System.out.print("ID del libro: ");
                    int id = leerEntero(sc);
                    System.out.println(service.obtenerLibroPorId(id));
                }
                case 4 -> {
                    System.out.print("ID del libro: ");
                    int id = leerEntero(sc);
                    System.out.print("Nuevo título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Nuevo ISBN: ");
                    String isbn = sc.nextLine();
                    service.actualizarLibro(id, titulo, isbn);
                }
                case 5 -> {
                    System.out.print("ID del libro: ");
                    int id = leerEntero(sc);
                    service.eliminarLibro(id);
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuUsuarios(BibliotecaService service, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE USUARIOS ---");
            System.out.println("1. Listar usuarios");
            System.out.println("2. Agregar usuario");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> listar(service.listarUsuarios());
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    service.agregarUsuario(nombre);
                }
                case 3 -> {
                    System.out.print("ID del usuario: ");
                    int id = leerEntero(sc);
                    System.out.println(service.obtenerUsuarioPorId(id));
                }
                case 4 -> {
                    System.out.print("ID del usuario: ");
                    int id = leerEntero(sc);
                    System.out.print("Nuevo nombre: ");
                    String nombre = sc.nextLine();
                    service.actualizarUsuario(id, nombre);
                }
                case 5 -> {
                    System.out.print("ID del usuario: ");
                    int id = leerEntero(sc);
                    service.eliminarUsuario(id);
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuPrestamos(BibliotecaService service, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1. Listar préstamos");
            System.out.println("2. Agregar préstamo");
            System.out.println("3. Buscar préstamo por ID");
            System.out.println("4. Actualizar préstamo");
            System.out.println("5. Eliminar préstamo");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> listar(service.listarPrestamos());
                case 2 -> {
                    System.out.print("Fecha inicio (YYYY-MM-DD): ");
                    LocalDate inicio = LocalDate.parse(sc.nextLine());
                    System.out.print("Fecha fin (YYYY-MM-DD): ");
                    LocalDate fin = LocalDate.parse(sc.nextLine());
                    System.out.print("ID usuario: ");
                    int usuarioId = leerEntero(sc);
                    System.out.print("ID libro: ");
                    int libroId = leerEntero(sc);
                    service.agregarPrestamo(inicio, fin, usuarioId, libroId);
                }
                case 3 -> {
                    System.out.print("ID del préstamo: ");
                    int id = leerEntero(sc);
                    System.out.println(service.obtenerPrestamoPorId(id));
                }
                case 4 -> {
                    System.out.print("ID del préstamo: ");
                    int id = leerEntero(sc);
                    System.out.print("Nueva fecha inicio (YYYY-MM-DD): ");
                    LocalDate inicio = LocalDate.parse(sc.nextLine());
                    System.out.print("Nueva fecha fin (YYYY-MM-DD): ");
                    LocalDate fin = LocalDate.parse(sc.nextLine());
                    System.out.print("Nuevo ID usuario: ");
                    int usuarioId = leerEntero(sc);
                    System.out.print("Nuevo ID libro: ");
                    int libroId = leerEntero(sc);
                    service.actualizarPrestamo(id, inicio, fin, usuarioId, libroId);
                }
                case 5 -> {
                    System.out.print("ID del préstamo: ");
                    int id = leerEntero(sc);
                    service.eliminarPrestamo(id);
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void menuLibroAutor(BibliotecaService service, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- RELACIÓN LIBRO - AUTOR ---");
            System.out.println("1. Listar relaciones");
            System.out.println("2. Agregar relación");
            System.out.println("3. Eliminar relación");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> listar(service.listarRelaciones());
                case 2 -> {
                    System.out.print("ID libro: ");
                    int libroId = leerEntero(sc);
                    System.out.print("ID autor: ");
                    int autorId = leerEntero(sc);
                    service.agregarRelacionLibroAutor(libroId, autorId);
                }
                case 3 -> {
                    System.out.print("ID libro: ");
                    int libroId = leerEntero(sc);
                    System.out.print("ID autor: ");
                    int autorId = leerEntero(sc);
                    service.eliminarRelacionLibroAutor(libroId, autorId);
                }
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ------- Metodos --------
    private static void listar(List<?> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay registros.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }
}
