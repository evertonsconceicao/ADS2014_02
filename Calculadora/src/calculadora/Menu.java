/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadora;

import calculadora.Calculadora;
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
 * 
 */
public class Menu extends JFrame{
    
    /**
     * 
     * 
     */
    private JButton calc1, calc2, calc3, calc4, sair;
    private JPanel menuCalc, painelBotoesMenu, painelBotaoSair;

    /**
     * Construtor do Menu.
     * 
     */
    public Menu() {
        super ("Calculadora");
        
        iniciaComponetesMenu();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true); 
    }
    
    /**
     * 
     * 
     */
    public void iniciaComponetesMenu(){
        
        menuCalc = new JPanel();
        menuCalc.setLayout(new GridLayout());

        getContentPane().add(menuCalc);
        
        //Painel de botões.
        painelBotoesMenu = new JPanel();
        painelBotaoSair = new JPanel();
        
        calc1 = new JButton("Calculadora1");
        painelBotoesMenu.add(calc1);
        calc1.addActionListener(new Menu.TrataBotoesMenu());
        
        
        calc2 = new JButton("Calculadora2");
        calc2.addActionListener(new Menu.TrataBotoesMenu());
        painelBotoesMenu.add(calc2);

        calc3 = new JButton("Calculadora3");
        calc3.addActionListener(new Menu.TrataBotoesMenu());
        painelBotoesMenu.add(calc3);
        
        calc4 = new JButton("Calculadora4");
        calc4.addActionListener(new Menu.TrataBotoesMenu());
        painelBotoesMenu.add(calc4);
               
        sair = new JButton("Sair");
        sair.addActionListener(new Menu.TrataBotoesMenu());
        painelBotaoSair.add(sair);
        
        getContentPane().add(painelBotoesMenu, BorderLayout.CENTER);        
        getContentPane().add(painelBotaoSair, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
        
    }//fim_inicia_componentes_menu

    /**
     * 
     * 
     */
    
        class TrataBotoesMenu implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource().equals(calc1)){
                        try{
                            //JOptionPane.showMessageDialog(null, "# Foi chamada a Calculadora 1 #");
                            new Calculadora1();
                        }catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, 
                                    "Campos Numero1 e Numero2 devem ser números inteiros",
                                    "Erro de Formato",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }//fim_else_if_calc1
                    //##############
                    else if(e.getSource().equals(calc2)){
                        try{
                            //JOptionPane.showMessageDialog(null, "# Foi chamada a Calculadora 2 #");
                            new Calculadora2();
                        }catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, 
                                    "Campos Numero1 e Numero2 devem ser números inteiros",
                                    "Erro de Formato",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }//fim_else_if_calc2
                    //##############
                    else if(e.getSource().equals(calc3)){
                        try{
                            //JOptionPane.showMessageDialog(null, "# Foi chamada a Calculadora 3 #");
                            new Calculadora3();
                        }catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, 
                                    "Campos Numero1 e Numero2 devem ser números inteiros",
                                    "Erro de Formato",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }//fim_else_if_calc3
                    //##############
                    else if(e.getSource().equals(calc4)){
                        try{
                            //JOptionPane.showMessageDialog(null, "# Foi chamada a Calculadora 4 #");
                            new Calculadora4();
                        }catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, 
                                    "Campos Numero1 e Numero2 devem ser números inteiros",
                                    "Erro de Formato",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }//fim_else_if_calc4
                    else if(e.getSource().equals(sair)){
                        System.exit(1);
                    }//fim_else_if_sair
                }//fim_action_performed.
    }//fim_trata_botoes_menu
}//fim_menu