package ru.osetsky.shape;

/**
 * Created by koldy on 20.04.2017.
 */
public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder builder = new StringBuilder();
        int h = 3;
        for (int i = 0; i <= h; i++) {
            if ((i == 0) | (i == h)) {
                for (int i2 = 0; i2 < h; i2++) {
                    builder.append("-");
                }
            }

            for (int i2 = 0; i2 <= i; i2++) {
                builder.append(" ");
                if ((i2 == 0) | (i2 == i)) {
                    builder.append(" ");
                }
                if ((i2 != 0) & (i2 != i)) {
                    builder.append(" ");
                }
            }
        }
        return null;
    }
}
