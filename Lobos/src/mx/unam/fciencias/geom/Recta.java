package geom;
import geom.Vector2D;
/*
  Recta.java
*/
/**
 * Clase para modelar rectas en el plano euclidiano.
 *
 * @author Ximena Lezama Hernández
 * @version 1.0 <br>
 */

public class Recta {

   /**
    * El coeficiente de la variable independiente (x).
    */
   double  A;

   /**
    * El coeficiente de la variable dependiente (y).
    */
   double  B;

   /**
    * El término independiente.
    */
   double  C;

   /**
    * Construye una recta nula.
    */
   public Recta() {
      A = B = C = 0.0;
   }

   /**
    * Construye una recta dados los coeficientes A,
    * B y C de la ecuación general: Ax + By + C = 0.
    * @param cx coeficiente de x.
    * @param cy coeficiente de y.
    * @param ti término independiente.
    */
   public Recta(double cx, double cy, double ti) {
      A = cx;
      B = cy;
      C = ti;
   }

   /**
    * Construye una recta dadas su pendiente y ordenada al origen.
    * @param m es la pendiente de la recta.
    * @param b es la ordenada al origen de la recta.
    */
   public Recta(double m, double b) {
      A = m;
      B = -1;
      C = b;
   }

   /**
    * Construye una recta dados dos puntos por los que pasa.
    * @param p1 primer punto por el que pasa la recta.
    * @param p2 segundo punto por el que pasa la recta.
    */
   public Recta(Vector2D p1, Vector2D p2) {
      double m = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
      double b = p1.getY() - m * p1.getX();
      A = m;
      B = -1;
      C = b;
   }

   /**
    * Construye una recta dado un punto por el que pasa y su
    * pendiente.
    * @param p punto por el que pasa la recta.
    * @param m pendiente de la recta.
    */
    
    //hACER ESTO TAMBIEN    
   public Recta(Vector2D p, double m) {
    A = -m;
    B = 1;
    C = m*p.getX() - p.getY();
   
   }

   /**
    * Extrae el coeficiente del término con <i>x</i>.
    * @return A en la expresión A x + B y + C = 0.
    */
   public double getCoefX() {
      return A;
   }

   /**
    * Extrae el coeficiente del término con <i>y</i>.
    * @return B en la expresión A x + B y + C = 0.
    */
   public double getCoefY() {
      return B;
   }

   /**
    * Extrae el coeficiente del término independiente.
    * @return C en la expresión A x + B y + C = 0.
    */
   public double getIndep() {
      return C;
   }

   /**
    * Calcula la pendiente de la recta.
    * @return pendiente de la recta
    */
   public double  pendiente() {
      return (-A / B);
   }

   /**
    * Calcula la ordenada de la recta en su intersección
    * con el eje <i>Y</i>.
    * @return La ordenada al origen de la recta
    */
   public double ordenada() {
      return (-C / B);
   }

   /**
    * Calcula la intersección de dos rectas. La segunda
    * recta es el parámetro.
    * @param r2 La segunda recta a intersectar, la primera es la
    * instancia que llama al  método.
    * @return El Vector2D donde las dos rectas
    * se cortan
    */
    
   public Vector2D interseccionCon(Recta r2) {
     double x = (this.getCoefY() * r2.getIndep() - this.getIndep() * r2.getCoefY()) / 
                (r2.getCoefY() * this.getCoefX() - this.getCoefY() * r2.getCoefX());
     double y = (this.getCoefX() * r2.getIndep() - this.getIndep() * r2.getCoefX()) / 
                (r2.getCoefX() * this.getCoefY() - this.getCoefX() * r2.getCoefY());
     return new Vector2D(x, y);
   }

   /**
    * Calcula la intersección de dos rectas.
    * @param r1 La primera recta a intersectar.
    * @param r2 La segunda recta a intersectar.
    * @return El Vector2D donde las dos rectas
    * se cortan
    */
   public static Vector2D intersecta(Recta r1, Recta r2) {
     
      return r1.interseccionCon(r2);
   }
   
   
} // fin de Recta.java
