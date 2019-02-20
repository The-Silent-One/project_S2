package inter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import SNR.Shipping;

public class Interface extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField t = new TextField("Write here");
        t.setAlignment(Pos.CENTER);
        
        t.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                //System.out.println(t.getCharacters());
                try{
                Shipping.Soc_send(t.getCharacters().toString());}catch(Exception e ){e.printStackTrace();System.out.println("Ouch");}
            }
        });
        
        Rectangle2D sc = Screen.getPrimary().getVisualBounds();
        int x=(int)sc.getMaxX();
        int y=(int)sc.getMaxY();
        //System.out.println(x+" "+y);
        StackPane root = new StackPane();
        root.getChildren().add(t);
        Scene scene = new Scene(root, x/4, y/4);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() { 
            @Override
            public void handle(WindowEvent event) {
                System.out.println("Bye Bye!");
                try{
                Shipping.Soc_send("#DC");}catch(Exception e){e.printStackTrace();System.out.println("Ouch");}
            }
        });
        scene.getStylesheets().add(this.getClass().getResource("bg.css").toExternalForm());
        primaryStage.setTitle("Robot Hand");
        primaryStage.setScene(scene);
        Image im = new Image("file:icon.png");
        primaryStage.getIcons().add(im);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
