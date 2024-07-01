package com.flab.CafeMap.web.user.dto.KakaoMapApi;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @Getter : getter 메소드를 자동으로 생성
 * @Builder : 빌더 패턴을 사용할 수 있게 도와주는 애노테이션
 */

@Getter
@Builder
@AllArgsConstructor
public class KakaoMapApiResponse {

    private Meta meta;
    private List<Documents> document;
}
