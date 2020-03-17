package sample;

import Activitiy.Activity;
import Activitiy.ActivityInit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static java.lang.Double.parseDouble;

public class Main extends Application {
private ActivityInit activity=new ActivityInit();
ResultScene resultScene=new ResultScene();
private ActivityNotAdded activityNotAdded=new ActivityNotAdded();
private ActivityAddedSuccessfully activityAdded=new ActivityAddedSuccessfully();
private Double heartRate=80.0;
private Double calories=0.0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene mainScene;
        VBox mainBox=new VBox(10);
        mainBox.setAlignment(Pos.CENTER);
        HBox firstBox =new HBox(20);
        firstBox.setPadding(new Insets(10));
        firstBox.setAlignment(Pos.CENTER);
        Label time=new Label("Time");
        time.setFont(Font.font(19));
        TextField timee=new TextField();

        firstBox.getChildren().add( time);


        firstBox.getChildren().add( timee);


        HBox secondBox=new HBox(20);
        //secondBox.setAlignment(Pos.CENTER);
        secondBox.setPadding(new Insets(10));
        Label chooseActivity=new Label();
        chooseActivity.setText("Choose Activity");
        chooseActivity.setFont(Font.font(19));
        ChoiceBox<String> activities=new ChoiceBox<>();
        activities.getItems().addAll("Swimming","Running","Kick Boxing","Strength Training");
        secondBox.getChildren().addAll(chooseActivity);
        secondBox.getChildren().addAll(activities);

        HBox thirdBox=new HBox(20);
        thirdBox.setAlignment(Pos.CENTER);
        thirdBox.setPadding(new Insets(10));
        Button addActivity=new Button("Add Activity");
        addActivity.setFont(Font.font(15));
        Button result =new Button ("Result");
        result.setFont(Font.font(15));
        thirdBox.getChildren().add(addActivity);
        thirdBox.getChildren().add(result);
        VBox fourthBox=new VBox();
        Button close =new Button("Close");
        close.setFont(Font.font(15));
        fourthBox.setAlignment(Pos.CENTER);
        fourthBox.getChildren().add(close);

        mainBox.getChildren().addAll(firstBox ,secondBox,thirdBox,fourthBox);
        mainScene = new Scene(mainBox,300,225);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Fitness Tracker");
        primaryStage.setResizable(false);
        primaryStage.show();

        addActivity.setOnAction(e->addActivityButtonClicked(activities.getValue(), timee.getText(),heartRate ));
        result.setOnAction(e->resultButtonClicked(heartRate,calories,activity.getArrayOfActivities()));
        close.setOnAction(e->primaryStage.close());
    }



    private void resultButtonClicked(Double heartRate, Double calories, Activity[] activity)
    {

        resultScene.makeStage(heartRate,calories,activity);


    }
    private void addActivityButtonClicked(String activity,String t,Double heartRate)
    {   if(validate(t)&&activity!=null&&heartRate!=null) {
        Double time = parseDouble(t);


        if (activity.contentEquals("Swimming")) {
            this.activity.swimming.addTime(time, heartRate);
            this.heartRate += this.heartRate * time * this.activity.swimming.getHeartRateInc();
            this.calories += this.activity.swimming.getCalories() * time;
        } else if (activity.contentEquals("Kick Boxing")) {
            this.activity.kickBoxing.addTime(time, heartRate);
            this.heartRate += this.heartRate * time * this.activity.kickBoxing.getHeartRateInc();
            this.calories += this.activity.kickBoxing.getCalories() * time;
        } else if (activity.contentEquals("Strength Training")) {
            this.activity.strengthTraining.addTime(time, heartRate);
            this.heartRate += this.heartRate * time * this.activity.strengthTraining.getHeartRateInc();
            this.calories += this.activity.strengthTraining.getCalories() * time;
        } else {
            this.activity.running.addTime(time, heartRate);
            this.heartRate += this.heartRate * time * this.activity.running.getHeartRateInc();
            this.calories += this.activity.running.getCalories() * time;
        }
        activityAdded.makeStage();
    }

    else activityNotAdded.makeStage();
    }

    public Boolean validate(String time){
        try{
            parseDouble(time);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
