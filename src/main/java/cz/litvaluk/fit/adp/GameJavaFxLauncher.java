package cz.litvaluk.fit.adp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.ArrayList;

import cz.litvaluk.fit.adp.game.Game;

public class GameJavaFxLauncher extends Application {

    private static final Game game = new Game();

    @Override
    public void init() {
        game.init();
    }

    @Override
    public void start(Stage stage) {
        String winTitle = game.getWindowTitle();
        int winWidth = game.getWindowWidth();
        int winHeight = game.getWindowHeight();

        stage.setTitle(winTitle);

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
            
        Canvas canvas = new Canvas(winWidth, winHeight);
        root.getChildren().add(canvas);
            
        game.setGraphicsContext(canvas.getGraphicsContext2D());

        ArrayList<String> pressedKeysCodes = new ArrayList<>();

        scene.setOnKeyPressed(keyEvent -> {
            String code = keyEvent.getCode().toString();
            // only add once... prevent duplicates
            if (!pressedKeysCodes.contains(code)) {
                pressedKeysCodes.add(code);
            }
        });

        scene.setOnKeyReleased(keyEvent -> {
            String code = keyEvent.getCode().toString();
            pressedKeysCodes.remove(code);
        });

        // the game-loop
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                game.processPressedKeys(pressedKeysCodes);
                game.update();
            }
        }.start();
            
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}