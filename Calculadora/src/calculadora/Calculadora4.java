package calculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lhries
 */
class Calculadora4 extends JFrame{
    private JTextField campoNumeros;
    private String[] textoBotoes = 
            new String[]{"7","8","9","/",
                         "4","5","6","*",
                         "1","2","3","-",
                         " ","0","=","+"};
    private String[] nomeBotoes = 
            new String[]{"Bot7","Bot8","Bot9","BotDivisao",
                         "Bot4","Bot5","Bot6","BotMultiplicao",
                         "Bot1","Bot2","Bot3","BotSubtracao",
                         "BotVazio","Bot0","BotIgual","BotSoma"};    
    private JButton[] botoes = new JButton[16];
    private JPanel painelBotoes;
    

    public Calculadora4() {
        super("Calculadora");
        iniciarComponentesCalc4();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
    }

    private void iniciarComponentesCalc4() {
        
        campoNumeros = new JTextField();
        this.getContentPane().add(campoNumeros,BorderLayout.NORTH);
        
        painelBotoes = new JPanel(new GridLayout(4,4));
        
        for(int i=0;i<16;i++){
            botoes[i] = new JButton(textoBotoes[i]);
            botoes[i].setName(nomeBotoes[i]);
            painelBotoes.add(botoes[i]);
        }
        botoes[12].setEnabled(false);
        
        this.getContentPane().add(painelBotoes); 
    }
  
}
