package com.ademlo.f1statisticsapi.features.season.infra.http;

import com.ademlo.f1statisticsapi.features.season.domain.models.Season;
import com.ademlo.f1statisticsapi.features.season.domain.SeasonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/season")
public class SeasonController {
    private final SeasonRepository seasonRepository;

    public SeasonController(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Season>> getAll() {
        return ResponseEntity.ok(seasonRepository.list());
    }
}
