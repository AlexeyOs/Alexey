package ru.osetsky;

public class Paint{
	public String piramid (int h) {
		for(int i = 0; i < h; i++) {
			StringBuilder builder = new StringBuilder();
			for(int i2 = 0; i2 < i; i2++) {
				builder.append(" ");
			}

			for(int i2 = 0; i2 <= i; i2++) {
				builder.append("^");
				if(i2 > 0) {
					builder.append(" ");
				}
			}
		}
		return builder.toString();
	}
}