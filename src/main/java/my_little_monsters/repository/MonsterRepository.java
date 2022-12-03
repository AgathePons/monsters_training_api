package my_little_monsters.repository;

import my_little_monsters.entities.Monster;
import org.springframework.data.repository.CrudRepository;

public interface MonsterRepository extends CrudRepository<Monster, Integer> {
}
