package mypack;
import javax.swing.JOptionPane;

class Game{
	Board b;
	Game(){
		this.b = new Board(this);
	}
	boolean checkWin(){ // Checa todas as combinacoes possiveis
		return (
				checkTres(this.b.buttons[0], this.b.buttons[1], this.b.buttons[2]) || 
				checkTres(this.b.buttons[3], this.b.buttons[4], this.b.buttons[5]) || 
				checkTres(this.b.buttons[6], this.b.buttons[7], this.b.buttons[8]) || 
				checkTres(this.b.buttons[0], this.b.buttons[4], this.b.buttons[8]) || 
				checkTres(this.b.buttons[2], this.b.buttons[4], this.b.buttons[6]) ||
				checkTres(this.b.buttons[0], this.b.buttons[3], this.b.buttons[6]) || 
				checkTres(this.b.buttons[1], this.b.buttons[4], this.b.buttons[7]) || 
				checkTres(this.b.buttons[2], this.b.buttons[5], this.b.buttons[8])
				);
	}

	boolean checkTres(MyButton a, MyButton b, MyButton c){ // Vai checar um conjunto de 3 espacos
		if(a.getText().equals(b.getText()) && a.getText().equals(c.getText())){ // se a == b e b == c -> a == b == c
			if(a.getText().equals("X")){ // se o jogador X ganhou
				JOptionPane.showMessageDialog(null, "O jogador X venceu");
//				disableButtons();
				this.b.resetButtons();
				return true;
			}else if(a.getText().equals("O")){
				JOptionPane.showMessageDialog(null, "O jogador O venceu");
//				disableButtons();
				this.b.resetButtons();
				return true;
			}
		}
		return false;
	}

}
