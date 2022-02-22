package com.notetakingapi.bootstrap;

import com.notetakingapi.domain.Note;
import com.notetakingapi.domain.enums.NoteType;
import com.notetakingapi.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class NoteBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final NoteRepository noteRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        noteRepository.saveAll(getNotes());
    }

    private List<Note> getNotes(){
        List<Note> notes = new ArrayList<>(2);
        Note note1 = Note
                .builder()
                .id(1)
                .noteType(NoteType.FOOD)
                .notes("Spicy Grilled Chicken Taco")
                .username("joao")
                .createDate(new Date().toInstant())
                .build();
        notes.add(note1);
        Note note2 = Note
                .builder()
                .id(2)
                .noteType(NoteType.ANIMAL)
                .notes("Dogs are cool")
                .username("joao")
                .createDate(new Date().toInstant())
                .build();
        notes.add(note2);
        return notes;
    }
}
