import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Elipses extends Application {

	public static void main(String[] args) {
		Elipses.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Group grp = new Group();
		Canvas canvas = new Canvas(800,500); 
		Scene scn = new Scene(grp,800,500);
		grp.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		double radiusX = 400;
		double radiusY = 250;
		gc.moveTo(800,500);

		while (radiusX >= 10) {
			gc.arc(400, 250, radiusX, radiusY, 0, 360);
			gc.stroke();
			radiusX = radiusX - 10;
			gc.moveTo(400+radiusX,250);
		}
		gc.moveTo(800,500);
		while (radiusY >= 10) {
			gc.arc(400, 250, 400, radiusY, 0, 360);
			gc.stroke();
			radiusY = radiusY - 10;
		}

		stage.setScene(scn);
		stage.setTitle("Graphic User Interface - MyJPanel");
		stage.show();
		
	}

}
