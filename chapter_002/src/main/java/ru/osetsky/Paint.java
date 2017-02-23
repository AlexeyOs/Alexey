package ru.osetsky;

public class Paint{
	public string piramid (int h) {
		StringBuilder builder = new StringBuilder();
		for (int index=0; index<h; index++) {
		builder.Append("^");
		builder.toString();
		}
		return builder;
	}
}
