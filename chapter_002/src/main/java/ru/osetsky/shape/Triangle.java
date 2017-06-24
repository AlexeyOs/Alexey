package ru.osetsky.shape;

/**
 * Created by koldy on 20.04.2017.
 */
public class Triangle implements Shape {
    @Override
    public String pic() {
        StringBuilder builder = new StringBuilder();
        int h = 2;
        for (int i = 0; i <= h; i++) {
           if (i == 0) {
               for (int i0 = 0; i0 <= h; i0++) {
                    if (i0 < (h / 2)) {
                        builder.append(" ");
                    }
                    if ((i0 >= (h / 2)) & (i0 <= (h + 1) / 2)) {
                        builder.append("^");
                    }
                    if ((i0 > h / 2) & (i0 > (h + 1) / 2)) {
                        builder.append(" ");
                    }

               }
           }
           if ((i != 0) & (i != h)) {
                        builder.append("^");
                        builder.append(" ");
                        builder.append("^");
           }
            if (i == h) {
				for (int i3 = 0; i3 <= h; i3++) {
                    builder.append("^");
				}
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }

}
