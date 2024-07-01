package com.flab.CafeMap.web.cafe;

import com.flab.CafeMap.web.api.KakaoMapApi;
import com.flab.CafeMap.web.user.dto.KakaoMapApi.KakaoMapApiRequest;
import com.flab.CafeMap.web.user.dto.KakaoMapApi.KakaoMapApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController : @Controller + @ResponseBody
 * @RequiredArgsConstructor : final 필드에 대해 생성자 생성
 * @RequestMapping : 요청에 맞는 컨트롤러 매핑
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafes")
public class CafeController {

    private final KakaoMapApi kakaoMapApi;

    @PostMapping("/restaurant")
    public ResponseEntity<KakaoMapApiResponse> getRestaurant(
            @RequestBody KakaoMapApiRequest kakaoMapApiRequest) {
        ResponseEntity<KakaoMapApiResponse> response = kakaoMapApi.getAddressByCoordinates(
                kakaoMapApiRequest);
        return ResponseEntity.ok().body(response.getBody());
    }
}
