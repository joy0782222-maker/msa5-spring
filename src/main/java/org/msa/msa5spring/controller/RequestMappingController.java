package org.msa.msa5spring.controller;

import org.msa.msa5spring.request.QueryRequestDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.Query;

@RestController
@RequestMapping("/api")
public class RequestMappingController {
    @GetMapping
    public String index() {
        return "조회";
    }
    @PostMapping
    public String store() {
        return "생성";
    }

    @PutMapping
    public String update() {
        return "수정";
    }
    @DeleteMapping
    public String destroy() {
        return "삭제";
    }
    @GetMapping("/query")
    public String query(QueryRequestDTO queryRequestDTO) {
        return String.format("%d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }

    @GetMapping("/segment/{id}/{name}")
    public String segment(@ModelAttribute QueryRequestDTO queryRequestDTO) {
        return String.format("%d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }

    // 세그먼트 파라미터를 이용한 path와 겹치지 않게 주의
    // @GetMapping("/segment/6/a")
    // public String test() {
    //     return "test";
    // }

    @PostMapping("/form")
    public String form(@ModelAttribute MultipartFile file) {
        return String.format("%s : %s", file.getContentType(), file.getOriginalFilename());
    }

    @GetMapping("/json")
    public String json(@RequestBody QueryRequestDTO queryRequestDTO) {
        return String.format("%s : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }
}

// Query Parameter
// - 어노테이션X, DTO객체 생성

// Segment Parameter
// - @PathVariable, 각 키에 맞는 파라미터를 별도로 컨트롤러(맵핑 메소드) 파라미터로 생성
// - @ModelAttribute, DTO 객체 생성

// Form Date
// - @ModelAttribute, DTO객체 또는 컨트롤러 파라미터

// JSON
// - @RequestBody, DTO객체