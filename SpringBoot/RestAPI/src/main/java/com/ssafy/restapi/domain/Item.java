package com.ssafy.restapi.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Item {
    private Long id;
    private String name;
    private Long count;

    @Builder
    public Item(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    // id로 접근 금지(예제용)
    public void initId(Long id) {
        this.id = id;
    }

    public void updateItem(String name, Long count) {
        this.name = name;
        this.count = count;
    }
}
