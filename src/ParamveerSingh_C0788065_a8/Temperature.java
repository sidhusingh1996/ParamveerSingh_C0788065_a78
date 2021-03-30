package ParamveerSingh_C0788065_a8;

public class Temperature{
    private final String day;
    private final float temperature;
    private final float wind_speed;

    public Temperature(String day, float temperature, float wind_speed){
        this.day = day;
        this.temperature = temperature;
        this.wind_speed = wind_speed;
    }

    public float feel_like_temperature(){
        return temperature * wind_speed;
    }
}
