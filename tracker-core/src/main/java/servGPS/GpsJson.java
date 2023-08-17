package servGPS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GpsJson {

    public double shirota;
    public double dolgota;
    public double azimyt;

    public double getShirota() {
        return shirota;
    }

    public void setShirota() {
        this.shirota = shirota;
    }

    public double getDolgota() {
        return dolgota;
    }

    public void setDolgota() {
        this.dolgota = dolgota;
    }

    public Double getAzimyt() {
        return azimyt;
    }

    public void setAzimyt(Double autoId) {
        this.azimyt = autoId;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "Point{" +
                "Ширина=" + shirota +
                ", Долгота=" + dolgota +
                ", Азимут='" + azimyt + '\'' +
                '}';
    }
}
