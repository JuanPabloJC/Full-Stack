package com.example.FullStackV1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.FullStackV1.model.Libro;

@Repository
public class LibroRepository {
    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros() {
        return listaLibros;
    }
    public Libro agregar(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }
    
    public void seed(){
        listaLibros.add(new Libro(1, "935-0123", "Cien años de wacoldo", "Editorial Planeta", 1990, "Gabriel García Márquez"));
        listaLibros.add(new Libro(2, "935-0124", "El amor en los tiempos del cólera", "Editorial Planeta", 1985, "Gabriel García Márquez"));
        listaLibros.add(new Libro(3, "935-0125", "Crónica de una muerte anunciada", "Editorial Planeta", 1981, "Gabriel García Márquez"));
    }

    public Libro libroPorId(int id) {
        for (Libro libro : listaLibros){
            if (id == libro.getId()){
                return libro;
            }   
        }
        return null;
    }

    public Libro libroPorIsbn(String isbn) {
        for (Libro libro : listaLibros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public Libro modificarLibro(int id, Libro libro) {
        Libro buscado = libroPorId(id);
        if (buscado != null) {
            buscado.setAutor(libro.getAutor());
            buscado.setEditorial(libro.getEditorial());
            buscado.setFechaPublicacion(libro.getFechaPublicacion());
            buscado.setIsbn(libro.getIsbn());
            buscado.setTitulo(libro.getTitulo());
            return buscado;
        }

        return null;    
    }

    public String borrar(int id) {
        if (listaLibros.removeIf(lbr -> lbr.getId() == id)){
            return "Libro eliminado";
        }
        return "Error al eliminar el libro";
    }

    public List<Libro> getByYear(int year) {
        List<Libro> lista = new ArrayList<>();
        for (Libro libro : listaLibros){
            if (libro.getFechaPublicacion() == year){
                lista.add(libro);
            }
        }
        return lista;
    }

}
