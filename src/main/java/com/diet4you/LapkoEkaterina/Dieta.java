package com.diet4you.LapkoEkaterina;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "diety")
public class Dieta {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="DIETA_ID") private int dietaId;
    @NotEmpty
    @Column(unique=true, name ="DIETA_NAZWA")
    private String nazwa;
    @NotEmpty
    @Column(name="OPIS") private String opis;
    public Dieta(){ }
    public Dieta (int dietaId,String nazwa, String opis )
    { this.dietaId = dietaId;
    this.nazwa = nazwa;
    this.opis = opis; }
    public int getDietaId() {
        return dietaId; }
        public void setDietaId(int dietaId) {
        this.dietaId = dietaId; }
        public String getNazwa() {
        return nazwa; }
        public void setNazwa(String nazwa) {
        this.nazwa = nazwa; }
        public String getOpis() {
        return opis; }
        public void setOpis(String opis) {
        this.opis = opis; }
}

