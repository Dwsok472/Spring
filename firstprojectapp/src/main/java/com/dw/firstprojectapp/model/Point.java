package com.dw.firstprojectapp.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "traveler_name")
    private Traveler traveler;

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "points")
    private long points;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart_fk;
}
