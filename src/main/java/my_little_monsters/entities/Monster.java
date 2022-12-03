package my_little_monsters.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "monster")
@Getter @Setter
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "attack_factor", nullable = false, columnDefinition="Decimal(10,2) default '1.0'")
    private Double attackFactor = 1D;

    @Column(name = "defense_factor", nullable = false, columnDefinition="Decimal(10,2) default '1.0'")
    private  Double defenseFactor = 1D;

    @Column(name = "is_cute", nullable = false)
    private boolean isCute;
}
