package soa.dashboard.model.dto;

import soa.dashboard.model.entity.Movie;
import java.util.ArrayList;
import java.util.List;

/*
    Deze klasse was alleen nodig omdat mijn API eerst een object data terug geeft met daarin de lijst zelf
    Normaal is dit niet nodig als je gwn je lijst terug geeft
    + te lui om een andere manier te vinden om het op te lossen
 */
public class DataMovie {

    private List<Movie> data;

    public DataMovie() {
        this.data = new ArrayList<>();
    }

    public DataMovie(List<Movie> data){
        this.setData(data);
    }

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }
}
