package com.example.candidate_tehnology.mapper;

import com.example.candidate_tehnology.dto.CandidateDTO;
import com.example.candidate_tehnology.model.Candidate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    CandidateDTO toDto(Candidate candidate);

    Candidate toEntity(CandidateDTO dto);

    List<CandidateDTO> toDto(List<Candidate> candidates);

    List<Candidate> toEntity(List<CandidateDTO> candidates);
}
