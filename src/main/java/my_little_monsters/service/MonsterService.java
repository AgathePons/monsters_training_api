package my_little_monsters.service;

import my_little_monsters.dto.MonsterDto;

import java.util.Optional;
import java.util.Set;

public interface MonsterService {

    Set<MonsterDto> findAll();

    Optional<MonsterDto> findById(int id);

    Set<MonsterDto> searchQuery(String name, Double attack, Double defense, boolean isCute);

    MonsterDto add(MonsterDto monsterDto);

    Optional<MonsterDto> update(MonsterDto monsterDto);

    boolean delete(int id);
}
