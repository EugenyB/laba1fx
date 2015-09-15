package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Controller {

    @FXML
    Canvas canvas;
    double minX = -5;
    double maxX = 5;
    double minY = -5;
    double maxY = 5;

    private int toScreenX(double x) {
        return (int) (canvas.getWidth() * (x - minX) / (maxX - minX));
    }

    private int toScreenY(double y) {
        return (int) (canvas.getHeight() * (1 - (y - minY) / (maxY - minY)));
    }

    private double toWorldX(int xs) {
        return 1.0 * xs / canvas.getWidth() * (maxX - minX) + minX;
    }

    private double toWorldY(int ys) {
        return (1.0 * ys - canvas.getHeight()) /
                (-canvas.getHeight()) * (maxY - minY) + minY;
    }

    public void drawGraphics(ActionEvent actionEvent) {
//        double x1 = -4, y1 = -4, x2 = 4, y2 = 4;
//        int xs1 = toScreenX(x1);
//        int xs2 = toScreenX(x2);
//        int ys1 = toScreenY(y1);
//        int ys2 = toScreenY(y2);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        tabul();
//        gc.strokeLine(xs1,ys1,xs2,ys2);
        for (int i = 0; i < x.length - 1; i++) {
            int xs1 = toScreenX(x[i]);
            int xs2 = toScreenX(x[i + 1]);
            int ys1 = toScreenY(y[i]);
            int ys2 = toScreenY(y[i + 1]);
            gc.strokeLine(xs1,ys1,xs2,ys2);
        }
        gc.strokeLine(toScreenX(0), toScreenY(minY), toScreenX(0), toScreenY(maxY));
        gc.strokeLine(toScreenX(minX), toScreenY(0), toScreenX(maxX), toScreenY(0));
    }

    private void tabul() {
        for (int i = 0; i < 500; i++) {
            x[i] = toWorldX(i);
            y[i] = f(x[i]);
        }
    }

    double f(double x) {
        return Math.sin(x);
    }

    double[] x = new double[500];
    double[] y = new double[500];
}
