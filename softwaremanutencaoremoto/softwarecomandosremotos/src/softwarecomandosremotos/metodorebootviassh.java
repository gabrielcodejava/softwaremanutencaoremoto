
package softwarecomandosremotos;

import com.jcraft.jsch.*;

import java.io.InputStream;

public class metodorebootviassh {

    public static void reiniciarAmbienteSSH(String host, String user, String password) throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 22);
        session.setPassword(password);

        // Desativa checagem de chave de host para simplificar (não recomendado em produção)
        session.setConfig("StrictHostKeyChecking", "no");

        session.connect(10_000); // timeout em ms

        // 1) Detectar SO remoto com comando genérico
        String comandoDetectarSO = "uname -s || ver"; // "uname -s" funciona em Linux, "ver" no Windows
        String resultadoSO = executarComando(session, comandoDetectarSO);

        System.out.println("SO detectado: " + resultadoSO.trim());

        // 2) Decidir comando de reboot com base no resultado
        String comandoReboot;
        if (resultadoSO.toLowerCase().contains("linux") || resultadoSO.toLowerCase().contains("unix")) {
            comandoReboot = "sudo reboot";
        } else if (resultadoSO.toLowerCase().contains("windows") || resultadoSO.toLowerCase().contains("microsoft")) {
            comandoReboot = "shutdown -r -t 0";
        } else {
            throw new RuntimeException("Não foi possível identificar o sistema operacional remoto.");
        }

        // 3) Executar reboot
        System.out.println("Executando comando de reboot: " + comandoReboot);
        executarComando(session, comandoReboot);

        session.disconnect();
    }

    private static String executarComando(Session session, String comando) throws Exception {
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(comando);

        InputStream in = channel.getInputStream();
        channel.connect();

        byte[] tmp = new byte[1024];
        StringBuilder output = new StringBuilder();

        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) break;
                output.append(new String(tmp, 0, i));
            }
            if (channel.isClosed()) break;
            Thread.sleep(100);
        }

        channel.disconnect();
        return output.toString();
        
    }

}
