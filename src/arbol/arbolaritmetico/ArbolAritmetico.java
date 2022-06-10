package arbol.arbolaritmetico;

import arbol.Arbol;

public class ArbolAritmetico extends Arbol<ElementoAritmetico> {

    public ArbolAritmetico(String expresion) throws Exception {
        this.raiz = leerExpresion(expresion, null);
    }

    private Nodo<ElementoAritmetico> leerExpresion(String expresionSucia, Nodo<ElementoAritmetico> padre) throws Exception {
        String expresion = expresionSucia.trim();
        int posicionActual = 0;
        int conteoParentesis = 0;

        try {
            double posibleNumero = Double.parseDouble(expresion);
            Nodo<ElementoAritmetico> resultadoNodo = new Nodo<>(new Numero(posibleNumero), posibleNumero + "");
            resultadoNodo.setPadre(padre);
            return resultadoNodo;
        } catch (Exception ignored) {
            // Nada
        }

        while (posicionActual < expresion.length()) {
            char caracterActual = expresion.charAt(posicionActual);
            if (caracterActual == ' ' || caracterActual == '\t') {
                posicionActual++;
                continue;
            }
            if (esNumero(caracterActual)) {
                posicionActual++;
                continue;
            }
            if (caracterActual == '(') {
                conteoParentesis++;
                posicionActual++;
                continue;
            }
            if (caracterActual == ')') {
                conteoParentesis--;
                posicionActual++;
                continue;
            }
            try {
                Operador posibleOperadorPrincipal = new Operador(String.valueOf(caracterActual));
                if (conteoParentesis == 0) {
                    // 0.- Crear el nodo
                    Nodo<ElementoAritmetico> resultadoNodo = new Nodo<>(posibleOperadorPrincipal, caracterActual + "");
                    resultadoNodo.setPadre(padre);

                    // 1.- Crear el nodo de la izquierda
                    String izquierdaExpresion = expresion.substring(0, posicionActual);
                    leerExpresion(izquierdaExpresion, resultadoNodo);

                    // 2.- Crear el nodo de la derecha

                    String derechaExpresion = expresion.substring(posicionActual + 1);
                    leerExpresion(derechaExpresion, resultadoNodo);

                    return resultadoNodo;
                } else {
                    posicionActual++;
                    continue;
                }
            } catch (Exception ex) {
                posicionActual++;
                continue;
            }
        }
        if (expresion.startsWith("(") && expresion.endsWith(")") && conteoParentesis == 0)
            return leerExpresion(expresion.substring(1, expresion.length() - 1), padre);
        throw new Exception("No se pudo leer la expresion");
    }

    private boolean esNumero(char caracterActual) {
        if (caracterActual == '.' || caracterActual == ',') {
            return true;
        }
        try {
            Integer.parseInt(String.valueOf(caracterActual));
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public double evaluar() {
        return evaluarNodo(raiz);
    }

    private double evaluarNodo(Nodo<ElementoAritmetico> nodo) {
        if(nodo.getContenido() instanceof Numero){
            return ((Numero) nodo.getContenido()).getValor();
        }
        double resultado = evaluarNodo(nodo.getHijos().obtener(0));

        Operador operacion = (Operador) nodo.getContenido();

        double resActual = evaluarNodo(nodo.getHijos().obtener(1));
        switch (operacion.getSimbolo()) {
            case "+" -> resultado += resActual;
            case "-" -> resultado -= resActual;
            case "/" -> resultado /= resActual;
            case "*" -> resultado *= resActual;
        }
        return resultado;
    }
}
