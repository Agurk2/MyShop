import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class Login will display a login screen. On this login screen, there is an option to input both a user id and a password.
 * If both the user id and the password matches with the predetermined set, then this class will be disposed and 
 * the class Shop will be excecuted.
 *
 * @author onorregaard
 * @version 3.2.2020
 */
public class Login extends JFrame
{
    // Instance variables
    private Container contents;
    private JLabel userID, enterPassword, message;
    private JTextField id; 
    private JPasswordField password;
    /**
     * Constructor for objects of class Login
     */
    public Login()
    {
        super("Login");
        contents = getContentPane();
        contents.setLayout(new FlowLayout());
        
        // Setup components
        userID = new JLabel("User ID");
        id = new JTextField( "", 12);

        enterPassword = new JLabel("Enter Password");
        
        password = new JPasswordField(12);
        password.setEchoChar('*');
        

        message = new JLabel("Log in above ");

        
        
        contents.add(userID);
        contents.add(id);
        contents.add(enterPassword);
        contents.add(password);
        contents.add(message);
        
        // Add listeners
        Action tfh = new Action();
        
        id.addActionListener(tfh);
        password.addActionListener(tfh);
        
        // Formatting
        getContentPane().setBackground(Color.LIGHT_GRAY);
        enterPassword.setPreferredSize(new Dimension(138, 10));
        setSize(350,120);
        setResizable(false);
        setVisible(true);
    }

    private class Action implements ActionListener
    {
        /**
         * Action handler for class Login. This method will allow the user to get results when interacting with components
         * on the screen. The class Login is disposed when the correct login credential are inputted, as to optimize the 
         * program.
         */
        public void actionPerformed(ActionEvent e)
        {
            if(id.getText().equals("a")
            && (new String(password.getPassword())).equals("a"))
            {
                message.setForeground(Color.BLACK);
                message.setText("Welcome to the shop!");
                Shop testclass = new Shop();
                dispose();
            }
            else
            {
                message.setForeground(Color.RED);
                message.setText("WRONG LOGIN CREDENTIALS");
            }
        }
    }
    
    
}
