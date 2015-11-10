package kru.honi.round2;

public class Tnt {
	
	public int getRemainingMoney(int totalAmount, int numberOfRounds) {
		int player1Amount = (numberOfRounds * (1 + numberOfRounds)) / 2;
		int player2Amount = numberOfRounds;
		return totalAmount - player1Amount - player2Amount;
	}
}
