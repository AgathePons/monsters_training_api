package my_little_monsters.service.impl;

import my_little_monsters.dto.CapacityDto;
import my_little_monsters.entities.Capacity;
import my_little_monsters.repository.CapacityRepository;
import my_little_monsters.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CapacityServiceImpl implements CapacityService {

    @Autowired
    private CapacityRepository capacityRepository;

    @Override
    public Iterable<Capacity> findAll() {
        return this.capacityRepository.findAll();
//        return Set.of(
//                CapacityDto.builder()
//                        .id(1)
//                        .name("Crounch")
//                        .description("Bite the enemy")
//                        .attackValue(5)
//                        .defenseValue(0)
//                        .build(),
//                CapacityDto.builder()
//                        .id(2)
//                        .name("Pouet")
//                        .description("Pouet the enemy")
//                        .attackValue(10)
//                        .defenseValue(0)
//                        .build(),
//                CapacityDto.builder()
//                        .id(1)
//                        .name("Cute eyes")
//                        .description("Make cute eyes at the enemy")
//                        .attackValue(0)
//                        .defenseValue(15)
//                        .build()
//        );
    }

    @Override
    public Optional<Capacity> findById(int id) {
        return this.capacityRepository.findById(id);
    }

    @Override
    public Capacity add(CapacityDto capacityDto) {
        return this.capacityRepository.save(this.capacityRepository.save(capacityDto.toCapacityEntity()));
    }

    @Override
    public Optional<Capacity> update(CapacityDto capacityDto) {
        Capacity capacityEntity = capacityDto.toCapacityEntity();
        Optional<Capacity> oCapacity = this.capacityRepository.findById(capacityEntity.getId());
        if (oCapacity.isPresent()) {
            this.capacityRepository.save(capacityEntity);
            return Optional.of(capacityEntity);
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        Optional<Capacity> capacityToDelete = this.capacityRepository.findById(id);
        if(capacityToDelete.isPresent()) {
            this.capacityRepository.delete(capacityToDelete.get());
            return true;
        }
        return false;
    }

    @Override
    public Iterable<Capacity> searchQuery(String name, Integer attackValue, Integer defenseValue) {
        // TODO
        return null;
    }
}
