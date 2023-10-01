package com.example.candidate_tehnology.service;

import com.example.candidate_tehnology.dto.CandidateDTO;
import com.example.candidate_tehnology.mapper.CandidateMapper;
import com.example.candidate_tehnology.model.Candidate;
import com.example.candidate_tehnology.repository.CandidateRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, CandidateMapper candidateMapper) {
        this.candidateRepository = candidateRepository;
        this.candidateMapper = candidateMapper;
    }

    public CandidateDTO getById(Long id) {
        return candidateRepository.findById(id)
                .map(candidateMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("candidate is not exist"));
    }


    public List<CandidateDTO> getAll() {
        return candidateRepository.findAll().stream()
                .map(candidateMapper::toDto)
                .collect(Collectors.toList());
    }

    public CandidateDTO update(Long id, CandidateDTO dto) {
        Candidate entity = candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("candidate is not exist"));
        entity.setUsername(dto.getUsername());
        Candidate candidate = candidateRepository.save(entity);
        return candidateMapper.toDto(candidate);
    }

    public Candidate save(CandidateDTO candidateDTO) {
        Candidate candidate =candidateMapper.toEntity(candidateDTO);
        return candidateRepository.save(candidate);
    }

    public void deleteById(Long id) {
        Candidate entity = candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("candidate is not exist"));
        candidateRepository.delete(entity);
    }
}
