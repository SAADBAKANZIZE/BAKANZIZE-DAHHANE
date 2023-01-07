package com.example.backend.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String adresse;
    private double longitude;
    private double latitude;

    @ManyToOne(optional = true)
    @JoinColumn(name = "zone_id")
    private Zone zone;


    @ManyToOne(optional = true)
    @JoinColumn(name = "pharmacien_id")
    private User pharmacien;

    @JsonIgnore
    @OneToMany(mappedBy = "pharmacie",  cascade = CascadeType.REMOVE)
    Set<PharmacieGarde> engardes;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    @JsonIgnore
    public Zone getZone() {
        return zone;
    }
    @JsonSetter
    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public User getPharmacien() {
        return pharmacien;
    }

    public void setPharmacien(User pharmacien) {
        this.pharmacien = pharmacien;
    }


}
