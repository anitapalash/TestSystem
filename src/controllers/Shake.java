package controllers;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node){
        tt= new TranslateTransition(javafx.util.Duration.millis(70), node);//тряска
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }
    public void playAnim(){
        tt.playFromStart();
    }
}
