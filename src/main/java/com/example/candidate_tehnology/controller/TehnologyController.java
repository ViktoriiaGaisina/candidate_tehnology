package com.example.candidate_tehnology.controller;

import com.example.candidate_tehnology.dto.TehnologyDTO;
import com.example.candidate_tehnology.model.Tehnology;
import com.example.candidate_tehnology.service.TehnologyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tehnology")
@Api
public class TehnologyController {
    private final TehnologyService tehnologyService;

    public TehnologyController(TehnologyService tehnologyService) {
        this.tehnologyService = tehnologyService;
    }
    @ApiOperation("")
    @GetMapping("{id}")
    public ResponseEntity<TehnologyDTO> getById(@PathVariable Long id) {
        TehnologyDTO tehnologyDTO = tehnologyService.getById(id);
        return ResponseEntity.ok(tehnologyDTO);
    }
    @ApiOperation("")
    @GetMapping
    public ResponseEntity<List<TehnologyDTO>> getAll() {
        List<TehnologyDTO> tehnologyDTOS = tehnologyService.getAll();
        return ResponseEntity.ok(tehnologyDTOS);
    }
    @ApiOperation("")
    @PatchMapping("/update/{id}")
    public ResponseEntity<TehnologyDTO> update(@PathVariable Long id, @RequestBody TehnologyDTO dto) {
        TehnologyDTO tehnologyDTO = tehnologyService.update(id, dto);
        return ResponseEntity.ok(tehnologyDTO);
    }
    @ApiOperation("")
    @PostMapping("/save")
    public ResponseEntity<Tehnology> save(@RequestBody TehnologyDTO tehnologyDTO){
        Tehnology tehnology = tehnologyService.save(tehnologyDTO);
        return ResponseEntity.ok(tehnology);
    }
    @ApiOperation("")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@RequestParam Long id) {
        tehnologyService.deleteBy(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
