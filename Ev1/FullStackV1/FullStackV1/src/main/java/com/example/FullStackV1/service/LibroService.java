package com.example.FullStackV1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FullStackV1.model.Libro;
import com.example.FullStackV1.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> readAll() {
        return libroRepository.obtenerLibros();
    }

    public Libro create(Libro libro) {
        return libroRepository.agregar(libro);
    }
    
    public void seed(){
        libroRepository.seed();
    }

    public Libro readById(int id) {
        return libroRepository.libroPorId(id);
    }

    public Libro readByIsbn(String isbn) {
        return libroRepository.libroPorIsbn(isbn);
    }

    public Libro update(int id, Libro libro) {
        return libroRepository.modificarLibro(id, libro);
    }

    public String delete(int id) {
        return libroRepository.borrar(id);
    }

    public List<Libro> readByYear(int year) {
        return libroRepository.getByYear(year);
    }


}
