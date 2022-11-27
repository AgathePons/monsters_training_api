package my_little_monsters.controller;

import my_little_monsters.dto.CapacityDto;
import my_little_monsters.service.CapacityService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CapacityController.class)
class CapacityControllerTest {

    final static String BASE_URL = "/api/capacities";

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CapacityService capacityService;

    @Test
    void testGetByIdOk() throws Exception {
        // given
        int id = 666;
        String name = "Crounch";
        String description = "Bite the enemy";
        int attack = 5;
        int defense = 10;
        var capacityDto = CapacityDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .attackValue(attack)
                .defenseValue(defense)
                .build();

        BDDMockito.given(capacityService.findById(id))
                .willReturn(Optional.of(capacityDto));
        // when
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + id)
                        .accept(MediaType.APPLICATION_JSON)
                )
        // then: verify HTTP communication
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        // then: verify trainee service is called
        BDDMockito.then(capacityService)
                .should()
                .findById(id);
    }
}