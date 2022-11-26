package my_little_monsters.dto;

import lombok.*;

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
}
