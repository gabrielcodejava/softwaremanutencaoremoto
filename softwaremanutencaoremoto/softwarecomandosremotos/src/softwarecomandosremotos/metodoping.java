package softwarecomandosremotos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class metodoping {
	
	public static void verificarDisponibilidadeServidor(String ipAddress) {
        String os = System.getProperty("os.name").toLowerCase(); // Pega o SO para ajustar o comando ping
        String comandoPing;

        // Ajusta o comando ping para Windows ou Linux/macOS
        if (os.contains("win")) {
            // No Windows, -n é para número de pacotes
            comandoPing = "ping -n 1 " + ipAddress;
        } else {
            // No Linux/macOS, -c é para número de pacotes
            comandoPing = "ping -c 1 " + ipAddress;
        }

        StringBuilder resultadoPing = new StringBuilder();
        boolean disponivel = false;

        try {
            Process processo = Runtime.getRuntime().exec(comandoPing); // Executa o comando ping
            BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = reader.readLine()) != null) {
                resultadoPing.append(linha).append("\n");
                // Verifica a saída para determinar a disponibilidade
                if (os.contains("win") && linha.contains("Resposta de " + ipAddress)) {
                    disponivel = true;
                } else if (!os.contains("win") && linha.contains("bytes from " + ipAddress)) {
                    disponivel = true;
                }
            }
            processo.waitFor(); // Espera o processo terminar

            String mensagem;
            if (disponivel) {
                mensagem = "Servidor " + ipAddress + " está DISPONÍVEL!\n\nDetalhes do Ping:\n" + resultadoPing.toString();
                JOptionPane.showMessageDialog(null, mensagem, "Disponibilidade do Servidor", JOptionPane.INFORMATION_MESSAGE);
            } else {
                mensagem = "Servidor " + ipAddress + " está INDISPONÍVEL ou inacessível.\n\nDetalhes do Ping:\n" + resultadoPing.toString();
                JOptionPane.showMessageDialog(null, mensagem, "Disponibilidade do Servidor", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o comando ping: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
