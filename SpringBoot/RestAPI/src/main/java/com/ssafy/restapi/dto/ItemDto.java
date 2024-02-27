package com.ssafy.restapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private Long count;

    @Builder
    public ItemDto(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
