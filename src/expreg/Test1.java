package expreg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
        String[] tests1 = {"7","h","4","dfg","67"};

        String expreg = "^[0-9]{1}$";

        for (int i = 0; i < tests1.length; i++) {
            if (tests1[i].matches(expreg))
                System.out.println("Es numero: " + tests1[i]);
            else
                System.out.println("es cualquier cosa: " + tests1[i]);
        }

        expreg= "^([A-Za-z])([A-Za-z]+)\s+([A-Za-z])([A-Za-z]+)$";

        String[] tests2 = {"Hugo Suarez",
                "daniel martinez",
                "X M",
                "Nkdi93            Nhuga1",
                "JaViEr         MiRaleS",
                "Maria                 Gonzales",
                "asdlkflk",
                "Jose Maria Perez"};

        for (int i = 0; i < tests2.length; i++) {
            // Create a Pattern object
            Pattern r = Pattern.compile(expreg);

            // Now create matcher object.
            Matcher m = r.matcher(tests2[i]);

            if (m.find()) {
                String resultado = m.group(1).toUpperCase() + m.group(2).toLowerCase() + " " +
                        m.group(3).toUpperCase() + m.group(4).toLowerCase();
                System.out.println("Nombre y Apellido: " + resultado);
            } else {
                System.out.println("NO MATCH: " + tests2[i]);
            }
        }
    }
}
