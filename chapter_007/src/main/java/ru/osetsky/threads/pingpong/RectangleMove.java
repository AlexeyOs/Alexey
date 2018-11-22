package ru.osetsky.threads.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    private boolean wallStopByX = false;

    /**
     * Добавил 2-е if для обработки 2-ух случаев столкновений со стеной, после столкновения, происходит небольшая задержка.
     */
    @Override
    public void run() {
        while (true) {
            if (!wallStopByX) {
                //обычный шаг вправо
                this.rect.setX(this.rect.getX() + 1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //если справа квадрат уперся, то меняю значение булевской переменной
                if (this.rect.getX() > 290) {
                    try {
                        Thread.sleep(1000);
                        wallStopByX = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if (wallStopByX) {
                //обычный шаг влево
                this.rect.setX(this.rect.getX() - 1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //если слева квадрат уперся, то меняю значение булевской переменной
                if (this.rect.getX() < 0) {
                    try {
                        Thread.sleep(1000);
                        wallStopByX = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
