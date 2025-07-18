package com.ramazanayyildiz.FilmApp.repository;

import com.ramazanayyildiz.FilmApp.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
}
