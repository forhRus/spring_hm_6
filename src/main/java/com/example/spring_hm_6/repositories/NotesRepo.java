package com.example.spring_hm_6.repositories;

import com.example.spring_hm_6.entyties.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Пустой интерфейс репозитория, предоставляет только crud
 */
public interface NotesRepo extends JpaRepository<Note, Long> {
}
