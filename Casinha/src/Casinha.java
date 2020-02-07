import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Casinha extends Application {

	public static void main(String[] args) {
		Casinha.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Group grp = new Group();
		Canvas canvas = new Canvas(512 -64,456); 
		Scene scn = new Scene(grp,510,510);
		grp.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		
		gc.setFill(Color.DODGERBLUE);
		gc.setStroke(Color.BLACK);
			gc.setLineWidth(2);
			gc.beginPath();
			gc.moveTo(100, 200);
			gc.lineTo(300, 200);
			gc.lineTo(300, 400);
			gc.lineTo(100, 400);
			gc.lineTo(100, 200);
			gc.lineTo(200, 100);
			gc.lineTo(300, 200);
			gc.stroke();	
			
	//	gc.fillRect(100, 200, 200, 200);
	//	gc.beginPath();
	//	gc.setFill(Color.BROWN);
	//	gc.moveTo(200, 200);
	//	gc.lineTo(100, 100);
	//	double x[]= {100,200,300};
	//	double y[]= {200,100,200};
	//	gc.fillPolygon(x, y, 3);
		
		
		stage.setScene(scn);
		stage.setTitle("Casa");
		stage.show();
		
	}

}
