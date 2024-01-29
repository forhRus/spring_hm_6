package com.example.spring_hm_6.services;

import com.example.spring_hm_6.entyties.Note;
import com.example.spring_hm_6.repositories.NotesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NotesServiceImp implements NotesService{
  private final NotesRepo repo;

  @Override
  public List<Note> getAllNotes() {
    return repo.findAll();
  }

  @Override
  public Note getNoteById(Long id) {
    return repo.findById(id).orElse(null);
  }

  @Override
  public Note updateNote(Note note) {
    Note noteById = getNoteById(note.getId());
    noteById.setTitle(note.getTitle());
    noteById.setDiscription(note.getDiscription());
    noteById.setDateUpdate(note.getDateUpdate());
    return repo.save(noteById);
  }

  @Override
  public Note createNote(Note note) {
    return repo.save(note);
  }

  @Override
  public void deleteNote(Long id) {
    Note noteById = getNoteById(id);
    repo.delete(noteById);
  }
}
