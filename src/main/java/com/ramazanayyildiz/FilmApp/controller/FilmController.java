package com.ramazanayyildiz.FilmApp.controller;

import com.ramazanayyildiz.FilmApp.dto.FilmDTO;
import com.ramazanayyildiz.FilmApp.entity.Film;
import com.ramazanayyildiz.FilmApp.service.FilmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping // http://localhost:8080/films +Get
    public ResponseEntity<List<Film>> listAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return ResponseEntity.ok(films);
    }

    @PostMapping("/save") // http://localhost:8080/films/1 +Post +Json
    public ResponseEntity<Map<String, String>> createFilm(@Valid @RequestBody Film film) {
        filmService.createNewFilm(film);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Film başarıyla eklendi;");
        map.put("status", "true");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // http://localhost:8080/films/1 +Get
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(filmService.findFilm(id));
    }

    @DeleteMapping("/{id}") // http://localhost:8080/films/1 +Delete
    public ResponseEntity<String> deleteFilmById(@PathVariable("id") Long id) {
        filmService.deleteFilm(id);
        String message = "Film basarıyla silindi!";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping("/{id}") // http://localhost:8080/films/1 +Put +Json
    public ResponseEntity<String> updateFilm(@PathVariable("id") Long id, @Valid @RequestBody FilmDTO filmDTO){

        filmService.updateFilm(id, filmDTO);

        String message = "Film basarıyla güncellendi.";

        return new ResponseEntity<>(message, HttpStatus.OK);

    }
}
