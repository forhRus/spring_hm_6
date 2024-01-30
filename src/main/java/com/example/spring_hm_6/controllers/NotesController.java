package com.example.spring_hm_6.controllers;

import com.example.spring_hm_6.entyties.Note;
import com.example.spring_hm_6.services.NotesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Рест контроллер *
 */
@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NotesController {
  private final NotesService service;

  /**
   * Получить список всех заметок
   * @return
   */
  @GetMapping
  public List<Note> getAllNotes(){
    return service.getAllNotes();
  }

  /**
   * Добавить заметку в БД
   * @param note
   * @return
   */
  @PostMapping
  public Note createNote(@RequestBody Note note){
    note.setDateCreate(LocalDateTime.now());
    note.setDateUpdate(LocalDateTime.now());
    return service.createNote(note);
  }

  /**
   * Получить заметку по id
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public Note getNote(@PathVariable("id") Long id){
    return service.getNoteById(id);
  }

  /**
   * Обновить данные заметки
   * @param note
   * @param id
   * @return
   */
  @PutMapping("/{id}")
  public Note updateNote(@RequestBody Note note, @PathVariable("id") Long id){
    note.setId(id);
    note.setDateUpdate(LocalDateTime.now());
    return service.updateNote(note);
  }

  /**
   * Удалить заметку по id
   * @param id
   */
  @DeleteMapping("/{id}")
  public void deleteNote(@PathVariable("id") Long id){
    service.deleteNote(id);
  }
}
