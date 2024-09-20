package com.example;

public class Jogo {
	private String[][] tabuleiro;
	private String jogadorAtual;
	private boolean fim;
	
	public Jogo() {
		tabuleiro = new String[3][3];
		jogadorAtual = "X";
		fim = false;
		resetar();
	}
	
	public void jogar(int linha, int coluna) {
		tabuleiro[linha][coluna] = jogadorAtual;
		fim = verificarVitoria() || verificarEmpate();
	}
	
	public boolean isVitoria() {
		return verificarVitoria();
	}
	
	public boolean isEmpate() {
		return verificarEmpate();
	}
	
	public void alternarJogador() {
		jogadorAtual = jogadorAtual.equals("X") ? "O" : "X";
	}
	
	public String getJogadorAtual() {
		return jogadorAtual;
	}
	
	public boolean isFim() {
		return fim;
	}
	
	public void resetar() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = "";
			}
		}
		jogadorAtual = "X";
		fim = false;
	}
	
	public boolean verificarVitoria() {
		for (int i = 0; i < 3; i++) {
			if (!tabuleiro[i][0].equals("") && tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][1].equals(tabuleiro[i][2])) {
                return true;
            }
            if (!tabuleiro[0][i].equals("") && tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[1][i].equals(tabuleiro[2][i])) {
                return true;
            }
		}
		
		 if (!tabuleiro[0][0].equals("") && tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][2])) {
	            return true;
	        }
	        if (!tabuleiro[0][2].equals("") && tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][0])) {
	            return true;
	        }

	        return false;
	}
	
	private boolean verificarEmpate() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j].equals("")) {
					return false;
				}
				
			}
		}
		return true;
	}
}
