package my_little_monsters.dto;

import lombok.*;
import my_little_monsters.entities.Monster;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MonsterDto {
    private Integer id;
    private String name;
    private Double attackFactor;
    private Double defenseFactor;
    private Boolean isCute;

    public Monster toMonsterEntity() {
        Monster monsterEntity = new Monster();

        monsterEntity.setId(this.id);
        monsterEntity.setName(this.name);
        monsterEntity.setAttackFactor(this.attackFactor);
        monsterEntity.setDefenseFactor(this.defenseFactor);
        monsterEntity.setCute(this.isCute);

        return monsterEntity;
    }
}
