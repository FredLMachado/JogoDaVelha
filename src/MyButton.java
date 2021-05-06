package mypack;

import javax.swing.JButton;

class MyButton extends JButton {
	boolean marked;
	MyButton(){
		this.marked = false;
	}
	public boolean isMarked(){
		return this.marked;
	}
	public boolean mark(String str){ // Seta o texto do botao para a string passada (Caso ja nao tenha sido marcado)
		if(!this.marked){
			this.setText(str);
			this.marked = true;
			return true;
		}
		return false;
	}
	public void reset(){
		this.setText("");
		this.marked = false;
	}
}
