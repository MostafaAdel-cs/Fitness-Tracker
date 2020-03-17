package Activitiy;

import Activitiy.Activity;

public class ActivityInit {
    public Activity[] activities=new Activity[4];
    public Activity swimming=new Activity("Swimming",0.002,4.0);
    public    Activity running =new Activity("Running",0.003,5.0);
    public    Activity kickBoxing=new Activity("Kick Boxing",0.005,3.0);
    public    Activity strengthTraining=new Activity("Strength Training",0.006,5.0);

    public Activity[] getArrayOfActivities(){
        activities[0]=swimming;
        activities[1]=running;
        activities[2]=kickBoxing;
        activities[3]=strengthTraining;
    return activities;
    }


}