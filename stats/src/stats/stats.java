package stats;

import java.util.Random;

public class stats {
	public static void main(String[] args) {
		int antalSpel = 1000000;
		int[] games = new int[antalSpel];
		int[] matches = new int[14]; // 1 after 11 wins and 2 lost = 14
		int[] wins = new int[13];
		double winRate = 0.10; // 0.5 + (0.1) this value = 0.6 = 60%
		Random rand = new Random();
		int vinst;
		int lostMatches;
		int wonMatches;
		for (int i = 0; i < games.length; i++) {
			lostMatches = 0;
			wonMatches = 0;
			for (int t = 0; t < matches.length; t++) {
				vinst = (int) Math.round(rand.nextDouble() + winRate);
				if (vinst == 0) {
					lostMatches++;
				} else {
					wonMatches++;
				}
				if (wonMatches == 12) {
					wins[wonMatches]++;
					break;
				}
				if (lostMatches == 3) {
					wins[wonMatches]++;
					break;
				}
			}
		}
		double summa = 0;
		double number;
		for (int i = 0; i < wins.length; i++) {
			number = (Math.round((double) wins[i] / antalSpel * 1000) / 10d);
			summa = Math.round((summa + number) * 10) / 10d;
			System.out.println(i + " Wins: " + number + "% Sum: " + summa + "%");

		}
		System.out.println("Summa: " + summa + "%");
	}
}
