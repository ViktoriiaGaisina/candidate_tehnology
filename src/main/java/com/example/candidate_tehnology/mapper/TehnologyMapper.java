package com.example.candidate_tehnology.mapper;

import com.example.candidate_tehnology.dto.CandidateDTO;
import com.example.candidate_tehnology.dto.TehnologyDTO;
import com.example.candidate_tehnology.model.Candidate;
import com.example.candidate_tehnology.model.Tehnology;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TehnologyMapper {
    TehnologyDTO toDto(Tehnology tehnology);

    Tehnology toEntity(TehnologyDTO dto);

    List<TehnologyDTO> toDto(List<Tehnology> tehnologyList);

    List<Tehnology> toEntity(List<TehnologyDTO> tehnologyDTO);
}
