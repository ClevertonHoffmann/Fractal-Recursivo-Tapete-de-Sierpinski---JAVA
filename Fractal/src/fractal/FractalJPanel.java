package fractal;

//import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * FractalJPanel demonstra desenho recursivo de dois fractais
 * @author Cleverton Hoffmann
 */
public class FractalJPanel extends JPanel {

    private Color color; // armazena cor utilizada para desenhar o fractal
    private int level = 5;   // armazena o nível atual do fractal

    private final int WIDTH = 1200;  // define a largura do JPanel
    private final int HEIGHT = 1000; // define a altura do JPanel

    // configura o nível do fractal inicial com o valor especificado
    // e configura as especificações do JPanel
    public FractalJPanel(int currentLevel) {
        color = Color.BLUE;  // inicializa a cor desenho como azul
        level = currentLevel; // configura o nível do fractal inicial
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    } // fim do construtor FractalJPanel                                  

    // desenha o fractal recursivamente
    public void drawFractal1(int level, int xA, int yA, int xB, int yB, Graphics2D g) {
        // caso básico: desenha uma linha conectando dois pontos dados 
        if (level == 0) {
            g.drawLine(xA, yA, xB, yB);//level, 200, 320, 200, 300, g 
            g.drawLine(xA + 20, yA, xA, yA);
            g.drawLine(xA + 20, yA - 20, xA + 20, yA);
            g.drawLine(xB, yB, xA + 20, yA - 20);

        } else { // passo de recursão: determina novos pontos, desenha próximo nível
            drawFractal1( level - 1, xA, yA, xB, yB, g );  
            drawFractal1(level - 1, xA - 20, yA + 20, xB - 20, yB + 20, g);
            drawFractal1(level - 1, xA + 20, yA + 20, xB + 20, yB + 20, g);
            drawFractal1(level - 1, xA - 20, yA - 20, xB - 20, yB - 20, g);
            drawFractal1(level - 1, xA + 20, yA - 20, xB + 20, yB - 20, g);
            drawFractal1(level - 1, xA, yA, xB, yB, g);
        } // fim do else                                              
    } // fim do método drawFractal  

    public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics2D g) {
        // caso básico: desenha o quadrado inicial com um quadrado no meio 
        if (level == 0) {
            g.setColor(Color.BLUE);
            g.fillRect(xA, yA, xB, yB);
           /* g.setColor(Color.BLUE);
            g.drawOval(xA, yA, xB, yB);
            g.setColor(Color.WHITE);
            g.drawOval(xA + (xB) / 3, yA + (yB) / 3, xB / 3, yB / 3); */
        } else if(level == 1){
            g.setColor(Color.BLUE);
            g.fillRect(xA, yA, xB, yB);
            g.setColor(Color.WHITE);
            g.fillRect(xA + (xB) / 3, yA + (yB) / 3, xB / 3, yB / 3);
        } else{
            //Passo de recursão
            drawFractal(level - 1, xA, yA, xB, yB, g);
/*P1*/      drawFractal(level - 1, xA, yA, xB / 3, yB / 3, g);
/*P2*/      drawFractal(level - 1, xA + ((xB) / 3), yA, xB / 3, yB / 3, g);
/*P3*/      drawFractal(level - 1, xA + ((xB) / 3) * 2, yA, xB / 3, yB / 3, g);
/*P4*/      drawFractal(level - 1, xA, yA + ((yB) / 3), xB / 3, yB / 3, g);
/*P5*/      drawFractal(level - 1, xA + ((xB) / 3) * 2, yA + ((yB) / 3), xB / 3, yB / 3, g);
/*P6*/      drawFractal(level - 1, xA, yA + ((yB) / 3) * 2, xB / 3, yB / 3, g);
/*P7*/      drawFractal(level - 1, xA + ((xB) / 3), yA + ((yB) / 3) * 2, xB / 3, yB / 3, g);
/*P8*/      drawFractal(level - 1, xA + ((xB) / 3) * 2, yA + ((yB) / 3) * 2, xB / 3, yB / 3, g);
        } // fim do else                                                
    } // fim do método drawFractal  

    // inicia o desenho de fractal
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // desenha o padrão de fractal
        g.setColor(color);
     //   drawFractal1(level, 400, 320, 400, 300, (Graphics2D) g);
        drawFractal( level, 400,50, 390, 390,(Graphics2D)  g );
    } // fim do método paintComponent

    // configura o novo nível de recursão
    public void setLevel(int currentLevel) {
        level = currentLevel;
    } // fim do método setLevel

    // retorna o nível de recursão
    public int getLevel() {
        return level;
    } // fim do método getLevel 
} // fim da classe FractalJPanel
