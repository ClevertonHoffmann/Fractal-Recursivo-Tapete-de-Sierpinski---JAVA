package fractal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Demonstra a interface com o usuário para desenhar um fractal.
 * @author Cleverton Hoffmann
 */
public class Fractal extends JFrame{
   private final int WIDTH = 1000;  // define a largura de GUI
   private final int HEIGHT = 600; // define a altura de GUI
   private final int MIN_LEVEL = 0, MAX_LEVEL = 20;
   private Color color = Color.BLUE;

   private JButton increaseLevelJButton, decreaseLevelJButton;
   private JLabel levelJLabel;
   private FractalJPanel drawSpace;
   private JPanel mainJPanel, controlJPanel;

   // configura a GUI
   public Fractal(){
      super( "Fractal" );

      // configura o painel de controle
      controlJPanel = new JPanel();
      controlJPanel.setLayout( new FlowLayout() );

      // configura o botão decrease level para adicionar no controlJPanel
      // ouvinte registrado
      decreaseLevelJButton = new JButton( "Decrease Level" );
      controlJPanel.add( decreaseLevelJButton );
      decreaseLevelJButton.addActionListener(
         new ActionListener(){ // classe interna anônima
            // processa o evento decreaseLevelJButton 
            public void actionPerformed( ActionEvent event ){
               int level = drawSpace.getLevel();
               level--; // diminui o nível por um

               // modifica o nível se possível
               if (( level >= MIN_LEVEL ) && ( level <= MAX_LEVEL )){
                  levelJLabel.setText( "Level: " + level );
                  drawSpace.setLevel( level );             
                  repaint();                               
               } // fim do if
            } // fim do método actionPerformed
         } // fim da classe interna anônima
      ); // fim de addActionListener 

      // configura o botão increase level para adicionar no controlJPanel
      // e registra o ouvinte 
      increaseLevelJButton = new JButton( "Increase Level" );
      controlJPanel.add( increaseLevelJButton );
      increaseLevelJButton.addActionListener(
         new ActionListener(){ // classe interna anônima
            // processa evento increaseLevelJButton 
            public void actionPerformed( ActionEvent event ){
               int level = drawSpace.getLevel();
               level++; // aumenta nível por um

               // modifica o nível se possível
               if (( level >= MIN_LEVEL ) && ( level <= MAX_LEVEL )){
                  levelJLabel.setText( "Level: " + level );
                  drawSpace.setLevel( level );             
                  repaint();                               
               } // fim do if
            } // fim do método actionPerformed
         } // fim da classe interna anônima
      ); // fim de addActionListener 

      // configura levelJLabel para adicionar ao controlJPanel
      levelJLabel = new JLabel( "Level: 0" );
      controlJPanel.add( levelJLabel );

      drawSpace = new FractalJPanel( 0 );
 
      // cria mainJPanel para conter controlJPanel e drawSpace
      mainJPanel = new JPanel();
      mainJPanel.add( controlJPanel );
      mainJPanel.add( drawSpace );

      add( mainJPanel ); // adiciona JPanel ao JFrame

      setSize( WIDTH, HEIGHT ); // configura o tamanho de JFrame
      setLocationRelativeTo(null);
      setVisible( true ); // exibe JFrame 
   } // fim do construtor Fractal

   public static void main( String args[] ){
      Fractal demo = new Fractal();
      demo.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   } // fim de main
} // fim da classe Fractal 

