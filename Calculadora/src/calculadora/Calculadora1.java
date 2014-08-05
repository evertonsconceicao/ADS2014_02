/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lhries
 */
class Calculadora1 extends JFrame{
    private JLabel labelNumero1, labelNumero2, labelResultado;
    private JTextField valorEntrada1, valorEntrada2, valorResultado;
    private JButton botaoSomar, botaoLimpar, botaoSair;
    private JPanel painelBotoes, painelPrincipal, painelNum1, painelNum2, painelRes;
    
    public Calculadora1() {
        super ("Calculadora");
        
        iniciarComponentesCalc1();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        
    }

    /**
     * 
     * Criação dos Painéis e Botões.
     * 
     */
    private void iniciarComponentesCalc1() {
        
        /**
         * Entrada de valores.
         */
        painelNum1 = new JPanel();
            labelNumero1 = new JLabel("Numero1:");
        painelNum1.add(labelNumero1);
            valorEntrada1 = new JTextField(10);
        painelNum1.add(valorEntrada1);
        
        painelNum2 = new JPanel();
            labelNumero2 = new JLabel("Numero2:");
        painelNum2.add(labelNumero2);
            valorEntrada2 = new JTextField(10);
        painelNum2.add(valorEntrada2);
        /**
         * Resposta.
         */
        painelRes = new JPanel();
            labelResultado = new JLabel("Resultado:");
        painelRes.add(labelResultado);
            valorResultado = new JTextField(10);
        /**
         * SetEditable=False  - Desativa a opção de edição do campo "Resultado". 
         */
            valorResultado.setEditable(false);        
        painelRes.add(valorResultado);
        
//        Painel de botões.
        painelBotoes = new JPanel();
        botaoSomar = new JButton("Somar");
        botaoSomar.addActionListener(new TratadorBotoes());
        painelBotoes.add(botaoSomar);
        botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(new TratadorBotoes());
        painelBotoes.add(botaoLimpar);
        botaoSair = new JButton("Sair");
        botaoSair.addActionListener(new TratadorBotoes());
        painelBotoes.add(botaoSair);
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
        
//        Criando Painel Principal
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(3,1));
        
        painelPrincipal.add(painelNum1);
        painelPrincipal.add(painelNum2);
        painelPrincipal.add(painelRes);
        
        getContentPane().add(painelPrincipal);
   }
   
    class TratadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(botaoSomar)){
                try{
                    int num1 = Integer.parseInt(valorEntrada1.getText());
                    int num2 = Integer.parseInt(valorEntrada2.getText());
                    int resultado = num1+num2;
                    valorResultado.setText(String.valueOf(resultado));                
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, 
                            "Campos Numero1 e Numero2 devem ser números inteiros",
                            "Erro de Formato",
                            JOptionPane.ERROR_MESSAGE);
                }
                    
            }
            else if(e.getSource().equals(botaoLimpar))
            {
                valorEntrada1.setText("");
                valorEntrada2.setText("");
                valorResultado.setText("");
            }
            else if(e.getSource().equals(botaoSair))
            {
                dispose();
            }
        }
    }
}