import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This is the beginning class for the program. This class will greet the user and set them onto their journey. No variables
 * are inherited from other classes
 *
 * @author onorregaard
 * @version 3.2.2020
 */
public class Welcome extends JFrame
{
    private Container contents;
    private JLabel message, imageLabel;
    private JButton button;
    private ImageIcon [] food =
        {  new ImageIcon("Beans.jpg"), };
    /**
     * Constructor for objects of class Welcome
     */
    public Welcome()
    {
        super("The Bean Shop");
        contents = getContentPane();
        contents.setLayout(new FlowLayout());
        // Setup components
        message = new JLabel (" Want the best beans around?");
        message.setFont(new Font("Times New Roman", Font.BOLD, 18));

        button = new JButton("Come on in!");
        button.setPreferredSize(new Dimension(150, 40));
        button.setForeground(Color.BLUE);
        button.setFont(new Font("Times New Roman", Font.BOLD, 20)); 

        imageLabel = new JLabel(food[0]);
        
        // Add listeners
        ButtonHandler bh = new ButtonHandler();

        button.addActionListener(bh);

        contents.add(message);
        contents.add(button);
        contents.add(imageLabel);

        // Formating
        getContentPane().setBackground(Color.WHITE);

        setSize(350, 480);
        setResizable(false);
        setVisible(true);

    }
    private class ButtonHandler implements ActionListener
    {
        /**
         * The class Welcome is disposed when the button is pressed, as to optimize the 
         * program.
         */
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == button)
            {
                Login login = new Login();
                dispose();
            }
        }
    }

    public static void main(String [] args)
    {
        Welcome welcome = new Welcome();
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}