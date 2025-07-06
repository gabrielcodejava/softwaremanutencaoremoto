package softwarecomandosremotos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
// Importe JDialog aqui
import javax.swing.JDialog; 
import javax.swing.JOptionPane;
import javax.swing.JPanel; // Este import pode não ser necessário, dependendo de outras partes da classe

public class botaosubjanelarebootservicoiphlpsvcviassh {
	
	// Altere JFrame para JDialog aqui
	public static JButton criarBotaoServidorHomologacao03(JDialog dialogPai) { 
		JButton btnRebootiphlpsvcSSH = new JButton("Reiniciar servico IPHLPSVC");
		btnRebootiphlpsvcSSH.setBounds(50, 170, 290, 30);
		btnRebootiphlpsvcSSH.addActionListener(e -> {
		    try {
		    	// Pedir as informações ao usuário
                String host = JOptionPane.showInputDialog(dialogPai, "Digite o IP ou hostname do servidor:");
                if (host == null || host.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogPai, "IP/hostname não fornecido. Operação cancelada.");
                    return;
                }

                String user = JOptionPane.showInputDialog(dialogPai, "Digite o usuário SSH:");
                if (user == null || user.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogPai, "Usuário não fornecido. Operação cancelada.");
                    return;
                }

                String password = JOptionPane.showInputDialog(dialogPai, "Digite a senha SSH:");
                if (password == null || password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogPai, "Senha não fornecida. Operação cancelada.");
                    return;
                }

		        metodorebootviassh.reiniciarAmbienteSSH(host, user, password);

		    } catch (Exception ex) {
		        ex.printStackTrace();
		        // Use dialogPai aqui
		        JOptionPane.showMessageDialog(dialogPai, "Erro ao reiniciar via SSH: " + ex.getMessage(),
		                                      "Erro", JOptionPane.ERROR_MESSAGE);
		    }
		});
		
		return btnRebootiphlpsvcSSH;

		}
}