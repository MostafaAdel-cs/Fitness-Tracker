package sample;

import Activitiy.Activity;
import Activitiy.ActivityInit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ResultScene {

    public void makeStage(Double heartRate, Double calories, Activity[] activities)
    {
        Stage finalStage=new Stage();
        Scene finalScene;
        finalStage.initModality(Modality.APPLICATION_MODAL);
        VBox finalBox=new VBox();
        finalBox.setAlignment(Pos.CENTER_LEFT);
        finalBox.setSpacing(10);
        finalBox.setPadding(new Insets(10));


        Label totalCalories=new Label("Total Calories Burnt = "+calories+" calorie");
        Label totalHeartRate=new Label("Total Heart Rate = "+heartRate+" beat/min");
        totalCalories.setFont(Font.font(20));
        totalHeartRate.setFont(Font.font(20));


        Label activityRank=new Label("Activity Rank");
        activityRank.setFont(Font.font(19));

        finalBox.getChildren().addAll(totalCalories,totalHeartRate,activityRank);


        activities=sortActivities(activities);


        Label firstActivity=new Label("1."+activities[0].getName());
        Label firstActivityCalories=new Label("Calories Burnt : "+activities[0].getCaloriesBurnt()+" calorie");
        Label firstActivityHeartRate=new Label("Increase In Heart Rate : "+activities[0].getHeartRateIncOfActivity()+" beat/min");
        firstActivity.setFont(Font.font(19));
        firstActivityCalories.setFont(Font.font(15));
        firstActivityHeartRate.setFont(Font.font(15));



        Label secondActivity=new Label("2."+activities[1].getName());
        Label secondActivityCalories=new Label("Calories Burnt : "+activities[1].getCaloriesBurnt()+" calorie");
        Label secondActivityHeartRate=new Label("Increase In Heart Rate : "+activities[1].getHeartRateIncOfActivity()+" beat/min");
        secondActivity.setFont(Font.font(19));
        secondActivityCalories.setFont(Font.font(15));
        secondActivityHeartRate.setFont(Font.font(15));


        Label thirdActivity=new Label("3."+activities[2].getName());
        Label thirdActivityCalories=new Label("Calories Burnt : "+activities[2].getCaloriesBurnt()+" calorie");
        Label thirdActivityHeartRate=new Label("Increase In Heart Rate : "+activities[2].getHeartRateIncOfActivity()+" beat/min");
        thirdActivity.setFont(Font.font(19));
        thirdActivityCalories.setFont(Font.font(15));
        thirdActivityHeartRate.setFont(Font.font(15));


        Label fourthActivity=new Label("4."+activities[3].getName());
        Label fourthActivityCalories=new Label("Calories Burnt : "+activities[3].getCaloriesBurnt()+" calorie");
        Label fourthActivityHeartRate=new Label("Increase In Heart Rate : "+activities[3].getHeartRateIncOfActivity()+" beat/min");
        fourthActivity.setFont(Font.font(19));
        fourthActivityCalories.setFont(Font.font(15));
        fourthActivityHeartRate.setFont(Font.font(15));


        finalBox.getChildren().addAll(firstActivity,firstActivityCalories,firstActivityHeartRate);
        finalBox.getChildren().addAll(secondActivity,secondActivityCalories,secondActivityHeartRate);
        finalBox.getChildren().addAll(thirdActivity,thirdActivityCalories,thirdActivityHeartRate);
        finalBox.getChildren().addAll(fourthActivity,fourthActivityCalories,fourthActivityHeartRate);


        VBox closeBox=new VBox();
        closeBox.setAlignment(Pos.CENTER);
        Button close=new Button("Close");
        close.setFont(Font.font(17));
        closeBox.getChildren().add(close);

        finalBox.getChildren().add(closeBox);
        finalScene=new Scene(finalBox,335,600);
        finalStage.setScene(finalScene);
        finalStage.setTitle("Result");
        finalStage.setResizable(false);
        finalStage.show();

        close.setOnAction(e->finalStage.close());









    }
private Activity[] sortActivities(Activity[] activities)
{
    int pass,j;
    Activity temp;
    for(pass=1;pass<4;pass++)
    {
        for(j=0;j<4-pass;j++)
        {
            if(activities[j].getCaloriesBurnt()<=activities[j+1].getCaloriesBurnt())
            {
                if(activities[j].getHeartRateIncOfActivity()<activities[j+1].getHeartRateIncOfActivity()) {
                    temp = activities[j];
                    activities[j] = activities[j + 1];
                    activities[j + 1] = temp;
                }
            }


        }
    }

return activities;

}


}
