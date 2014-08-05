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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author lhries
 */
class Calculadora3 extends JFrame{
    private JLabel labelNumero1, labelNumero2, labelResultado, labelcombo1, labelcombo2, labelcombo3, labelcombo4;
    private JTextField valorEntrada1, valorEntrada2, valorResultado;
    private JButton botaoCalcular, botaoLimpar, botaoSair;
    private JPanel painelBotoes, painelPrincipal, painelNum1, painelNum2, painelRes, painelOperacao;
    private JCheckBoxMenuItem checkBox1, checkBox2, checkBox3, checkBox4;
    
    public Calculadora3() {
        super ("Calculadora");
        
        iniciarComponentesCalc3();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        
    }

    private void iniciarComponentesCalc3() {
        
        // Criando Paineis Internos.
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
         * Operações. Somar, Subtrair, Multiplicar e Dividir.
         */
        painelOperacao = new JPanel();
        
            checkBox1 = new JCheckBoxMenuItem();
            labelcombo1 = new JLabel("Somar");
            checkBox2 = new JCheckBoxMenuItem();
            labelcombo2 = new JLabel("Subtrair");
            checkBox3 = new JCheckBoxMenuItem();
            labelcombo3 = new JLabel("Multiplicar");
            checkBox4 = new JCheckBoxMenuItem();
            labelcombo4 = new JLabel("Dividir");
            painelOperacao.add(checkBox1);
            painelOperacao.add(labelcombo1);
            painelOperacao.add(checkBox2);
            painelOperacao.add(labelcombo2);
            painelOperacao.add(checkBox3);
            painelOperacao.add(labelcombo3);
            painelOperacao.add(checkBox4);
            painelOperacao.add(labelcombo4);
            
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
        botaoSair.addActionListener(new Calculadora3.TratadorBotoes());
        painelBotoes.add(botaoSair);
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
   }
    
    /**
     * 
     *  
     */
    private int verificaMultiplaSelecao(){
    
        int multi=0;
        if(checkBox1.isSelected()&&checkBox2.isSelected()&&checkBox3.isSelected()&&checkBox4.isSelected()){ multi=1;}        
        else if(checkBox1.isSelected()&&checkBox2.isSelected()){ multi=1;}
        else if(checkBox1.isSelected()&&checkBox3.isSelected()){ multi=1;}
        else if(checkBox1.isSelected()&&checkBox4.isSelected()){ multi=1;}
        else if(checkBox2.isSelected()&&checkBox3.isSelected()){ multi=1;}
        else if(checkBox2.isSelected()&&checkBox4.isSelected()){ multi=1;}
        else if(checkBox3.isSelected()&&checkBox4.isSelected()){ multi=1;}
    
        return multi;
    }
    /**
     * 
     * 
     */
    class TratadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(botaoCalcular)){
                if(verificaMultiplaSelecao()==1){
                    JOptionPane.showMessageDialog(null, 
                            "Mais de uma operação está sendo selecionada!",
                            "Erro de Seleção",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(checkBox1.isSelected()){
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
                 else if(checkBox2.isSelected()){
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
                 else if(checkBox3.isSelected()){
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
                 else if(checkBox4.isSelected()){
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
            else if(e.getSource().equals(botaoLimpar)) {
                valorEntrada1.setText("");
                valorEntrada2.setText("");
                valorResultado.setText("");
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
                checkBox4.setSelected(false);
            }
            else if(e.getSource().equals(botaoSair)) {
                dispose();
            }
        }
    }
}