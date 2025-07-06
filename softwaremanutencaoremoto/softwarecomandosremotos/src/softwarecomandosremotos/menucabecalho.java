package softwarecomandosremotos;

import java.awt.FlowLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class menucabecalho {
	
	public static JMenuBar criarMenu() {
     
     //painel cabecalho
     JMenuBar barraMenu = new JMenuBar();
     JMenu menu1Arquivo = new JMenu("Arquivo");
     JMenu menu2Arquivo = new JMenu("Debug");
     JMenu menu3Arquivo = new JMenu("Extrair");
     JMenu menu4Arquivo = new JMenu("Logs");
     
     JMenuItem item1Novo = new JMenuItem("Novo");
     JMenuItem item2Novo = new JMenuItem("Abrir...");
     JMenuItem item3Novo = new JMenuItem("Acao");
     JMenuItem item4Novo = new JMenuItem("Rodar");
     JMenuItem item5Novo = new JMenuItem("Logs da aplicacao");
     JMenuItem item6Novo = new JMenuItem("Logs do jFrame");
     
     menu1Arquivo.add(item1Novo);
     menu1Arquivo.add(item2Novo);
     menu2Arquivo.add(item3Novo);
     menu3Arquivo.add(item4Novo);
     menu4Arquivo.add(item5Novo);
     menu4Arquivo.add(item6Novo);
     
     barraMenu.add(menu1Arquivo);
     barraMenu.add(menu2Arquivo);
     barraMenu.add(menu3Arquivo);
     barraMenu.add(menu4Arquivo);
     
     return barraMenu;
     

}
	
}
