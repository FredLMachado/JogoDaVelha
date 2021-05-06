package mypack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.GridLayout;

class Board extends JFrame implements ActionListener{

	MyButton[] buttons = new MyButton[9]; // Vetor dde botoes
	boolean vez; // Seta a vez do Jogador (X ou O)
	Game g;
	Board(Game g){
		this.g = g;
		vez = true;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se clicar pra fechar, o jogo realmente fecha
		this.setLayout(new GridLayout(3, 3));	// Seta o Layout como grid de 3 colunas e 3 linhas
		this.setSize(263, 283); // Seta o tamanho
		this.setResizable(false); // Nao deixa mudar o tamanho
		this.setTitle("Jogo da Velha"); // Seta o titulo

		this.iniciaBotoes();
		this.setVisible(true); // Seta o Frame como visivel
	} 
	
	private void iniciaBotoes(){
		for(int i = 0; i < 9; i++){ 
			buttons[i]= new MyButton(); // Instancia cada botao e 
			buttons[i].addActionListener(this); // Linka o ActionListener com o frame
			this.add(buttons[i]); // Adiciona cada botao no frame
		}
	}
//	void disableButtons(){ // Vai desabilitar os botoes
//		for(int i = 0; i < 9; i++){
//			buttons[i].setEnabled(false);
//		}
//	}

	void resetButtons(){
		for(int i = 0; i < 9; i++){
			this.buttons[i].reset();
		}
		this.vez = true;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		for(int i = 0; i < 9; i++){
			if(e.getSource() == buttons[i] && !buttons[i].isMarked()){ // Se o botao foi clicado e nao esta marcado
				if(this.vez){	// Se for a vez do 'X'
					buttons[i].mark("X");
					this.vez = false;
					break;
				}else if(!this.vez){ // Se for a vez do 'O'
					buttons[i].mark("O");
					this.vez = true;
					break;
				}
			}
		}
		this.g.checkWin(); // Vai rodar isso todas as vezes que tiver algum evento
	}
}
 
