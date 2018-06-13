import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;
/* -------------------------------------------------------------------
 * Sierpinky.java
 * versión 1.0
 * Copyright (C) 2015 Lezama Hernández María Ximena 
 * Facultad de Ciencias,
 * Universidad Nacional Autónoma de México.
 * -------------------------------------------------------------------
 */
public class Sierpinski extends Application{
     /**
     * Programa que cifra y decifra usando la TablaVigenere
     *
     * @author María Ximena Lezama Hernández 
     * @version 1.0<br>
     */
    
    private static Canvas can = new Canvas(900,900);//El lienzo donde trabajaremos
    private static Group root = new Group(can);//El grupo raíz, metemos de una vez el Canvas
    private static GraphicsContext gc = can.getGraphicsContext2D();//Obtenemos el GraphicsContext y lo instanciamos con gc.

      /**
       * Traza el triangulo según el nivel de recusividad.
       * @param p1 Un punto que pertenece a un Triangulo equilatero.
       * @param p2 Un punto que pertenece a un Triangulo equilatero.
       * @param p3 Un punto que pertenece a un Triangulo equilatero.
       * @param n Las veces se que llama recursivamente.
       */
    public static void trazaTriangulo(Point2D p1, Point2D p2, Point2D p3, int n) {
	if(n == 0){
	    gc.setStroke(Color.GREEN);
	    gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	    gc.strokeLine(p2.getX(), p2.getY(), p3.getX(), p3.getY());
	    gc.strokeLine(p3.getX(), p3.getY(), p1.getX(), p1.getY());
	   
	}
	else {
	    Point2D medio1 = new Point2D ((p1.getX() + p2.getX())/2, (p1.getY()
								      + p2.getY())/2);
	    Point2D medio2 = new Point2D ((p2.getX() + p3.getX())/2, (p2.getY()
								      + p3.getY())/2);
	    Point2D medio3 = new Point2D ((p3.getX() + p1.getX())/2, (p3.getY()
								      + p1.getY())/2);
	    //llamas recursivamenete a trazatriangulo
	    trazaTriangulo(p1, medio1, medio3, n-1);
	    trazaTriangulo(medio1, p2, medio2, n-1);
	    trazaTriangulo(medio3, medio2, p3, n-1);
	    
	}
    }
     /**
       * Dibuja el triangulo según el nivel de recusividad.
       * @return una esena con el triangulo dibujado.
       */
    @Override
    public void start(Stage primaryStage){
    	try{
			Parameters p = this.getParameters();
			trazaTriangulo(new Point2D(50,700),new Point2D(850,700), new Point2D(450,7.17968), Integer.parseInt(p.getRaw().get(0)));
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
    
