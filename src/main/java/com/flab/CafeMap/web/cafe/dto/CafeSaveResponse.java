package com.flab.CafeMap.web.cafe.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CafeSaveResponse {

    private Long id;
    private String name;
    private String address;
}
