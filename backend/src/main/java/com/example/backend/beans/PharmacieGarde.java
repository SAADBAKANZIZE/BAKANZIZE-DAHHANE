package com.example.backend.beans;

import jakarta.persistence.*;

@Entity
public class PharmacieGarde {
    @EmbeddedId
    PharmacieGardeKey id;

    @ManyToOne
    @MapsId("pharmacieId")
    @JoinColumn(name = "pharmacie_id")
    Pharmacie pharmacie;

    @ManyToOne
    @MapsId("GardeId")
    @JoinColumn(name = "garde_id")
    Garde garde;

    String date;

}
