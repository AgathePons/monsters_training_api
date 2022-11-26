package my_little_monsters.service.impl;

import my_little_monsters.dto.MonsterDto;
import my_little_monsters.service.MonsterService;

import java.util.Optional;
import java.util.Set;

public class MonsterServiceImpl implements MonsterService {
    @Override
    public Set<MonsterDto> findAll() {
        return Set.of(
                MonsterDto.builder()
                        .id(1)
                        .name("Boogie Man")
                        .attackFactor(0.30)
                        .defenseFactor(0.10)
                        .isCute(false)
                        .build(),
                MonsterDto.builder()
                        .id(2)
                        .name("Mush mush")
                        .attackFactor(0.20)
                        .defenseFactor(0.50)
                        .isCute(true)
                        .build(),
                MonsterDto.builder()
                        .id(3)
                        .name("Spider Queen")
                        .attackFactor(0.70)
                        .defenseFactor(0.20)
                        .isCute(false)
                        .build()
        );
    }

    @Override
    public Optional<MonsterDto> findById(int id) {
        if (id == 0) {
            return Optional.empty();
        } else {
            return Optional.of(MonsterDto.builder()
                    .id(3)
                    .name("Spider Queen")
                    .attackFactor(0.70)
                    .defenseFactor(0.20)
                    .isCute(false)
                    .build());
        }

    }

    @Override
    public Set<MonsterDto> searchQuery(String name, Double attack, Double defense, boolean isCute) {
        return Set.of(
                MonsterDto.builder()
                        .id(2)
                        .name("Mush mush")
                        .attackFactor(0.20)
                        .defenseFactor(0.50)
                        .isCute(true)
                        .build(),
                MonsterDto.builder()
                        .id(3)
                        .name("Spider Queen")
                        .attackFactor(0.70)
                        .defenseFactor(0.20)
                        .isCute(false)
                        .build()
        );
    }

    @Override
    public MonsterDto add(MonsterDto monsterDto) {
        monsterDto.setId(666);
        return monsterDto;
    }

    @Override
    public Optional<MonsterDto> update(MonsterDto monsterDto) {
        if (monsterDto.getId() == 0) {
            return Optional.empty();
        } else {
            var monster = MonsterDto.builder()
                    .name("Name")
                    .attackFactor(0.50)
                    .defenseFactor(0.50)
                    .isCute(false)
                    .build();
            monster.setName(monsterDto.getName());
            monster.setAttackFactor(monsterDto.getAttackFactor());
            monster.setDefenseFactor(monsterDto.getDefenseFactor());
            monster.setIsCute(monsterDto.getIsCute());
            return Optional.of(monster);
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
