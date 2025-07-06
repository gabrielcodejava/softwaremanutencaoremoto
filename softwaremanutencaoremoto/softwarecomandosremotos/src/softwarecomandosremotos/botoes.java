package softwarecomandosremotos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class botoes {

    public static JPanel criarPainelDeBotoes(JFrame framePai) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

// Botão "Servidor Homologacao"
        JButton btnServidorHomologacao = new JButton("Servidor Homologacao 01");
        btnServidorHomologacao.setBounds(120,200,250,30); // x=Largura(Posicao), y=altura(Posicao), largura=Botao, altura=Botao
        btnServidorHomologacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	metodosubjanela.abrirDialog(framePai, "Servidor Homologacao 01", "Servidor Homologação 01 - Detalhes","homologacao01");
            	
            }
        });
        panel.add(btnServidorHomologacao);
        
// Botão "Servidor Homologacao02"
        JButton btnServidorHomologacao02 = new JButton("Servidor Homologacao 02");
        btnServidorHomologacao02.setBounds(380,200,250,30); // x=Largura(Posicao), y=altura(Posicao), largura=Botao, altura=Botao
        btnServidorHomologacao02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            metodosubjanela.abrirDialog(framePai, "Servidor Homologacao 02", "Servidor Homologação 02 - Detalhes","homologacao02");
            	
            }
        });
        panel.add(btnServidorHomologacao02);  
        
// Botão "Servidor Homologacao03"
        JButton btnServidorHomologacao03 = new JButton("Servidor Homologacao 03");
        btnServidorHomologacao03.setBounds(120,240,250,30); // x=Largura(Posicao), y=altura(Posicao), largura=Botao, altura=Botao
        btnServidorHomologacao03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	metodosubjanela.abrirDialog(framePai, "Servidor Homologacao 03", "Servidor Homologação 03 - Detalhes","homologacao03");
                
            }
        });
        panel.add(btnServidorHomologacao03);

        return panel;
    }

}
