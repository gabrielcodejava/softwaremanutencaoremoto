package softwarecomandosremotos; //nome do pacote

import javax.swing.*; //pacote para criar interfaces
import java.awt.*; //pacote com fundamentações para construir interfaces gráficas e gerenciar eventos
import java.awt.event.ActionEvent; //pacote para descrever a ocorrência de uma ação do usuário
import java.awt.event.ActionListener; //pacote para ouvir a ocorrência de uma ação do usuário
import java.io.BufferedReader; //pacote para lê texto de forma eficiente
import java.io.InputStreamReader; //pacote para fazer uma ponte entre streams de bytes e streams de caracteres
import java.io.IOException; //pacote para sinalizar problemas de entrada/saída

public class teste extends JFrame {

    public teste() {
        // Configurações básicas da janela
        setTitle("Tela de Teste");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centraliza a janela na tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        // Cria um painel para organizar os componentes
        JPanel panel = new JPanel();
        //panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // FlowLayout com espaçamento
        panel.setLayout(null);
        
        //Adicionar o menu do cabecalho
        JMenuBar barraMenu = menucabecalho.criarMenu();
        setJMenuBar(barraMenu);
        
        //Adicionar o painel ao frame
        JPanel panel2 = botoes.criarPainelDeBotoes(this);
        add(panel2);
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                teste tela = new teste();
                tela.setVisible(true);
            }
        });
    }
}