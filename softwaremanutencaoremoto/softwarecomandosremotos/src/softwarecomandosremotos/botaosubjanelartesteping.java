package softwarecomandosremotos;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class botaosubjanelartesteping {
	
    public static JButton criarBotaoServidorHomologacao02(JDialog dialogPai) {
        JButton btnping = new JButton("Teste de conectividade");
        btnping.setBounds(50, 130, 290, 30);
        btnping.addActionListener(e -> {
            try {
                // Pedir as informações ao usuário
                String ipAddress = JOptionPane.showInputDialog(dialogPai, "Digite o IP ou hostname do servidor:");
                if (ipAddress == null || ipAddress.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogPai, "IP/hostname não fornecido. Operação cancelada.");
                    return;
                }

                // Chama o método com os dados fornecidos pelo usuário
                metodoping.verificarDisponibilidadeServidor(ipAddress);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(dialogPai, "Erro ao reiniciar via SSH: " + ex.getMessage(),
                                              "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        return btnping;
    }

}
