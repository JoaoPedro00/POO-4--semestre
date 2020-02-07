import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pentagrama extends Application {

	public static void main(String[] args) {
		Pentagrama.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group grp = new Group();
		Canvas canvas = new Canvas(500,500); 
		Scene scn = new Scene(grp,510,510);
		grp.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		
		gc.setFill(Color.DODGERBLUE);
		gc.setStroke(Color.BLACK);
			gc.setLineWidth(2);
			gc.beginPath();
			gc.moveTo(100, 200);
			gc.lineTo(400, 200);
			gc.lineTo(100, 400);
			gc.lineTo(250, 100);
			gc.lineTo(400, 400);
			gc.lineTo(100, 200);
			gc.stroke();
			
			stage.setScene(scn);
			stage.setTitle("Casa");
			stage.show();
	}

}
