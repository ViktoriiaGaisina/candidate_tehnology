package com.example.candidate_tehnology.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TehnologyDTO {
    private Long id;
    private String name;
    private Long level;
}
