package soa.dashboard.model.dto;

import soa.dashboard.model.entity.Movie;
import soa.dashboard.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

/*
    Deze klasse was alleen nodig omdat mijn API eerst een object data terug geeft met daarin de lijst zelf
    Normaal is dit niet nodig als je gwn je lijst terug geeft
    + te lui om een andere manier te vinden om het op te lossen
 */
public class DataProduct {

    private List<Product> data;

    public DataProduct() {
        this.data = new ArrayList<>();
    }

    public DataProduct(List<Product> data){
        this.setData(data);
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }
}
