package DummyCode;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "city")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int city_id;
    String city;
    int country_id;
    DateTimeFormat last_update;


    public City( int city_id,String city,int country_id,DateTimeFormat last_update){
        this.city = city;
        this.city_id = city_id;
        this.country_id = country_id;
        this.last_update = last_update;

    }
    public City(){}

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public DateTimeFormat getLast_update() {
        return last_update;
    }

    public void setLast_update(DateTimeFormat last_update) {
        this.last_update = last_update;
    }
}
