package soa.dashboard.model.dto;

import soa.dashboard.model.entity.F1;
import soa.dashboard.model.entity.Movie;
import java.util.ArrayList;
import java.util.List;


public class DataF1 {

    private List<F1> data;

    public DataF1() {
        this.data = new ArrayList<>();
    }

    public DataF1(List<F1> data){
        this.setData(data);
    }

    public List<F1> getData() {

        return data;
    }

    public void setData(List<F1> data) {
        this.data = data;
    }
}
