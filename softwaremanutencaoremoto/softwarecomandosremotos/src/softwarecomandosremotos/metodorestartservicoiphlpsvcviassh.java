package softwarecomandosremotos;

import com.jcraft.jsch.*;

import java.io.InputStream;

public class metodorestartservicoiphlpsvcviassh {
	
	 /**
     * Conecta via SSH em um servidor Windows e reinicia o serviço "iphlpsvc".
     * 
     * @param host o IP ou hostname do servidor
     * @param user o usuário SSH
     * @param password a senha SSH
     * @throws Exception caso ocorra falha na conexão ou execução
     */
    public static void restartServicoIphlpSvc(String host, String user, String password) throws Exception {
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

        // 2) Verificar se é Windows
        if (resultadoSO.toLowerCase().contains("windows") || resultadoSO.toLowerCase().contains("microsoft")) {
            // Comando para reiniciar serviço no Windows
            String comandoRestartServico = "net stop iphlpsvc && net start iphlpsvc";
            System.out.println("Executando comando para reiniciar serviço: " + comandoRestartServico);
            executarComando(session, comandoRestartServico);
        } else {
            throw new RuntimeException("O SO remoto não é Windows. Este método suporta apenas reinício do serviço em Windows.");
        }

        session.disconnect();
    }

    /**
     * Executa um comando no servidor remoto e retorna a saída como string.
     */
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
