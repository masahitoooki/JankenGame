package com.original_game.janken;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Player implements ActionListener {
	public static void createButton(JPanel footerPanel) {
		footerPanel.setLayout(new GridLayout(1, 4));

		//ボタンを表示
		JButton btnGu = new JButton("グー");
		btnGu = setButton(btnGu);
		footerPanel.add(btnGu);

		JButton btnChoki = new JButton("チョキ");
		btnChoki = setButton(btnChoki);
		footerPanel.add(btnChoki);

		JButton btnPa = new JButton("パー");
		btnPa = setButton(btnPa);
		footerPanel.add(btnPa);

		JButton exitButton = new JButton("終了");
		exitButton = setButton(exitButton);
		footerPanel.add(exitButton);
	}
	public static JButton setButton(JButton button) {
		int buttonSizeX = (640 - 20)/4;
		Dimension buttonDimesion = new Dimension(buttonSizeX, 50);
		button.setPreferredSize(buttonDimesion);
		Font buttonFont = new Font("ＭＳ ゴシック",Font.PLAIN,24);
		button.setFont(buttonFont);

		Player player = new Player();
		button.addActionListener(player);

		return(button);
	}
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		int playerHand = 0;
		if (command.equals("グー")) playerHand = 1;
		else if (command.equals("チョキ")) playerHand = 2;
		else if (command.equals("パー"))  playerHand = 3;
		else if (command.equals("終了")) playerHand = 4;

		int computerHand = Computer.decidesComputerHand();
		VictoryOrDefeat.decisionVictoryOrDefeat(computerHand, playerHand);
	}
}