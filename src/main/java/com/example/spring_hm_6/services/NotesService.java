package com.example.spring_hm_6.services;

import com.example.spring_hm_6.entyties.Note;

import java.util.List;

public interface NotesService {
  List<Note> getAllNotes();
  Note getNoteById(Long id);
  Note updateNote(Note note);
  Note createNote(Note note);
  void deleteNote(Long id);
}
