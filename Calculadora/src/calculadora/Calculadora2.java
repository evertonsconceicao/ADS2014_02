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
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lhries
 */
class Calculadora2 extends JFrame{
    
    private JLabel labelNumero1, labelNumero2, labelResultado, labelcombo;
    private JTextField valorEntrada1, valorEntrada2, valorResultado;
    private JButton botaoCalcular, botaoLimpar, botaoSair;
    private JPanel painelBotoes, painelPrincipal, painelNum1, painelNum2, painelRes, painelOperacao;
    private JComboBox combo;
    
    /**
     * Construtor.
     */
    public Calculadora2() {
        super ("Calculadora");
        
        iniciarComponentesCalc2();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        
    }
    /**
     * 
     * Criação dos Painéis e Botões.
     * 
     */
    private void iniciarComponentesCalc2() {
        
        /**
         * Painel Entrada de valores.
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
         * Operações. Somar, Subtrair, Multiplicar e Dividir.
         */
        painelOperacao = new JPanel();
            combo = new JComboBox();
            labelcombo = new JLabel("Operação");
            painelOperacao.add(labelcombo);
            painelOperacao.add(combo);
            combo.addItem("SOMAR");
            combo.addItem("SUBTRAIR");  
            combo.addItem("MULTIPLICAR");
            combo.addItem("DIVIDIR");
            
            getContentPane().add(painelOperacao, BorderLayout.CENTER);
        
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
        
         /**
          * Criando Painel Principal
          */
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(4,1));
        
        painelPrincipal.add(painelNum1);
        painelPrincipal.add(painelNum2);
        painelPrincipal.add(painelOperacao);
        painelPrincipal.add(painelRes);

        getContentPane().add(painelPrincipal);
        
        //Painel de botões.
        painelBotoes = new JPanel();
        botaoCalcular = new JButton("Calcular");
        botaoCalcular.addActionListener(new TratadorBotoes());
        painelBotoes.add(botaoCalcular);
        botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(new TratadorBotoes());
        painelBotoes.add(botaoLimpar);
        botaoSair = new JButton("Sair");
        botaoSair.addActionListener(new Calculadora2.TratadorBotoes());
        painelBotoes.add(botaoSair);
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
   }
    
    /**
     * 
     * 
     */
    class TratadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(botaoCalcular)){
                 if(combo.getSelectedItem()=="SOMAR"){
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
                }//fim_if_somar.
                 else if(combo.getSelectedItem()=="SUBTRAIR"){
                     try{
                        int num1 = Integer.parseInt(valorEntrada1.getText());
                        int num2 = Integer.parseInt(valorEntrada2.getText());
                        int resultado = num1-num2;
                        valorResultado.setText(String.valueOf(resultado));                
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, 
                            "Campos Numero1 e Numero2 devem ser números inteiros",
                            "Erro de Formato",
                            JOptionPane.ERROR_MESSAGE);
                }
                }//fim_if_subtrair.
                 else if(combo.getSelectedItem()=="MULTIPLICAR"){
                     try{
                        int num1 = Integer.parseInt(valorEntrada1.getText());
                        int num2 = Integer.parseInt(valorEntrada2.getText());
                        int resultado = num1*num2;
                        valorResultado.setText(String.valueOf(resultado));                
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, 
                            "Campos Numero1 e Numero2 devem ser números inteiros",
                            "Erro de Formato",
                            JOptionPane.ERROR_MESSAGE);
                }
                }//fim_if_multiplicar.
                 else if(combo.getSelectedItem()=="DIVIDIR"){
                     try{
                        int num1 = Integer.parseInt(valorEntrada1.getText());
                        int num2 = Integer.parseInt(valorEntrada2.getText());
                        int resultado = num1/num2;
                        valorResultado.setText(String.valueOf(resultado));                
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, 
                            "Campos Numero1 e Numero2 devem ser números inteiros",
                            "Erro de Formato",
                            JOptionPane.ERROR_MESSAGE);
                }
                }//fim_if_dividir.
            }//fim_botao_calcular.
            /**
             * Realiza a limpeza de todos os campos da calculadora.
             */
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