package com.notetakingapi.domain;

import com.notetakingapi.domain.enums.NoteType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@ToString
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "create_date")
    private Instant createDate;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private NoteType noteType;

    @Lob
    private String notes;
}
