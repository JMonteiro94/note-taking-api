package com.notetakingapi.service;

import com.notetakingapi.domain.Note;
import java.util.List;

public interface NoteService {

    Note getNoteById(Integer id);

    List<Note> getNotesByUsername(String username);

    Integer createNote(Note note);

    Integer updateNote(Note note);

    void deleteNoteById(Integer id);
}
