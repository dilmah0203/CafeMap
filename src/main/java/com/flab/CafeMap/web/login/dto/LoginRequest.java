package com.flab.CafeMap.web.login.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  @Getter : getter 메소드를 자동으로 생성
 *  @Builder : 빌더 패턴을 사용할 수 있게 도와주는 애노테이션
 *  @AllArgsConstructor  : 모든 필드를 받는 생성자를 만들어준다.
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank
    public String loginId;

    @NotBlank
    private String password;
}
