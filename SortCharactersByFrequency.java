package com.leetcodes1;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		String a = "cabcaa1c21c211c";
		// System.out.println(frequencySort(a));
		System.out.println(Math.pow(10, (int) Math.log10(2323)));
	}

	static void swap(char[] ch, int i, int j) {
		char t = ch[i];
		ch[i] = ch[j];
		ch[j] = t;
	}

	public static String frequencySort(String s) {
		int[] freq = new int[75];
		for (char ch : s.toCharArray()) {
		freq[ch-48]++;
	}

	String t = new String("");
	for (int i = 0; i < 75; i++) {
		if (freq[i] > 0) {
			t += ((char) (i + 48));
		}
	}

	char[] ch = t.toCharArray();
	for (int i = 0; i < ch.length; i++) {
		int min = i;
		for (int j = i + 1; j < ch.length; j++) {
			if (freq[ch[j] - 48] > freq[ch[min] - 48]) {
				min = j;
			}

		}
		swap(ch, i, min);
	}
	String amp = "";
	for (int i = 0; i < ch.length; i++) {
		amp += ("" + ch[i]).repeat(freq[ch[i] - 48]);
	}

	return amp;

}
}