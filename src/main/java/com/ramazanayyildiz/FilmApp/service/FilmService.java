package com.ramazanayyildiz.FilmApp.service;

import com.ramazanayyildiz.FilmApp.dto.FilmDTO;
import com.ramazanayyildiz.FilmApp.entity.Film;
import com.ramazanayyildiz.FilmApp.exception.ResourceNotFoundException;
import com.ramazanayyildiz.FilmApp.repository.FilmRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }


    public void createNewFilm(Film film) {
        filmRepository.save(film);
    }

    public Film findFilm(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " Numaralı Film Bulunamadı!"));
    }

    public void deleteFilm(Long id) {
        Film film = findFilm(id);
        filmRepository.delete(film);
    }

    public void updateFilm(Long id, @Valid FilmDTO filmDTO) {
        Film film = findFilm(id);

        film.setFilmName(filmDTO.getFilmName());
        film.setReleaseYear((filmDTO.getReleaseYear()));
        film.setImdbRating(filmDTO.getImdbRating());
        film.setProducer(filmDTO.getProducer());
        film.setGenre(filmDTO.getGenre());

        filmRepository.save(film);

    }
}
