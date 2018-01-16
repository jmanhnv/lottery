package com.lottery.base;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ToHop {
	int n, k;
	int[] x;

	// for test
	int count;
	List<String> vouchers;
	//
	String[] excludes;

	public ToHop(int n, int k) {
		this.n = n;
		this.k = k;
		this.x = new int[1000000];

		x[0] = 0;
		count = 0;
		vouchers = Lists.newArrayList();
	}

	public ToHop(int n, int k, String[] excludes) {
		this(n, k);
		this.excludes = excludes;
	}

	public void print() {
		count++;
		String voucher = "";

		for (int i = 1; i <= k; i++) {
			// System.out.print(x[i]);
			String value = (x[i] < 10 ? ("0" + String.valueOf(x[i])) : String.valueOf(x[i]));
			if (i < k) voucher += value + "-";
			else voucher += value;
		}

		// System.out.println(voucher);
		vouchers.add(voucher);
	}

	public void backtrack(int i) {
		for (int j = x[i - 1] + 1; j <= n - k + i; j++) {
			x[i] = j;
			if (i == k) print();
			else backtrack(i + 1);
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<< Start - For special case tesing, will be
	// remove later
	public void print_test() {
		count++;
		String voucher = "";
		for (int i = 1; i <= k; i++) {
			String value = (x[i] < 10 ? ("0" + String.valueOf(x[i])) : String.valueOf(x[i]));
			if (i < k) voucher += value + "-";
			else voucher += value;
		}

		// System.out.println(voucher);
		vouchers.add(voucher);

	}

	public void backtrack_test(int i) {
		Set<String> sets = getExcludes();
		for (int j = x[i - 1] + 1; j <= n - k + i; j++) {
			String s = (j < 10 ? ("0" + String.valueOf(j)) : String.valueOf(j));
			if (sets.contains(s)) continue;

			x[i] = j;
			if (i == k) print_test();
			else backtrack_test(i + 1);
		}
	}

	private Set<String> getExcludes() {
		return Sets.newHashSet(excludes);
	}

	public int getCount() {
		return count;
	}

	public List<String> getVouchers() {
		return vouchers;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>> End

}
