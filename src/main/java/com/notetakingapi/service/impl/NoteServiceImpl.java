package com.notetakingapi.service.impl;

import com.notetakingapi.domain.Note;
import com.notetakingapi.exception.NotFoundException;
import com.notetakingapi.repository.NoteRepository;
import com.notetakingapi.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    @Transactional(readOnly = true)
    public Note getNoteById(Integer id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (!noteOptional.isPresent()) {
            throw new NotFoundException("Note not found.");
        }
        return noteOptional.get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Note> getNotesByUsername(String username) {
        List<Note> notes = noteRepository.findByUsername(username);
        if(notes.isEmpty()){
            throw new NotFoundException("Notes not found for user " + username);
        }
        return notes;
    }

    @Override
    public Integer createNote(Note note) {
        return noteRepository.save(note).getId();
    }

    @Override
    public Integer updateNote(Note note) {
        return noteRepository.save(note).getId();
    }

    @Override
    public void deleteNoteById(Integer id) {
        getNoteById(id);
        noteRepository.deleteById(id);
    }
}
