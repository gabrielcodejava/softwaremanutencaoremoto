package softwarecomandosremotos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dialog; // Importe java.awt.Dialog para o tipo modal
import javax.swing.JDialog;

public class metodosubjanela {

    public static void abrirDialog(JFrame framePai, String titulo, String mensagem, String identificador) {
        // Cria um JDialog como subjanela, tornando-o modal para o framePai
        JDialog subJanela = new JDialog(framePai, titulo, Dialog.ModalityType.APPLICATION_MODAL); // Torna o JDialog modal
        subJanela.setSize(400, 300);
        subJanela.setLocationRelativeTo(framePai);
        subJanela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Use JDialog.DISPOSE_ON_CLOSE
        subJanela.setLayout(null);

        // Exemplo de label com a mensagem
        JLabel lblMensagem = new JLabel(mensagem);
        lblMensagem.setBounds(50, 20, 300, 30);
        subJanela.add(lblMensagem);
        
        if ("homologacao02".equals(identificador)) {
            JButton btnRebootSSH = botaosubjanelarebootservidorviassh.criarBotaoServidorHomologacao02(subJanela);
            subJanela.add(btnRebootSSH);
         
            JButton btnRebootiphlpsvcSSH = botaosubjanelarebootservicoiphlpsvcviassh.criarBotaoServidorHomologacao03(subJanela);
            subJanela.add(btnRebootiphlpsvcSSH);
            
        } else if ("homologacao01".equals(identificador)) {
        	JButton btnping = botaosubjanelartesteping.criarBotaoServidorHomologacao02(subJanela);
            subJanela.add(btnping);
      
        } else if ("homologacao03".equals(identificador)) {
        	JButton btnRebootSSH = botaosubjanelarebootservidorviassh.criarBotaoServidorHomologacao02(subJanela);
            subJanela.add(btnRebootSSH);

        } else {
            JButton btnPadrao = new JButton("Ação");
            btnPadrao.setBounds(125, 80, 140, 30);
            btnPadrao.addActionListener(e -> JOptionPane.showMessageDialog(subJanela, "Nada definido!"));
            subJanela.add(btnPadrao);
        }

        // Botão Fechar
        JButton btnFechar = new JButton("Fechar");
        btnFechar.setBounds(125, 200, 120, 30);
        btnFechar.addActionListener(e -> subJanela.dispose());
        subJanela.add(btnFechar);

        // Torna a janela visível
        subJanela.setVisible(true);
    }
}