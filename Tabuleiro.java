package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Tabuleiro {
	private JFrame frame;
	private JButton[][] botoes;
	private Jogo jogo;
	
	public Tabuleiro() {
		frame = new JFrame("Jogo da Velha de gdelacerda23!");
		botoes = new JButton[3][3];
		jogo = new Jogo();
		
	}
	
	public void iniciar() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(3, 3));
		
		for (int linha = 0; linha < 3; linha ++) {
			for (int coluna = 0; coluna < 3; coluna ++) {
				botoes[linha][coluna] = new JButton("");
				botoes[linha][coluna].setFont(new Font("Arial", Font.PLAIN, 60));
				final int l = linha;
				final int c = coluna;
				
				botoes[linha][coluna].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (botoes[l][c].getText().equals("") && !jogo.isFim()) {
							botoes[l][c].setText(jogo.getJogadorAtual());
							jogo.jogar(l, c);
							if (jogo.isVitoria()) {
								JOptionPane.showMessageDialog(frame, "Jogador " + jogo.getJogadorAtual() + " venceu!");
								resetarJogo();
							} else if (jogo.isEmpate()) {
								JOptionPane.showMessageDialog(frame, "Empate!");
								resetarJogo();
							} else {
								jogo.alternarJogador();
							}
						}
					}
				});
				
				frame.add(botoes[linha][coluna]);
			}
		}
		
		frame.setVisible(true);
	}
	
	private void resetarJogo() {
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				botoes[linha][coluna].setText("");
			}
		}
		
		jogo.resetar();
	}
}
