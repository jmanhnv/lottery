package com.lottery.base;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class RandomMain {
	/* args - be the WINNING RESULTS of last three (Prize - Jackpot) */
	public static void main(String[] args) {
		// 05/08/2016: 03 09 13 18 24 31
		// 03/08/2016: 07 10 25 27 29 40
		// 31/07/2016: 02 06 19 21 35 39

		if (args == null || args.length == 0) throw new IllegalArgumentException(
				"Must passing the WINNING RESULTS of last three (Prize - Jackpot)!!!!!!! - 'E.g. java -jar random.jar 03 09 13 18 24 31 07 10 25 27 29 40 02 06 19 21 35 39'");

		// FIXME - for internal testing
		// 29/07/2016: 03 08 13 20 30 36
		// 27/07/2016: 14 17 21 25 31 37
		// 24/07/2016: 01 10 16 18 23 38

		// args = new String[] { "03", "08", "13", "20", "30", "36", "14", "17","21", "25", "31", "37", "01", "10",
		// "16","18", "23", "38" };

		Set<String> winners = Sets.newHashSet(args);
		int winnerSize = winners.size();
		System.out.println("Winning-Numbers = " + winnerSize);

		List<String> notWinners = RandomUtils.getNotWinningNumbers(args);
		int notWinnerSize = notWinners.size();
		System.out.println("Not-Winning-Numbers = " + notWinnerSize);

		// ///////// PASSSSSSSSSSSSSSSSS
		// ToHop obj = new ToHop(3, 2);
		// obj.backtrack(1);
		// System.out.println("Total voucher(s) = " + obj.getCount());

		////////////////////////////////
		long stime = System.currentTimeMillis();
		ToHop obj = null;

		int restSize = 45 - winnerSize;
		if (restSize < 6) {
			//// TH: So luong so de chon < 6 thi cho chon list gom (6/45) bo so
			// throw new IllegalArgumentException(MessageFormat.format("n = restSize = {0}, k = {6}, must as (n >= k >=
			//// 0)", restSize));

			obj = new ToHop(45, 6);
			obj.backtrack(1);
		} else {
			//// TH: So luong so de chon >= 6 thi van cho chon list gom (6/restSize) da loai tru cac so da trung Jackpot
			//// cho 3 ky xo truoc do.

			obj = new ToHop(45, 6, args);
			obj.backtrack_test(1);
		}

		List<String> vouchers = obj.getVouchers();
		long etime = System.currentTimeMillis();

		System.out.println(MessageFormat.format("-----------------\nElapsed time {0} second(s). Total {1} voucher(s).",
				(etime - stime) / 1000.0, vouchers.size()));
	}

}
