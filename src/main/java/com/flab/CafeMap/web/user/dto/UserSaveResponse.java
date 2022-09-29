package com.flab.CafeMap.web.user.dto;

import com.flab.CafeMap.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSaveResponse {

    private String loginId;
    private String name;
    private String phoneNumber;

    public static UserSaveResponse from(User user) {
        return new UserSaveResponse(user.getLoginId(), user.getName(), user.getPhoneNumber());
    }
}
