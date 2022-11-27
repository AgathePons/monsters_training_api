package my_little_monsters.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapacityDtoTest {
    @Test
    void testDefaultConstructor() {
        var capacityDto = new CapacityDto();
        assertAll(
                () -> assertNull(capacityDto.getId(), "id"),
                () -> assertNull(capacityDto.getName(), "name"),
                () -> assertNull(capacityDto.getDescription(), "description"),
                () -> assertNull(capacityDto.getAttackValue(), "attack value"),
                () -> assertNull(capacityDto.getDefenseValue(), "defense value")
        );
    }
}