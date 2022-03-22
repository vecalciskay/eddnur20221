package src.observer;

import java.beans.PropertyChangeEvent;

public class EstudianteUniversidad implements IInversor {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "VALOR") {
            return;
        }
        int diferencia = (int)evt.getNewValue() - (int)evt.getOldValue();
        analisisInversion(diferencia,
                (int)evt.getNewValue(), (int)evt.getOldValue());
    }

    private void analisisInversion(int diferencia,
                                   int newValue,
                                   int oldValue) {
        if (diferencia > 0) {
            System.out.println("Se sugiere vender");
        } else {
            System.out.println("Se sugiere esperar");
        }
    }

    @Override
    public void metodo() {

    }
}
