package com.lottery.base;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class RandomUtils {
	@SuppressWarnings("unchecked")
	public static List<String> getNotWinningNumbers(final String[] winningNumbers) {
		if (winningNumbers == null) throw new IllegalArgumentException("...winningNumbers... cannot be null.!.");

		Set<String> sets = Sets.newHashSet(winningNumbers);
		List<String> winnings = Lists.newArrayList(sets);

		List<String> _645s = Lists.newLinkedList();
		for (int i = 1; i <= 45; i++) {
			String num = (i < 10 ? String.valueOf("0" + i) : String.valueOf(i));
			_645s.add(num);
		}

		if (winnings.isEmpty()) return _645s;

		Collections.sort(winnings);
		Collections.sort(_645s);

		List<String> notWinnings = ListUtils.subtract(_645s, winnings);
		return notWinnings;
	}

	/* Ham tra ve so nguyen tinh n! (Factorial) */
	public static long fac(final int n) {
		if (n == 0) return 1;

		return n * fac(n - 1);
	}

	public static boolean contains(final String[] array, final String targetValue) {
		if (array == null || Strings.isNullOrEmpty(targetValue)) return false;

		for (String s : array)
			if (targetValue.equals(s)) return true;

		return false;
	}

}
