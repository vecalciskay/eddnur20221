import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Esta es una clase de ejemplo
 * ES <b>importante</b> que se haga bien
 * <ul>
 *     <li>La primera cosa</li>
 * </ul>
 */
public class Primero {

    private Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) throws Exception {
        System.out.println("Hola");

        Primero p = new Primero();
        p.m1();

        System.out.println( "La suma de los primeros 10 numeros es " + p.suma(10));
    }

    /**
     * Este metodo se encarga de sumar
     * @param n el numero natural tope
     * @return la suma de los primeros n numeros naturales
     * @throws Exception
     */
    public int suma(int n) throws Exception {
        if(n <= 0) {
            throw new Exception("Suma necesita un numero mayor a 0");
        }
        int r = 0;
        for (int i=0; i<=n; i++) {
            r += i;
        }
        return r;
    }
    private void m1() {
        System.out.println("Metodo m1");
        logger.error("Aqui va un error");
        logger.info("Aqui va un info");
        logger.debug("Aqui va un debug");
    }

}