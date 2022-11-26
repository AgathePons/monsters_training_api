package my_little_monsters.dto;

import lombok.*;

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
}
