package softwarecomandosremotos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class botaosubjanelarebootservidorviassh {

    public static JButton criarBotaoServidorHomologacao02(JDialog dialogPai) {
        JButton btnRebootSSH = new JButton("Reiniciar Servidor");
        btnRebootSSH.setBounds(50, 130, 290, 30);
        btnRebootSSH.addActionListener(e -> {
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

                // Chama o método com os dados fornecidos pelo usuário
                metodorebootviassh.reiniciarAmbienteSSH(host, user, password);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(dialogPai, "Erro ao reiniciar via SSH: " + ex.getMessage(),
                                              "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        return btnRebootSSH;
    }
}

