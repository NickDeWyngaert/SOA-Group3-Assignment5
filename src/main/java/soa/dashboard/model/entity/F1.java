package soa.dashboard.model.entity;

import java.util.Objects;

public class F1 {

    private int id;
    private String naam;
    private String budget;
    private String beschrijving;

    public F1() {}

    public F1(int id, String naam, String budget, String beschrijving){
        this.setId(id);
        this.setNaam(naam);
        this.setBudget(budget);
        this.setBeschrijving(beschrijving);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    @Override
    public String toString() {
        return "f1team{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", budget=" + budget +
                ", beschrijving='" + beschrijving + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        F1 f1 = (F1) o;
        return id == f1.id && budget == f1.budget && Objects.equals(naam, f1.naam) && Objects.equals(beschrijving, f1.beschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, budget, beschrijving);
    }
}
