package com.example.candidate_tehnology.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tehnology")
public class Tehnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="level")
    private Long level;

    @ManyToOne
    @JoinColumn(name = "fk_candidate_id")
    private Candidate candidate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tehnology tehnology))
            return false;
        return Objects.equals(getId(), tehnology.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
