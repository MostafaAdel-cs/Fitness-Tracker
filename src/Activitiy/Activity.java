package Activitiy;

public class Activity {
    private String name = new String();
    private Double heartRate;
    private Double heartRateInc;
    private Double calories;
    private Double caloriesBurnt;
    private Double time;

    public Activity(String name, Double heartRate, Double calories) {
        this.name = name;
        this.heartRate = heartRate;
        this.calories = calories;
        this.caloriesBurnt = 0.0;
        this.time = 0.0;
        this.heartRateInc = 0.0;
    }
    public Double getCalories() {

        return this.calories;
    }

    public Double getCaloriesBurnt() {

        return this.caloriesBurnt;

    }

    public String getName() {
        return this.name;
    }

    public Double getHeartRateIncOfActivity(){
        return this.heartRateInc;
    }
    public Double getHeartRateInc(){
        return this.heartRate;
    }
    public void addTime(Double time,Double heartRate)
    {
        this.time+=time;
        this.heartRateInc+=this.heartRate*heartRate*time;
        caloriesBurnt=caloriesBurnt+time*this.calories;
    }


}
