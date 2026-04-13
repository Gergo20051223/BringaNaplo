package hu.nye.progkor.bringanaplo;

import java.time.LocalDate;

public class Biciklizes {

    private Long id;
    private LocalDate datum;
    private double tavolsagKm;
    private int idotartamPerc;
    private String megjegyzes;

    // Ez az üres verzió
    public Biciklizes() {
    }

    // EZ HIÁNYZIK MOST NEKED: Ez a verzió fogadja az 5 adatot
    public Biciklizes(Long id, LocalDate datum, double tavolsagKm, int idotartamPerc, String megjegyzes) {
        this.id = id;
        this.datum = datum;
        this.tavolsagKm = tavolsagKm;
        this.idotartamPerc = idotartamPerc;
        this.megjegyzes = megjegyzes;
    }

    // Getterek és Setterek
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }
    public double getTavolsagKm() { return tavolsagKm; }
    public void setTavolsagKm(double tavolsagKm) { this.tavolsagKm = tavolsagKm; }
    public int getIdotartamPerc() { return idotartamPerc; }
    public void setIdotartamPerc(int idotartamPerc) { this.idotartamPerc = idotartamPerc; }
    public String getMegjegyzes() { return megjegyzes; }
    public void setMegjegyzes(String megjegyzes) { this.megjegyzes = megjegyzes; }
}