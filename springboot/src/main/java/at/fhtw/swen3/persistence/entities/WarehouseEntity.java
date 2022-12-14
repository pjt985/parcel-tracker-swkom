package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "warehouse_entity")
public class WarehouseEntity extends HopEntity {

    @Column
    private Integer level;

    @OneToMany
    @Column
    @NotNull
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
