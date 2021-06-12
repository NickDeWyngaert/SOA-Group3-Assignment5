package soa.dashboard.model.dto;


public class OnlyF1Object {

    private F1DTO f1;

    public OnlyF1Object() {}

    public OnlyF1Object(F1DTO f1) {
        this.setF1(f1);
    }

    public F1DTO getF1() {
        return f1;
    }

    public void setF1(F1DTO f1) {
        this.f1 = f1;
    }
}
