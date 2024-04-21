import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

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
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            UIManager.put("Button.font", FONT_NORMAL);
            UIManager.put("ToggleButton.font", FONT_NORMAL);
            UIManager.put("RadioButton.font", FONT_NORMAL);
            UIManager.put("CheckBox.font", FONT_NORMAL);
            UIManager.put("ColorChooser.font", FONT_NORMAL);
            UIManager.put("ComboBox.font", FONT_NORMAL);
            UIManager.put("Label.font", FONT_NORMAL);
            UIManager.put("List.font", FONT_NORMAL);
            UIManager.put("MenuBar.font", FONT_NORMAL);
            UIManager.put("MenuItem.font", FONT_NORMAL);
            UIManager.put("RadioButtonMenuItem.font", FONT_NORMAL);
            UIManager.put("CheckBoxMenuItem.font", FONT_NORMAL);
            UIManager.put("Menu.font", FONT_NORMAL);
            UIManager.put("PopupMenu.font", FONT_NORMAL);
            UIManager.put("OptionPane.font", FONT_NORMAL);
            UIManager.put("Panel.font", FONT_NORMAL);
            UIManager.put("ProgressBar.font", FONT_NORMAL);
            UIManager.put("ScrollPane.font", FONT_NORMAL);
            UIManager.put("Viewport.font", FONT_NORMAL);
            UIManager.put("TabbedPane.font", FONT_NORMAL);
            UIManager.put("Table.font", FONT_NORMAL);
            UIManager.put("TableHeader.font", FONT_NORMAL);
            UIManager.put("TextField.font", FONT_NORMAL);
            UIManager.put("PasswordField.font", FONT_NORMAL);
            UIManager.put("TextArea.font", FONT_NORMAL);
            UIManager.put("TextPane.font", FONT_NORMAL);
            UIManager.put("EditorPane.font", FONT_NORMAL);
            UIManager.put("TitledBorder.font", FONT_NORMAL);
            UIManager.put("ToolBar.font", FONT_NORMAL);
            UIManager.put("ToolTip.font", FONT_NORMAL);
            UIManager.put("Tree.font", FONT_NORMAL);

        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame("Graph Algorithm Visualizer");
        setPanel(new Board().getPanel());
        frame.setLocationRelativeTo(null);
    }

}
