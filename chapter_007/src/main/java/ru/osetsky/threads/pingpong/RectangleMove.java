package ru.osetsky.threads.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    private boolean wallStopByX = false;
    private boolean wallStopByY = false;

    /**
     * Добавил 4-е if для обработки 4-ёх случаев столкновений со стеной, после столкновения, происходит небольшая задержка.
     */
    @Override
    public void run() {
        while (true) {
            if (!wallStopByX && !wallStopByY) {
                this.rect.setX(this.rect.getX() + 1);
                this.rect.setY(this.rect.getY() + 1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.rect.getX() > 290) {
                    try {
                        Thread.sleep(1000);
                        wallStopByX = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (this.rect.getY() > 290) {
                    try {
                        Thread.sleep(1000);
                        wallStopByY = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (wallStopByX && !wallStopByY){
                this.rect.setX(this.rect.getX() - 1);
                this.rect.setY(this.rect.getY() + 1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.rect.getX() < 1) {
                    try {
                        Thread.sleep(1000);
                        wallStopByX = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (this.rect.getY() > 290) {
                    try {
                        Thread.sleep(1000);
                        wallStopByY = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (!wallStopByX && wallStopByY) {
                this.rect.setX(this.rect.getX() + 1);
                this.rect.setY(this.rect.getY() - 1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.rect.getX() > 290) {
                    try {
                        Thread.sleep(1000);
                        wallStopByX = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (this.rect.getY() < 1) {
                    try {
                        Thread.sleep(1000);
                        wallStopByY = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                this.rect.setX(this.rect.getX() - 1);
                this.rect.setY(this.rect.getY() - 1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.rect.getX() < 1) {
                    try {
                        Thread.sleep(1000);
                        wallStopByX = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (this.rect.getY() < 1) {
                    try {
                        Thread.sleep(1000);
                        wallStopByY = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
