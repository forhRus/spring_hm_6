package com.example.spring_hm_6.controllers;

import com.example.spring_hm_6.entyties.Note;
import com.example.spring_hm_6.services.NotesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NotesController {
  private final NotesService service;

  @GetMapping
  public List<Note> getAllNotes(){
    return service.getAllNotes();
  }
  @PostMapping
  public Note createNote(@RequestBody Note note){
    note.setDateCreate(LocalDateTime.now());
    note.setDateUpdate(LocalDateTime.now());
    return service.createNote(note);
  }

  @GetMapping("/{id}")
  public Note getNote(@PathVariable("id") Long id){
    return service.getNoteById(id);
  }
  @PutMapping("/{id}")
  public Note updateNote(@RequestBody Note note, @PathVariable("id") Long id){
    note.setId(id);
    note.setDateUpdate(LocalDateTime.now());
    return service.updateNote(note);
  }

  @DeleteMapping("/{id}")
  public void deleteNote(@PathVariable("id") Long id){
    service.deleteNote(id);
  }
}
