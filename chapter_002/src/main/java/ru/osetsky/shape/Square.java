package ru.osetsky.shape;

/**
 * Created by koldy on 20.04.2017.
 */
public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder builder = new StringBuilder();
        int h = 2;
        for (int i = 0; i <= h; i++) {
            if ((i == 0) | (i == h)) {
                for (int i1 = 0; i1 <= h; i1++) {
                    builder.append("-");
                }
            }
            if ((i != 0) & (i != h)) {
                for (int i2 = 0; i2 <= h; i2++) {
                    if ((i2 == 0) | (i2 == h)) {
                        builder.append("|");
                    }
					if ((i2 != 0) & (i2 != h)) {
                        builder.append(" ");
                    }
                }
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }
}
