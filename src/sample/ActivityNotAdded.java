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

public class ActivityNotAdded {
    public void makeStage(){
        Stage miniStage=new Stage();
        Scene scene;
        miniStage.initModality(Modality.APPLICATION_MODAL);
        VBox miniBox=new VBox();
        miniBox.setAlignment(Pos.CENTER);
        miniBox.setSpacing(20);
        miniBox.setPadding(new Insets(20));
        Button close=new Button("Close");
        Label activityNotAdded=new Label("Error Adding Activity");

        activityNotAdded.setFont(Font.font(15));
        close.setFont(Font.font(15));
        miniBox.getChildren().addAll(activityNotAdded,close);
        scene=new Scene(miniBox,250,100);
        miniStage.setScene(scene);
        miniStage.setTitle("Activity Not Added");
        miniStage.setResizable(false);
        miniStage.setResizable(false);
        miniStage.show();
        close.setOnAction(e->miniStage.close());

    }

}
