package ru.osetsky.shape;

/**
 * Created by koldy on 20.04.2017.
 */
public class Triangle implements Shape {
    @Override
    public String pic() {
        StringBuilder builder = new StringBuilder();
        int h = 3;
        for (int i = 0; i <= h; i++) {
            for (int i2 = 0; i2 < i; i2++) {
                builder.append(" ");
            }

            for (int i2 = 0; i2 <= i; i2++) {
                builder.append("^");
                if (i2 > 0) {
                    builder.append(" ");
                }
            }
            if (i == h) {
				for (int i3 = 0; i3 <= i; i3++) {
                if (i3 > 0) {
                    builder.append(" ");
					}
				}
            }
        }
        return null;
    }

}
