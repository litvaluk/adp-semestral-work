package cz.litvaluk.fit.adp;

import cz.litvaluk.fit.adp.game.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameJavaFxLauncher extends Application {

    private static final Game game = new Game();
    private final HashMap<String, Boolean> currentlyActiveKeys = new HashMap<>();

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

        scene.setOnKeyPressed(keyEvent -> {
            String code = keyEvent.getCode().toString();
            if (!currentlyActiveKeys.containsKey(code)) {
                currentlyActiveKeys.put(code, true);
            }
        });

        scene.setOnKeyReleased(keyEvent -> {
            String code = keyEvent.getCode().toString();
            currentlyActiveKeys.remove(code);
        });

        // the game-loop
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                game.processPressedKeys(getActiveKeys());
                game.update();
                removeActiveKey("SPACE");
            }
        }.start();
            
        stage.show();
    }

    private List<String> getActiveKeys() {
        List<String> activeKeys = new ArrayList<>();
        for(String code : currentlyActiveKeys.keySet()) {
            if(currentlyActiveKeys.get(code)) {
                activeKeys.add(code);
            }
        }
        return activeKeys;
    }

    private void removeActiveKey(String code) {
        Boolean isActive = currentlyActiveKeys.get(code);
        if (isActive != null && isActive) {
            currentlyActiveKeys.put(code, false);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}