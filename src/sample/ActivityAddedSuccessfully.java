package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ActivityAddedSuccessfully {

    public void makeStage(){
        Stage miniStage=new Stage();
        Scene scene;
        miniStage.initModality(Modality.APPLICATION_MODAL);
        VBox miniBox=new VBox();
        miniBox.setSpacing(20);
        miniBox.setPadding(new Insets(20));
        miniBox.setAlignment(Pos.CENTER);
        Button close=new Button("Close");
        Label activityAdded=new Label("Activity Added Successfully");
        activityAdded.setFont(Font.font(15));
        close.setFont(Font.font(15));
        miniBox.getChildren().addAll(activityAdded,close);
        scene=new Scene(miniBox,250,100);
        miniStage.setScene(scene);
        miniStage.setTitle("Activity Added Successfully");
        miniStage.setResizable(false);
        miniStage.show();
        close.setOnAction(e->miniStage.close());




    }




}
