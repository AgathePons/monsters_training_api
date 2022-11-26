package my_little_monsters.service.impl;

import my_little_monsters.dto.CapacityDto;
import my_little_monsters.service.CapacityService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CapacityServiceImpl implements CapacityService {

    @Override
    public Set<CapacityDto> findAll() {
        return Set.of(
                CapacityDto.builder()
                        .id(1)
                        .name("Crounch")
                        .description("Bite the enemy")
                        .attackValue(5)
                        .defenseValue(0)
                        .build(),
                CapacityDto.builder()
                        .id(2)
                        .name("Pouet")
                        .description("Pouet the enemy")
                        .attackValue(10)
                        .defenseValue(0)
                        .build(),
                CapacityDto.builder()
                        .id(1)
                        .name("Cute eyes")
                        .description("Make cute eyes at the enemy")
                        .attackValue(0)
                        .defenseValue(15)
                        .build()
        );
    }

    @Override
    public Optional<CapacityDto> findById(int id) {
        if (id == 0) {
            return Optional.empty();
        } else {
            return Optional.of(
                    CapacityDto.builder()
                            .id(1)
                            .name("Crounch")
                            .description("Bite the enemy")
                            .attackValue(5)
                            .defenseValue(0)
                            .build()
            );
        }
    }

    @Override
    public Set<CapacityDto> searchQuery(String name, Integer attackValue, Integer defenseValue) {
        return Set.of(
                CapacityDto.builder()
                        .id(1)
                        .name(name)
                        .description("Description of " + name)
                        .attackValue(5)
                        .defenseValue(0)
                        .build(),
                CapacityDto.builder()
                        .id(1)
                        .name("Sneaky " + name)
                        .description("Description of the capacity")
                        .attackValue(0)
                        .defenseValue(15)
                        .build()
        );
    }

    @Override
    public CapacityDto add(CapacityDto capacityDto) {
        capacityDto.setId(666);
        return capacityDto;
    }

    @Override
    public Optional<CapacityDto> update(CapacityDto capacityDto) {
        if (capacityDto.getId() == 0) {
            return Optional.empty();
        } else {
            var capacity = CapacityDto.builder()
                    .name("Name")
                    .description("Description of the capacity")
                    .attackValue(10)
                    .defenseValue(10)
                    .build();
            capacity.setName(capacityDto.getName());
            capacity.setDescription(capacityDto.getName());
            capacity.setAttackValue(capacityDto.getAttackValue());
            capacity.setDefenseValue((capacityDto.getDefenseValue()));
            return Optional.of(capacity);
        }
    }

    @Override
    public boolean delete(int id) {
        if (id == 0) {
            return false;
        } else {
            return true;
        }
    }
}
