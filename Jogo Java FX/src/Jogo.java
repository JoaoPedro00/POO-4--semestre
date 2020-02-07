import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Jogo extends Application{
	private int dx;
	private int x=200;
	private int dy;
	private int y=200;
	Canvas canvas = new Canvas(640,480); 
	GraphicsContext gc = canvas.getGraphicsContext2D();
	private int velocidade = 20;
	
	class Manipulador implements EventHandler<KeyEvent>{

		@Override
		public void handle(KeyEvent event) {
			dy = 0;
			dx = 0;
			paint(gc);
		}
		
	}
	
	class ManipuladorKey implements EventHandler<KeyEvent>{

		@Override
		public void handle(KeyEvent event) {
			if (event.getCode() == KeyCode.LEFT) {
				if(x<=0 ||!(y>0 && y< 440)) {
					dx = 0;
					dy= 0;
				} else {
					dx = -velocidade;
				}
		    }

		    if (event.getCode() == KeyCode.RIGHT) {
		    	if(x>=600 ||!(y>0 && y< 440)  ) {
		    		dx = 0;
		    		dy= 0;
				} else {
					dx = velocidade;
				}
		    }

		    if (event.getCode() == KeyCode.UP) {
		    	if(y<=0 ||!(x>0 && x< 600) ) {
		    		dy = 0;
		    		dx = 0;
				} else {
					dy = -velocidade;
				}
		    }

		    if (event.getCode() == KeyCode.DOWN) {
		    	if(y>=440 ||!(x>0 && x< 600)) {
		    		dy = 0;
		    		dx = 0;
				} else {
					dy = velocidade;
				}
		    }
		    move();
			
		}

		
	}
	

	public void move() {
			x +=dx;
			y +=dy;
	        paint(gc);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group grp = new Group();
		Scene scn = new Scene(grp,640,480);
		grp.getChildren().add(canvas);

		canvas.requestFocus();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		EventHandler<KeyEvent> manipulador = new ManipuladorKey();
		EventHandler<KeyEvent> manipuladorRelease = new Manipulador();
		stage.addEventFilter(KeyEvent.KEY_PRESSED,manipulador);
		stage.addEventFilter(KeyEvent.KEY_RELEASED, manipuladorRelease);
		paint(gc);
		
		stage.setScene(scn);
		stage.setTitle("Joguinho");
		stage.show();
	}
	
	private void paint(GraphicsContext gc) {
		gc.setFill(Color.DARKBLUE);
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.setFill(Color.CORAL);
		gc.fillArc(x, y, 40, 40, 0, 360, ArcType.ROUND);
	}
	
	
	public static void main(String[] args) {
		Jogo.launch(args);

	}

}
