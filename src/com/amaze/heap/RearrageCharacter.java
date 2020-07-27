package com.amaze.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrageCharacter {

	public static void main(String[] args) {
		
		String ques = "geeksforgeeks";

		PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());

		int count[] = new int[26];
		for (int i = 0; i < ques.length(); i++) {
			int charAscii = ques.charAt(i) - 'a';
			count[charAscii]++;
		}
		for (char ch = 'a'; ch <= 'z'; ch++) {
			int chrAsc = ch - 'a';
			if (count[chrAsc] > 0)
				pq.add(new Freq(count[chrAsc], ch));
		}

		Freq prev = new Freq(-1, '#');
		String res = "";
		while (!pq.isEmpty()) {
			Freq curr = pq.peek();
			pq.poll();
			res = res + curr.ch;
			if (prev.freq > 0) {
				pq.add(prev);
			}
			curr.freq--;
			prev = curr;
		}
		System.out.println(res);
		if (ques.length() != res.length())
			System.out.println(0);
		else
			System.out.println(1);
	}

}

class Freq {
	int freq;
	char ch;

	Freq(int freq, char s) {
		this.ch = s;
		this.freq = freq;
	}
}

class FreqComparator implements Comparator<Freq> {

	@Override
	public int compare(Freq o1, Freq o2) {
		if (o1.freq < o2.freq) {
			return 1;
		}
		if (o1.freq > o2.freq) {
			return -1;
		}
		return 0;
	}

}


/*
 * This solution works only if question is yes/no
 * If has to print result won't work 
 * 
 */
/*
HashMap<Character, Integer> frequencies = new HashMap<>();

int length = string.length();
int maxFrequency = 0;
for(int i = 0; i < length; i++) {
    Character curr = string.charAt(i);
    
    if(frequencies.containsKey(curr)) {
        
        int count = frequencies.get(curr);
        count++;
        frequencies.put(curr, count);
        maxFrequency = Math.max(count, maxFrequency);
    } else {
        
        frequencies.put(curr, 1);
        maxFrequency = Math.max(1, maxFrequency);
    }
}
if(maxFrequency <= (length - maxFrequency)) {
    System.out.println(1);
} else {
    System.out.println(0);
}
*/