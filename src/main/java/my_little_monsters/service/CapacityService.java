package my_little_monsters.service;

import my_little_monsters.dto.CapacityDto;

import java.util.Optional;
import java.util.Set;

public interface CapacityService {

    Set<CapacityDto> findAll();

    Optional<CapacityDto> findById(int id);

    Set<CapacityDto> searchQuery(String name, Integer attackValue, Integer defenseValue);

    CapacityDto add(CapacityDto capacityDto);

    Optional<CapacityDto> update(CapacityDto capacityDto);

    boolean delete(int id);
}
