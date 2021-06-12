package soa.dashboard.model.dto;



import java.util.Objects;

public class F1DTO {

    private String naam;
    private String budget;
    private String beschrijving;

    public F1DTO() {}

    public F1DTO(String naam, String budget, String beschrijving){
        this.setNaam(naam);
        this.setBudget(budget);
        this.setBeschrijving(beschrijving);
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
        return "F1DTO{" +
                "naam='" + naam + '\'' +
                ", budget=" + budget +
                ", beschrijving='" + beschrijving + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        F1DTO f1DTO = (F1DTO) o;
        return budget == f1DTO.budget && Objects.equals(naam, f1DTO.naam) && Objects.equals(beschrijving, f1DTO.beschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, budget, beschrijving);
    }
}
