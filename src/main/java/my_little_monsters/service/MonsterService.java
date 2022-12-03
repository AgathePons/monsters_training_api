package my_little_monsters.service;

import my_little_monsters.dto.MonsterDto;
import my_little_monsters.entities.Monster;

import java.util.Optional;
import java.util.Set;

public interface MonsterService {

    Iterable<Monster> findAll();

    Optional<Monster> findById(int id);

    Iterable<MonsterDto> searchQuery(String name, Double attack, Double defense, boolean isCute);

    Monster add(MonsterDto monsterDto);

    Optional<Monster> update(MonsterDto monsterDto);

    boolean delete(int id);
}
