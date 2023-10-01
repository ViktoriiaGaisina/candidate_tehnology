package com.example.candidate_tehnology.service;

import com.example.candidate_tehnology.dto.CandidateDTO;
import com.example.candidate_tehnology.dto.TehnologyDTO;
import com.example.candidate_tehnology.mapper.TehnologyMapper;
import com.example.candidate_tehnology.model.Candidate;
import com.example.candidate_tehnology.model.Tehnology;
import com.example.candidate_tehnology.repository.TehnologyRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TehnologyService {
    private final TehnologyMapper tehnologyMapper;
    private final TehnologyRepository tehnologyRepository;

    @Autowired
    public TehnologyService(TehnologyMapper tehnologyMapper, TehnologyRepository tehnologyRepository) {
        this.tehnologyMapper = tehnologyMapper;
        this.tehnologyRepository = tehnologyRepository;
    }

    public TehnologyDTO getById(Long id) {
        return tehnologyRepository.findById(id)
                .map(tehnologyMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("tehnology is not exist"));
    }

    public List<TehnologyDTO> getAll() {
        return tehnologyRepository.findAll().stream()
                .map(tehnologyMapper::toDto)
                .collect(Collectors.toList());
    }

    public TehnologyDTO update(Long id, TehnologyDTO dto) {
        Tehnology entity = tehnologyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("tehnology is not exist"));
        Tehnology builder = Tehnology.builder()
                .id(entity.getId())
                .name(entity.getName())
                .level(entity.getLevel())
                .build();
        Tehnology tehnology = tehnologyRepository.save(builder);
        return tehnologyMapper.toDto(tehnology);
    }

    public Tehnology save(TehnologyDTO tehnologyDTO) {
        Tehnology tehnology = tehnologyMapper.toEntity(tehnologyDTO);
        return tehnologyRepository.save(tehnology);
    }

    public void deleteBy(Long id) {
        Tehnology tehnology = tehnologyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("tehnology is not exist"));
        tehnologyRepository.delete(tehnology);
    }
}
