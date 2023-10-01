package com.example.candidate_tehnology.controller;

import com.example.candidate_tehnology.dto.CandidateDTO;
import com.example.candidate_tehnology.model.Candidate;
import com.example.candidate_tehnology.service.CandidateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidates")
@Api(tags = "info candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }
    @ApiOperation("find data candidate by id")
    @GetMapping("/{id}")
    public CandidateDTO getById(@PathVariable Long id) {
        CandidateDTO candidateDTO = candidateService.getById(id);
        return candidateDTO;
    }
    @ApiOperation("find all data for candidates")
    @GetMapping
    public List<CandidateDTO> getAll() {
       List<CandidateDTO> candidateDTOS = candidateService.getAll();
       return candidateDTOS;
    }
    @ApiOperation("update data candidate by id")
    @PatchMapping("/update/{id}")
    public CandidateDTO update(@PathVariable Long id,@RequestBody CandidateDTO dto) {
        CandidateDTO candidate = candidateService.update(id, dto);
        return candidate;
    }
    @ApiOperation("save data about candidate")
    @PostMapping("/save")
    public Candidate save(@RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = candidateService.save(candidateDTO);
        return candidate;
    }
    @ApiOperation("delete data about candidate by id")
    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam Long id) {
        candidateService.deleteById(id);
    }
}

