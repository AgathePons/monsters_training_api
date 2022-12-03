package my_little_monsters.dto;

import lombok.*;
import my_little_monsters.entities.Capacity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CapacityDto {

    private Integer id;
    private String name;
    private String description;
    private Integer attackValue;
    private Integer defenseValue;

    public Capacity toCapacityEntity() {
        Capacity capacityEntity = new Capacity();

        capacityEntity.setId(this.id);
        capacityEntity.setName(this.name);
        capacityEntity.setDescription(this.description);
        capacityEntity.setAttackValue(this.attackValue);
        capacityEntity.setDefenseValue(this.defenseValue);

        return capacityEntity;
    }
}
