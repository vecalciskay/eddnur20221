package arbol.arbolaritmetico;

import arbol.Arbol;

public class ArbolAritmetico extends Arbol<ElementoAritmetico> {

    public ArbolAritmetico(String expresion) {
        this.raiz = leerExpresion(expresion, null);
    }

    private Nodo<ElementoAritmetico> leerExpresion(String expresion, Nodo<ElementoAritmetico> padre) {
        int posicionActual = 0;
        String numeroActual = "";
        int conteoParentesis = 0;

        while (posicionActual < expresion.length()) {
            char caracterActual = expresion.charAt(posicionActual);
            if (esNumero(caracterActual)) {
                numeroActual += caracterActual;
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
            Operador posibleOperadorPrincipal = new Operador(String.valueOf(caracterActual));
            if (conteoParentesis == 0) {
                // 0.- Crear el nodo
                Nodo<ElementoAritmetico> resultadoNodo = new Nodo<>(posibleOperadorPrincipal, posicionActual + "");
                resultadoNodo.setPadre(padre);

                // 1.- Crear el nodo de la izquierda
                String izquierdaExpresion = expresion.substring(0, posicionActual);
                Nodo<ElementoAritmetico> izquierdaNodo = leerExpresion(izquierdaExpresion, resultadoNodo);
                resultadoNodo.getHijos().adicionar(izquierdaNodo);

                // 2.- Crear el nodo de la derecha

                String derechaExpresion = expresion.substring(posicionActual + 1);
                Nodo<ElementoAritmetico> derechaNodo = leerExpresion(derechaExpresion, resultadoNodo);
                resultadoNodo.getHijos().adicionar(derechaNodo);

                return resultadoNodo;
            }
        }
        return null;
    }

    private boolean esNumero(char caracterActual) {
        try {
            Integer.parseInt(String.valueOf(caracterActual));
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
