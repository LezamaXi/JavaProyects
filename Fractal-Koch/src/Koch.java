import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

public class Koch extends Application {

    private static Canvas can = new Canvas(900,900);
    private static Group root = new Group(can);
    private static GraphicsContext gc = can.getGraphicsContext2D();
   

    private void trazaKoch(Point2D p1, Point2D p2, int n) throws Exception{
	if(n <= 0){
	    gc.setStroke(Color.GREEN);
	    gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	
	else{
	    double dx=(p2.getX() - p1.getX())/3;
	    double dy=(p2.getY() - p1.getY())/3;
	    Point2D tercio1 = new Point2D((2 * p1.getX() + p2.getX()) / 3, (2 * p1.getY() + p2.getY()) / 3);
	    Point2D tercio2 = new Point2D((p1.getX() + 2 * (p2.getX())) / 3, (p1.getY() + 2 * (p2.getY())) / 3);
	    Point2D medio = new Point2D ((p1.getX() + 3 * dx/2.0 - dy * Math.sin(Math.toRadians(60))), (p1.getY() + 3 * dy/2.0 + dx * Math.sin(Math.toRadians(60))));
	    
	    trazaKoch(p1, tercio1, n-1);
	    trazaKoch(tercio1, medio, n-1);
	    trazaKoch(medio, tercio2, n-1);
	    trazaKoch(tercio2, p2, n-1);
	}
    }
    
    @Override
    public void start(Stage primaryStage){
    	try{
			Parameters p = this.getParameters();
			trazaKoch(new Point2D(450, 30.38476),new Point2D(150, 550), Integer.parseInt(p.getRaw().get(0)));
			trazaKoch(new Point2D(750,550),new Point2D(450, 30.38476), Integer.parseInt(p.getRaw().get(0)));
			trazaKoch(new Point2D(150, 550),new Point2D(750, 550), Integer.parseInt(p.getRaw().get(0)));
			Scene parent = new Scene(root, Color.BLACK);
			primaryStage.setScene(parent);
			primaryStage.show();
			primaryStage.setResizable(false);
		}
		catch (IndexOutOfBoundsException e){
        	System.out.println("No ingresaste ningun numero, intentalo de nuevo");
        }
		catch (Exception e){
			System.out.println("No ingresaste ningun numero");
        }

    }
}
