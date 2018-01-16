package com.lottery.base;

import java.text.MessageFormat;

//https://en.wikipedia.org/wiki/Lottery_mathematics
public class AppMain {
	public static void main(String[] args) {
		/*
		 * In a typical 6/36 game, six numbers are drawn from a range of 36 and if the six numbers on a ticket match the
		 * numbers drawn, the ticket holder is a jackpot winner�this is true no matter in which order the numbers
		 * appear. The probability of this happening is 1 in 1,947,792.
		 */
		ToHop toHop = new ToHop(36, 6);
		toHop.backtrack(1);
		System.out.println(
				MessageFormat.format("6/36 game. The probability of this happening is 1 in {0}", toHop.getCount())); // 1,947,792

		/*
		 * In a typical 6/45 game, six numbers are drawn from a range of 45 and if the six numbers on a ticket match the
		 * numbers drawn, the ticket holder is a jackpot winner�this is true no matter in which order the numbers
		 * appear. The probability of this happening is 1 in 8,145,060.
		 */
		toHop = new ToHop(45, 6);
		toHop.backtrack(1);
		System.out.println(
				MessageFormat.format("6/45 game. The probability of this happening is 1 in {0}", toHop.getCount())); // 8,145,060

		/*
		 * In a typical 6/49 game, six numbers are drawn from a range of 49 and if the six numbers on a ticket match the
		 * numbers drawn, the ticket holder is a jackpot winner�this is true no matter in which order the numbers
		 * appear. The probability of this happening is 1 in 13,983,816.
		 */
		toHop = new ToHop(49, 6);
		toHop.backtrack(1);
		System.out.println(
				MessageFormat.format("6/49 game. The probability of this happening is 1 in {0}", toHop.getCount())); // 13,983,816

		/*
		 * In a typical 6/59 game, six numbers are drawn from a range of 59 and if the six numbers on a ticket match the
		 * numbers drawn, the ticket holder is a jackpot winner�this is true no matter in which order the numbers
		 * appear. The probability of this happening is 1 in 45,057,474.
		 */
		toHop = new ToHop(59, 6);
		toHop.backtrack(1);
		System.out.println(
				MessageFormat.format("6/59 game. The probability of this happening is 1 in {0}", toHop.getCount()));// 45,057,474

		/* Power 6/55 */
		toHop = new ToHop(55, 6);
		toHop.backtrack(1);
		System.out.println(
				MessageFormat.format("6/55 game. The probability of this happening is 1 in {0}", toHop.getCount()));// 28,989,675
	}

}
