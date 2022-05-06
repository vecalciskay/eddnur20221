package paint.modelo;

public class BordesKernel extends src.paint.modelo.Transformacion {

    public BordesKernel(src.paint.modelo.Imagen img) {
        this.imagen = img;
    }

    private final int[][] mascara = {{1,2,1},{0,0,0},{-1,-2,-1}};

    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        int[][] suavizados = new int[imagen.getAncho()][imagen.getAlto()];
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {

                int n = aplicarMascara(pixeles, i, j);
                suavizados[i][j] = n;
            }
        }
        imagen.setPixeles(suavizados);

        imagen.transformada();
    }

    private int aplicarMascara(int[][] pixeles, int i, int j) {

        int[][] mascaraPixeles = new int[3][3];
        int resultado = pixeles[i][j];

        int a = (resultado & 0xff000000);

        if (i > 0 && i < (imagen.getAncho() - 1) &&
                j > 0 && j < (imagen.getAlto() - 1)) {
            mascaraPixeles[0][0] = pixeles[i-1][j-1];
            mascaraPixeles[0][1] = pixeles[i-1][j];
            mascaraPixeles[0][2] = pixeles[i-1][j+1];
            mascaraPixeles[1][0] = pixeles[i][j-1];
            mascaraPixeles[1][1] = pixeles[i][j];
            mascaraPixeles[1][2] = pixeles[i][j+1];
            mascaraPixeles[2][0] = pixeles[i+1][j-1];
            mascaraPixeles[2][1] = pixeles[i+1][j];
            mascaraPixeles[2][2] = pixeles[i+1][j+1];

            int sumaProdR = 0;
            int sumaProdG = 0;
            int sumaProdB = 0;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    sumaProdR += multiplicarR(mascaraPixeles[x][y],mascara[x][y]);
                    sumaProdG += multiplicarG(mascaraPixeles[x][y],mascara[x][y]);
                    sumaProdB += multiplicarB(mascaraPixeles[x][y],mascara[x][y]);
                }
            }

            resultado = a | (sumaProdR << 16) | (sumaProdG << 8) | (sumaProdB);
        }

        return resultado;
    }

    private int multiplicarR(int colorInt, int multiplicador) {
        int r = (colorInt & 0x00ff0000) >> 16;
        return r * multiplicador;
    }
    private int multiplicarG(int colorInt, int multiplicador) {
        int g = (colorInt & 0x0000ff00) >> 8;
        return g * multiplicador;
    }
    private int multiplicarB(int colorInt, int multiplicador) {
        int b = (colorInt & 0x000000ff);
        return b * multiplicador;
    }
}
