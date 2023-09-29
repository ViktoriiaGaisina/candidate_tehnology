package com.example.candidate_tehnology.repository;

import com.example.candidate_tehnology.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
