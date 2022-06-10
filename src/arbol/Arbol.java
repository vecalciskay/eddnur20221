package arbol;

import listas.Lista;

import java.awt.*;

public class Arbol<E> {
    protected Nodo<E> raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(E o, String id, String idPadre) {
        Nodo<E> nuevo = new Nodo<>(o, id);

        if (raiz == null && idPadre == null) {
            raiz = nuevo;
            return;
        }
        Nodo<E> aux = buscar(idPadre);
        aux.getHijos().adicionar(nuevo);
    }

    public Nodo<E> buscar(String id) {
        return raiz.encontrar(id);
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "[VACIO]";
        }
        return raiz.toString();
    }

    public void dibujar(Graphics g, int anchoTotal, int altoTotal) {

        raiz.dibujar(g, anchoTotal, 0, 10);

    }


    public static class Nodo<E> {
        private String id;
        private E contenido;
        private Lista<Nodo<E>> hijos;
        public static final int ANCHO_NODO = 50;

        public Nodo(E c, String id) {
            this.hijos = new Lista<>();
            this.contenido = c;
            this.id = id;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setHijos(Lista<Nodo<E>> hijos) {
            this.hijos = hijos;
        }

        public Lista<Nodo<E>> getHijos() {
            return hijos;
        }

        @Override
        public String toString() {
            StringBuilder resultado = new StringBuilder();
            resultado.append(id);
            if (hijos.tamano() == 0) {
                return resultado.toString();
            }

            resultado.append("(");
            String separador = "";
            for (Nodo<E> hijo :
                    hijos) {
                resultado.append(separador);
                resultado.append(hijo.toString());
                separador = ",";
            }

            resultado.append(")");

            return resultado.toString();
        }

        public Nodo<E> encontrar(String id) {
            if (this.id.equalsIgnoreCase(id)) {
                return this;
            }
            for (Nodo<E> hijo :
                    hijos) {
                Nodo<E> encontrado = hijo.encontrar(id);
                if (encontrado != null) {
                    return encontrado;
                }
            }
            return null;
        }

        public void dibujar(Graphics g, int anchoTotal, int xActual, int yActual) {
            int mitad = anchoTotal / 2;
            int padding = 18;
            g.drawOval(
                    xActual + mitad - ANCHO_NODO / 2,
                    yActual,
                    ANCHO_NODO,
                    ANCHO_NODO
            );
            g.drawString(
                    contenido.toString(),
                    xActual + mitad - (ANCHO_NODO / 2) + padding,
                    yActual + ANCHO_NODO / 2
            );
            for (int i = 0; i < hijos.tamano(); i++) {
                Nodo<E> hijo = hijos.obtener(i);
                int xActualHijo = xActual + (anchoTotal / hijos.tamano()) * i;
                int anchoTotalHijo = anchoTotal / hijos.tamano();
                int yActualHijo = yActual + ANCHO_NODO * 2;
                hijo.dibujar(
                        g,
                        anchoTotalHijo,
                        xActualHijo,
                        yActualHijo
                );
                g.drawLine(
                        xActual + mitad,
                        yActual + ANCHO_NODO,
                        xActualHijo + anchoTotalHijo / 2,
                        yActualHijo
                );
            }
        }

        public void setPadre(Nodo<E> padre) {
            if (padre == null) {
                return;
            }
            for (Nodo<E> hijo :
                    padre.hijos) {
                if (hijo.equals(this)) {
                    return;
                }
            }
            padre.getHijos().adicionar(this);
        }
    }
}
