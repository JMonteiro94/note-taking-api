package com.notetakingapi.controller;

import com.notetakingapi.domain.Note;
import com.notetakingapi.service.NoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping(value = "/note/{id:[0-9]*}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Integer id) {
        log.debug("Get note by id {}", id);
        Note note = noteService.getNoteById(id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping(value = "/note", params = {"username"})
    public ResponseEntity<List<Note>> getNotesByUsername(@RequestParam(value = "username") String user) {
        log.debug("Get note by username {}", user);
        List<Note> note = noteService.getNotesByUsername(user);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping(value = "/note")
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        log.debug("Create new note: {}", note);
        Integer id = noteService.createNote(note);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/note")
    public ResponseEntity<?> updateNote(@RequestBody Note note) {
        log.debug("Update note {}", note);
        Integer id = noteService.updateNote(note);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/note")
    public ResponseEntity<?> deleteNote(@RequestBody Integer id) {
        log.debug("Delete note by id {}", id);
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
