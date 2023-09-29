package com.example.candidate_tehnology.dto;

import com.example.candidate_tehnology.model.Tehnology;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CandidateDTO {
    private Long id;
    private  String username;
    private List<TehnologyDTO> tehnologyDTOS = new ArrayList<>();

}
