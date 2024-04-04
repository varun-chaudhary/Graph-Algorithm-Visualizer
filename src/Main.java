import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public final static int MENU_WIDTH = 250;
    public final static int FRAME_HEIGHT = 800;
    public final static int FRAME_WIDTH = MENU_WIDTH + FRAME_HEIGHT;
    public final static int MENU_PADDING = 10;
    public static JFrame frame;

    public final static Font FONT_TITLE = loadFont("Roboto-Bold", 22),
            FONT_HEADER = loadFont("Roboto-Medium", 14),
            FONT_SUBHEADER = loadFont("Roboto-Regular", 18),
            FONT_NORMAL = loadFont("Roboto-Regular", 12),
            FONT_NORMAL_ITALICS = loadFont("Roboto-Italic", 12);

    public static void setPanel(JPanel changePanel) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(changePanel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static Font loadFont(String fontName, int fontSize) {
        Font font = null;
        try {
            font = Font.createFont(Font.PLAIN, new File("assets/font/" + fontName + ".ttf")).deriveFont(Font.PLAIN,
                    fontSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return font;
    }

    public static void centerJButton(JButton button, int width) {
        int center = width / 2;
        int butWidth = button.getWidth();
        int centeredX = center - (butWidth / 2);

        button.setLocation(centeredX, button.getY());
    }

    public static void main(String[] args) {

        frame = new JFrame("Pathfinding Visualizer");
        setPanel(new Board().getPanel());
        frame.setLocationRelativeTo(null);
    }

}
