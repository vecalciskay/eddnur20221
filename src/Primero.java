import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Primero {

    private Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) {
        System.out.println("Hola");

        Primero p = new Primero();
        p.m1();
    }

    private void m1() {
        System.out.println("Metodo m1");
        logger.error("Aqui va un error");
        logger.info("Aqui va un info");
        logger.debug("Aqui va un debug");
    }
}