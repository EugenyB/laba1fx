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
        double x1 = -4, y1 = -4, x2 = 4, y2 = 4;
        int xs1 = toScreenX(x1);
        int xs2 = toScreenX(x2);
        int ys1 = toScreenY(y1);
        int ys2 = toScreenY(y2);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeLine(xs1,ys1,xs2,ys2);
    }
}
