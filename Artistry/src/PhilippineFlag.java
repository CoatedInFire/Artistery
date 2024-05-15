import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class PhilippineFlag extends GraphicsProgram {

    public void run() {
        drawPhilippineFlag();
    }

    private void drawPhilippineFlag() {
        Flag flag = new Flag();
        flag.drawFlag();
    }

    class Flag {
        private static final Color BLUE = new Color(0, 56, 168);
        private static final Color RED = new Color(206, 17, 38);
        private static final Color WHITE = Color.WHITE;

        public void drawFlag() {
            // Draw the blue part
            GRect blueRect = new GRect(50, 50, 300, 100);
            blueRect.setFilled(true);
            blueRect.setFillColor(BLUE);
            add(blueRect);

            // Draw the red part
            GRect redRect = new GRect(50, 150, 300, 100);
            redRect.setFilled(true);
            redRect.setFillColor(RED);
            add(redRect);

            // Draw the white triangle
            GPolygon triangle = new GPolygon();
            triangle.addVertex(50, 50);
            triangle.addVertex(50, 250);
            triangle.addVertex(250, 150);
            triangle.setFilled(true);
            triangle.setFillColor(WHITE);
            add(triangle);

            // Draw the sun
            GOval sun = new GOval(90, 110, 50, 50);
            sun.setFilled(true);
            sun.setFillColor(Color.YELLOW);
            add(sun);

            // Draw sun rays (thicker)
            for (int i = 0; i < 8; i++) {
                double angle = i * 45;
                drawThickRay(115, 135, 115 + 50 * Math.cos(Math.toRadians(angle)), 135 + 50 * Math.sin(Math.toRadians(angle)));
            }

            // Draw stars
            drawStar(75, 75, 20);
            drawStar(75, 225, 20);
            drawStar(200, 150, 20);

            // Signature
            GLabel signature = new GLabel("Gavin");
            signature.setFont("Serif-italic-12");
            add(signature, getWidth() - 50, getHeight() - 10);
        }

        private void drawThickRay(double x1, double y1, double x2, double y2) {
            double dx = x2 - x1;
            double dy = y2 - y1;
            double length = Math.sqrt(dx * dx + dy * dy);
            double unitX = dx / length;
            double unitY = dy / length;

            double thickness = 3; // Adjust the thickness here
            double offsetX = -unitY * thickness;
            double offsetY = unitX * thickness;

            GLine ray1 = new GLine(x1 + offsetX, y1 + offsetY, x2 + offsetX, y2 + offsetY);
            GLine ray2 = new GLine(x1 - offsetX, y1 - offsetY, x2 - offsetX, y2 - offsetY);
            GLine ray3 = new GLine(x1, y1, x2, y2); // Central line

            ray1.setColor(Color.YELLOW);
            ray2.setColor(Color.YELLOW);
            ray3.setColor(Color.YELLOW);

            add(ray1);
            add(ray2);
            add(ray3);
        }

        private void drawStar(double x, double y, double radius) {
            GPolygon star = new GPolygon();
            for (int i = 0; i < 5; i++) {
                star.addVertex(radius * Math.cos(Math.toRadians(72 * i - 90)),
                        radius * Math.sin(Math.toRadians(72 * i - 90)));
                star.addVertex(radius / 2.5 * Math.cos(Math.toRadians(72 * i + 36 - 90)),
                        radius / 2.5 * Math.sin(Math.toRadians(72 * i + 36 - 90)));
            }
            star.setFilled(true);
            star.setFillColor(Color.YELLOW);
            add(star, x, y);
        }
    }

    public static void main(String[] args) {
        (new PhilippineFlag()).start(args);
    }
}