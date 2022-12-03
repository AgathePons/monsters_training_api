package my_little_monsters.service.impl;

import my_little_monsters.dto.MonsterDto;
import my_little_monsters.entities.Monster;
import my_little_monsters.repository.MonsterRepository;
import my_little_monsters.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    @Override
    public Iterable<Monster> findAll() {
        return this.monsterRepository.findAll();
    }

    @Override
    public Optional<Monster> findById(int id) {
        return this.monsterRepository.findById(id);
    }

    @Override
    public Monster add(MonsterDto monsterDto) {
        return this.monsterRepository.save(monsterDto.toMonsterEntity());
    }

    @Override
    public Optional<Monster> update(MonsterDto monsterDto) {
        Monster monsterEntity = monsterDto.toMonsterEntity();
        Optional<Monster> oMonster = this.monsterRepository.findById(monsterEntity.getId());
        if(oMonster.isPresent()) {
            this.monsterRepository.save(monsterEntity);
            return Optional.of(monsterEntity);
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        Optional<Monster> monsterToDelete = this.monsterRepository.findById(id);
        if (monsterToDelete.isPresent()) {
            this.monsterRepository.delete(monsterToDelete.get());
            return true;
        }
        return false;
    }

    @Override
    public Set<MonsterDto> searchQuery(String name, Double attack, Double defense, boolean isCute) {
        // TODO
        return null;
    }
}
