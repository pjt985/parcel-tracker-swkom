package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "parcel_entity")
public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @DecimalMin(value = "0.0", message = "weight cannot be negative")
    @Column
    private float weight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    @NotNull
    private RecipientEntity recipient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    @NotNull
    private RecipientEntity sender;

    @Pattern(regexp = "^[A-Z0-9]{9}$")
    @Column
    private String trackingId;

    @Column
    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy="fk_parcel")
    @NotNull
    @Column
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany(mappedBy="fk_parcel")
    @NotNull
    @Column
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    public ParcelEntity recipient(RecipientEntity recipientEntity) {
        this.recipient = recipientEntity;
        return this;
    }

    public ParcelEntity sender(RecipientEntity recipientEntity) {
        this.sender = recipientEntity;
        return this;
    }

    public ParcelEntity state(TrackingInformation.StateEnum state) {
        this.state = state;
        return this;
    }

    public ParcelEntity weight(Float weight) {
        this.weight = weight;
        return this;
    }

    public ParcelEntity trackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }
}
