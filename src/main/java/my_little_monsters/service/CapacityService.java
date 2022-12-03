package my_little_monsters.service;

import my_little_monsters.dto.CapacityDto;
import my_little_monsters.entities.Capacity;

import java.util.Optional;
import java.util.Set;

public interface CapacityService {

    Iterable<Capacity> findAll();

    Optional<Capacity> findById(int id);

    Iterable<Capacity> searchQuery(String name, Integer attackValue, Integer defenseValue);

    Capacity add(CapacityDto capacityDto);

    Optional<Capacity> update(CapacityDto capacityDto);

    boolean delete(int id);
}
