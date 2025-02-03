package com.ademlo.f1statisticsapi.features.season.infra.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeasonEntity {
    private String code;
    private String name;
}
