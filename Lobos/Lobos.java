/* -------------------------------------------------------------------
 * Lobos.java
 * versión 1.0
 * Copyright (C) 2004  José Galaviz Casas,
 * Facultad de Ciencias,
 * Universidad Nacional Autónoma de México, Mexico.
 *
 * Este programa es software libre; se puede redistribuir
 * y/o modificar en los términos establecidos por la
 * Licencia Pública General de GNU tal como fue publicada
 * por la Free Software Foundation en la versión 2 o
 * superior. 
 *
 * Este programa es distribuido con la esperanza de que
 * resulte de utilidad, pero SIN GARANTÍA ALGUNA; de hecho
 * sin la garantía implícita de COMERCIALIZACIÓN o
 * ADECUACIÓN PARA PROPÓSITOS PARTICULARES. Véase la
 * Licencia Pública General de GNU para mayores detalles.
 *
 * Con este programa se debe haber recibido una copia de la
 * Licencia Pública General de GNU, de no ser así, visite el
 * siguiente URL:
 * http://www.gnu.org/licenses/gpl.html
 * o escriba a la Free Software Foundation Inc.,
 * 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * -------------------------------------------------------------------
 */


import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Programa para resolver el problema de la manada de lobos.
 *
 * @since 
 * @author Jos&eacute; Galaviz jgc@fciencias.unam.mx
 * @version 1.0<br>
 * marzo 2007
 */
public class Lobos {

   /**
    * Despliega mensaje de uso del programa.
    */
   public static void msgUso() {
      System.out.println("Uso: java Lobos <X1> <Y1> <X2> <Y2> <archivo_tel>");
      System.out.print("(X1, Y1) ");
      System.out.println("son las coordenadas de la estación de telemetría 1");
      System.out.print("(X2, Y2) ");
      System.out.println("son las coordenadas de la estación de telemetría 2");
      System.out.println("<archivo_tel> es el archivo con los ángulos");
   }

   /**
    * Entrega los dos valores de los ángulos contenidos en
    * la linea del archivo de datos de telemetría.
    * @param renglon contiene la línea leida del archivo.
    * @return un arreglo de dos entradas conteniendo los
    * valores de los ángulos leidos.
    * @throws NumberFormatException si falla parseDouble.
    */
   public static double[] angulos(String renglon)
   throws NumberFormatException {
      if (renglon != null) {
         double[] ang = new double[2];
         StringTokenizer st = new StringTokenizer(renglon);
         ang[0] = Double.parseDouble(st.nextToken());
         ang[1] = Double.parseDouble(st.nextToken());
         return ang;
      }
      else {
         return null;
      }
   }

   /**
    * Regresa el máximo de los valores pasados como
    * parámetros. Los argumentos (dos double) son comparados
    * para regresarl el valor de aquel que resulte mayor.
    * @param n1 primer argumento.
    * @param n2 segundo argumento.
    * @return el mayor de los dos argumentos.
    */
   public static double maximo(double n1, double n2) {
      return (n1 > n2) ? n1 : n2;
   }
   
   /**
    * Regresa el mínimo de los valores pasados como
    * parámetros. Los argumentos (dos double) son comparados
    * para regresarl el valor de aquel que resulte menor.
    * @param n1 primer argumento.
    * @param n2 segundo argumento.
    * @return el menor de los dos argumentos.
    */
   public static double minimo(double n1, double n2) {
      return (n1 < n2) ? n1 : n2;
   }
   
   /**
    * Programa principal.
    * @param args deben  ser las coordenadas de las dos estaciones de
    * telemetría y el nombre del archivo con los angulos.
    */
   public static void main(String[] args) {
      if (args.length != 5) {
         msgUso();
      }
      else {
         try {
            BufferedReader lector = new BufferedReader(new FileReader(args[4]));
            String linea = null;
            double[] angus;
            Vector2D e1, e2, inter;
            Recta    r1, r2;
            double   maxx = 0,
                     maxy = 0,
                     minx = 0,
                     miny = 0,
                     x, y;
            int      i;
            
            e1 = new Vector2D(Double.parseDouble(args[0]),
                              Double.parseDouble(args[1]));
            e2 = new Vector2D(Double.parseDouble(args[2]),
                              Double.parseDouble(args[3]));
            i = 0;
            do {
               linea  = lector.readLine();
               angus  = angulos(linea);
               if (angus != null) {
                  i++;
                  r1 = new Recta(e1, Math.tan(angus[0]));
                  r2 = new Recta(e2, Math.tan(angus[1]));
                  inter = r1.interseccionCon(r2);
                  System.out.println(inter);
                  // si es la primera vez, aún no tenemos
                  // datos con los cuales comparar
                  if (i == 1) {
                     maxx = minx = inter.getX();
                     maxy = miny = inter.getY();
                  }
                  else {
                     x = inter.getX();
                     y = inter.getY();
                     maxx = maximo(maxx, x);
                     minx = minimo(minx, x);
                     maxy = maximo(maxy, y);
                     miny = minimo(miny, y);
                  }
               }   
            } while (linea != null);
            System.err.println("Máxima X: " + maxx);
            System.err.println("Mínima X: " + minx);
            System.err.println("Máxima Y: " + maxy);
            System.err.println("Mínima Y: " + miny);
            System.err.println("Número de coordenadas: " + i);
         }
         // por si falla la lectura de datos numéricos del archivo
         catch (NumberFormatException nfe) {
            msgUso();
         }
         // por si falla la apertura/lectura del archivo
         catch (IOException ioe) {
            // imprime la ruta de ejecución completa
            ioe.printStackTrace();
            // y el mensaje de la excepción
            System.out.println(ioe.getMessage());
         }
      }
   }
} // Fin de Lobos.java 
