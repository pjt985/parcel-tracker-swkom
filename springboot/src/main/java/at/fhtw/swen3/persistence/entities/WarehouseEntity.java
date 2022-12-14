package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity(name = "warehouse_entity")
public class WarehouseEntity extends HopEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;*/

    @Column
    private Integer level;

    @OneToMany(mappedBy = "warehouse")
    @Column
    @NotNull
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
