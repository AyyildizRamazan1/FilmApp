package com.ramazanayyildiz.FilmApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "The film title cannot be blank!")
    @Column(nullable = false)
    private String filmName;

    @NotBlank(message = "The film year cannot be empty!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "The name of the film producer cannot be left blank!")
    @Column(nullable = false)
    private String producer;

    @NotBlank(message = "Movie genre cannot be left blank")
    @Column(nullable = false)
    private String genre;
}
