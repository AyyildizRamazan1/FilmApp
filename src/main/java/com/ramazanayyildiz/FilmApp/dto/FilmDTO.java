package com.ramazanayyildiz.FilmApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ramazanayyildiz.FilmApp.entity.Film;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {


    private Long id;

    @NotBlank(message = "The film title cannot be blank!")
    private String filmName;

    @NotBlank(message = "The film year cannot be empty!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "The name of the film producer cannot be left blank!")
    private String producer;

    @NotBlank(message = "Movie genre cannot be left blank")
    private String genre;

    public FilmDTO(Film film) {
        this.id = film.getId();
        this.filmName = film.getFilmName();
        this.releaseYear = film.getReleaseYear();
        this.imdbRating = film.getImdbRating();
        this.producer = film.getProducer();
        this.genre = film.getGenre();
    }
}
