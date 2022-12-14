package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity(name = "warehouse_next_hops_entity")
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer traveltimeMins;

    @NotNull
    @OneToOne
    private HopEntity hopEntity;

    @ManyToOne
    @JoinColumn(name = "warehouse")
    private WarehouseEntity warehouse;
}
