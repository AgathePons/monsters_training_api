package my_little_monsters.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="capacity")
@Getter @Setter
public class Capacity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "description", length = 450, nullable = true)
    private String description;

    @Column(name = "attack_value", nullable = false, columnDefinition = "integer default 1")
    private int attackValue;

    @Column(name = "defense_value", nullable = false, columnDefinition = "integer default 1")
    private int defenseValue;
}
