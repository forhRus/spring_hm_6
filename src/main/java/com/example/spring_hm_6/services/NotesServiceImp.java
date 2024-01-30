package com.example.spring_hm_6.services;

import com.example.spring_hm_6.entyties.Note;
import com.example.spring_hm_6.repositories.NotesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Имплиментация сервиса заметок.
 */
@Service
@AllArgsConstructor
public class NotesServiceImp implements NotesService{
  private final NotesRepo repo;

  /**
   * Получить список заметок
   * @return
   */
  @Override
  public List<Note> getAllNotes() {
    return repo.findAll();
  }

  /**
   * Получить заметку по id или null
   * @param id
   * @return
   */
  @Override
  public Note getNoteById(Long id) {
    return repo.findById(id).orElse(null);
  }

  /**
   * Обновить данные заметку.
   * @param note
   * @return
   */
  @Override
  public Note updateNote(Note note) {
    Note noteById = getNoteById(note.getId());
    noteById.setTitle(note.getTitle());
    noteById.setDiscription(note.getDiscription());
    noteById.setDateUpdate(note.getDateUpdate());
    return repo.save(noteById);
  }

  /**
   * Добавить заметку в БД
   * @param note
   * @return
   */
  @Override
  public Note createNote(Note note) {
    return repo.save(note);
  }

  /**
   * Удалить заметку.
   * @param id
   */
  @Override
  public void deleteNote(Long id) {
    Note noteById = getNoteById(id);
    repo.delete(noteById);
  }
}
