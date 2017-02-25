package ru.osetsky;

public class Testexercise {
	public boolean podstroka (String origin,String sub) {
		String[] aOrigin = origin.split("");
		String[] aSub = origin.split("");
		int equals = 0;
		boolean result = false;
		if (aOrigin.length >= aSub.length) {
			for (int i = 0; i<aSub.length; i++) {
				for (int j=0; j< aOrigin.length;j++) {
					if (aOrigin[j].equals(aSub[i])) {
						equals++;
					}
				}
			}
			if (equals == aSub.length) {
				result = true;
			}
		}
		return result;
	}
}