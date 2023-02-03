import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Write a description of class Welcome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Welcome extends JFrame
{
    private Container contents;
    private JLabel  message;
    private JButton button;
    public Welcome()
    {
        super("The Bean Shop");
        contents = getContentPane();
        contents.setLayout(new FlowLayout());
        
        message = new JLabel("Want the best beans around? Come on in!", 15);
        
        button = new JButton("Button.JPG");
        
        contents.add(message);
    }   
}
