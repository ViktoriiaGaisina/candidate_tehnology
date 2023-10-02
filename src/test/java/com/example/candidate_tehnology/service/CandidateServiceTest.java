package com.example.candidate_tehnology.service;

import com.example.candidate_tehnology.CandidateTehnologyApplication;
import com.example.candidate_tehnology.dto.CandidateDTO;
import com.example.candidate_tehnology.dto.TehnologyDTO;
import com.example.candidate_tehnology.mapper.CandidateMapper;
import com.example.candidate_tehnology.model.Candidate;
import com.example.candidate_tehnology.repository.CandidateRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest(classes = CandidateTehnologyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CandidateServiceTest {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    CandidateMapper candidateMapper;

    @AfterEach
    public void cleanUpEach() {
        candidateRepository.deleteAll();
    }

    @Test
    void getById() {
        CandidateDTO candidateDTO = createDTO();
        Candidate candidate = candidateService.save(candidateDTO);
        Assertions.assertNotNull(candidate);
        Assertions.assertDoesNotThrow(() -> candidateService.getById(candidate.getId()));

    }

    @Test
    void getAll() {
        CandidateDTO candidateDTO = createDTO();
        Candidate candidate = candidateService.save(candidateDTO);
        List<CandidateDTO> candidateDTOS = candidateService.getAll();
        Assertions.assertEquals(candidateDTOS.size(), 1);
    }

    @Test
    void update() {
        CandidateDTO candidateDTO = createDTO();
        Candidate candidate = candidateService.save(candidateDTO);
        candidate.setUsername("Gosha");
        CandidateDTO candidateUpdate = candidateService.update(candidate.getId(),
                candidateMapper.toDto(candidate));
        Assertions.assertEquals(candidateUpdate.getUsername(), "Gosha");
    }

    @Test
    void save() {
        CandidateDTO candidateDTO = createDTO();
        Candidate candidate = candidateService.save(candidateDTO);
        Assertions.assertNotNull(candidate);
    }

    @Test
    void deleteById() {
        CandidateDTO candidateDTO = createDTO();
        Candidate candidate = candidateService.save(candidateDTO);
        candidateService.deleteById(candidate.getId());
        Assertions.assertThrows(EntityNotFoundException.class,
                () -> candidateService.getById(candidate.getId()));
    }

    private CandidateDTO createDTO() {
        return CandidateDTO.builder()
                .username("Nikola")
                .tehnologyDTOS(List.of(TehnologyDTO.builder()
                        .level(2L)
                        .name("Tom")
                        .build()))
                .build();

    }
}