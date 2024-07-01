package com.flab.CafeMap.web.reservation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.CafeMap.domain.reservation.service.ReservationService;
import com.flab.CafeMap.web.reservation.dto.ReservationSaveRequest;
import com.flab.CafeMap.web.reservation.dto.ReservationSaveResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

@WebMvcTest(ReservationController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Disabled
class ReservationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ReservationService reservationService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("예약 생성 테스트")
    void createReservation() throws Exception {
        //given
        ReservationSaveRequest reservationRequest = ReservationSaveRequest.builder()
                .userId(1L)
                .cafeId(1L)
                .cafeName("Test Cafe")
                .cafeAddress("Test Address")
                .build();

        MockHttpSession mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("loginId", "test");

        ReservationSaveResponse response = ReservationSaveResponse.builder()
                .userId(1L)
                .cafeId(1L)
                .cafeName("Test Cafe")
                .build();

        when(reservationService.addReservation(any(ReservationSaveRequest.class), any(String.class)))
                .thenReturn(response);

        //when
        mockMvc.perform(post("/reservations")
                        .session(mockHttpSession)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservationRequest))
                        .accept(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isCreated());
    }
}

