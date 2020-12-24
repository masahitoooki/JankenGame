package com.original_game.janken;

public class VictoryOrDefeat {
	private static int win = 0;
	private static int lose = 0;
	public static final void decisionVictoryOrDefeat(int computerHand,int playerHand) {
		int playerHandTemp = playerHand;
		playerHandTemp++;

		if (playerHand == 4) {
			String text;
			if (win > lose) text = "勝ち！";
			else if (win < lose) text = "あなたの負け";
			else text = "引き分け！";

			Panel.contentsLabel.setText("トータルで"+text);
		}
		else if (playerHand == computerHand) {
			//Panel.headerLabel.setText("あいこかよ！（" + point + "）");
		}
		else if ((playerHand == 3 && computerHand == 1)||(playerHandTemp == computerHand)) {
			win+=1;
			//Panel.headerLabel.setText("お前の勝ちかよ！（" + point + "）");
		}
		else {
			lose+=1;
			//Panel.headerLabel.setText("お前の負けかよ！（" + point + "）");
		}
		Panel.headerLabel.setText( win + "対" + lose );
	}
}