import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.ArrayList;
/**
 * This class will allow the user to pick and choose your favourite beans. 
 * They will be able to choose brand, quantity and wheter they want their beans cooked or not. 
 * This information will be transfered to the class Recipt
 *
 * @author Onorregaard
 * @version 12.3.20
 */
public class Shop extends JFrame
{
    // instance variables - replace the example below with your own
    private final Container contents;
    private final String brand[] = {"Heinz            £0.05 pr. gram", "Vans Camp   £0.025 pr. gram", "Bush's           £0.01 pr. gram"};
    private final String plusMinus[] = {"+", "-"};
    private final JComboBox comboBox;
    private JComboBox plusOrMinus;
    private final ImageIcon [] foods =
        {  new ImageIcon("Heinz.png"),
            new ImageIcon("VansCamp.png"),
            new ImageIcon("BushBean.png")};
    public static ArrayList<Double> quantity = new ArrayList<Double>(); 
    public static ArrayList <String> brandChoice = new ArrayList<String>();
    public static ArrayList <Boolean> cookedOrNot = new ArrayList<Boolean>();
    private final JLabel imageLabel;
    private final JLabel gramDisplay;
    private final ButtonGroup group = new ButtonGroup();
    private final JRadioButton optionCooked = new JRadioButton("Cooked + £0.5", true);
    private final JRadioButton optionNotCooked = new JRadioButton("Not Cooked             ");
    private final JTextArea message;
    private final JCheckBox quantity50, quantity100, quantity150, quantity200;
    public double quantityHolder;
    private boolean addOrSubtract;
    private final JButton AddToCart;
    private final JButton Finish;
    
    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        super("Shop");
        contents = getContentPane();
        contents.setLayout(new FlowLayout());

        message = new JTextArea("                       Welcome to the shop! \n 1) Start off by choosing your favorite brand \n 2) Then, choose whether you want your beans cooked or not \n 3) Now choose a quantity (every box you click adds together) \n When you're done, press add to cart. \n If you want to keep shopping just choose a new item, \n if not, press print recipt", 5, 20);
        message.setFont(new Font("Serif", Font.ITALIC, 11));
        message.setEditable(false);
        message.setOpaque(false);

        comboBox = new JComboBox<>(brand);
        comboBox.setPreferredSize(new Dimension(230, 20));
        comboBox.setMaximumRowCount( 4 );
        comboBox.setSelectedIndex(2);

        plusOrMinus = new JComboBox(plusMinus);

        addOrSubtract = true;

        quantity50 = new JCheckBox("50g");
        quantity100 = new JCheckBox("100g");
        quantity150 = new JCheckBox("150g");
        quantity200 = new JCheckBox("200g");

        gramDisplay = new JLabel("                " + quantityHolder + " g");
        imageLabel = new JLabel(foods[2]);

        AddToCart = new JButton("Add To Cart");
        Finish = new JButton("Finish");
       
        ActionHandler al = new ActionHandler();
        optionCooked.addActionListener(al);
        optionNotCooked.addActionListener(al);
        quantity50.addActionListener(al);
        quantity100.addActionListener(al);
        quantity150.addActionListener(al);
        quantity200.addActionListener(al);
        plusOrMinus.addItemListener(al);
        comboBox.addItemListener(al);
        AddToCart.addActionListener(al);
        Finish.addActionListener(al);
        //Group together buttons
        group.add(optionCooked);
        group.add(optionNotCooked);
        // Add components to contents
        contents.add(message);
        contents.add(comboBox);
        contents.add(optionCooked);
        contents.add(optionNotCooked);
        contents.add(plusOrMinus);
        contents.add(quantity50);
        contents.add(quantity100);
        contents.add(quantity150);
        contents.add(quantity200);
        contents.add(gramDisplay);
        contents.add(imageLabel);
        contents.add(AddToCart);
        contents.add(Finish);

        setVisible(true);
        setResizable(false);
        setSize(360, 560);
    } 

    public class ActionHandler implements ActionListener, ItemListener
    {
        /**
         * Handles item changes such as combo boxes.
         * 
         * Precondition: either comboBox or plusOrMinus has been changed
         * 
         * Postcondition: comboBox's image or plusOrMinus has been changed to it's new appropriate state
         */
        @Override
        public void itemStateChanged( ItemEvent ie )
        {
            int index = comboBox.getSelectedIndex( );
            imageLabel.setIcon( foods[index] );
            if(plusOrMinus.getSelectedIndex() == 0)
            {
                addOrSubtract = true;
            }
            else
            {
                addOrSubtract = false;
            }
        }
        /**
         * Handles action events such as button changes, check boxes and radio buttons.
         * 
         * Precondition: either Finish, AddToCart, optionCooked, comboBox, quantity(50, 100, 150, 200) has been changed
         * 
         * Postcondition: the changed action has been changed to it's new appropriate state
         */
        public void actionPerformed(ActionEvent e)
        {
            
            if(e.getSource() == Finish)
            {
                Receipt r = new Receipt();
                setVisible(false);
            }
            else if(e.getSource() == AddToCart)
            {
                if(optionCooked.isSelected())
                {
                    cookedOrNot.add(true);
                }
                else
                {
                    cookedOrNot.add(false);
                }
                quantity.add(quantityHolder);
                if(comboBox.getSelectedItem().equals("Heinz            £0.05 pr. gram"))
                {
                    brandChoice.add("Heinz");
                }
                else if(comboBox.getSelectedItem().equals("Vans Camp   £0.025 pr. gram"))
                {
                    brandChoice.add("Vans Camp");
                }
                else if(comboBox.getSelectedItem().equals("Bush's           £0.01 pr. gram"))
                {
                    brandChoice.add("Bush's");
                }
                
            }
            // Changes the quantity
            if(e.getSource() == quantity50)
            {
                if(addOrSubtract == true)
                {
                    quantityHolder += 50;
                    gramDisplay.setText("                " + quantityHolder + " g");
                    quantity50.setSelected(false);
                }
                if(addOrSubtract == false && quantityHolder - 50 >= 0)
                {
                    quantityHolder -= 50;
                    gramDisplay.setText("                " + quantityHolder + " g");
                    quantity50.setSelected(false);
                }
                else
                {
                    quantity50.setSelected(false);
                }
            }
            else if(e.getSource() == quantity100)
            {
                if(addOrSubtract == true)
                {
                    quantityHolder += 100;
                    gramDisplay.setText("                " + quantityHolder + " g");
                    quantity100.setSelected(false);
                }
                else if(addOrSubtract == false && quantityHolder - 100 >= 0)
                {
                    quantityHolder -= 100;
                    gramDisplay.setText("                " + quantityHolder + " g");
                    quantity100.setSelected(false);
                }
                else
                {
                    quantity100.setSelected(false);
                }
            }
            else if(e.getSource() == quantity150)
            {
                if(addOrSubtract == true)
                {
                    quantityHolder += 150;
                    gramDisplay.setText("                " + quantityHolder + " g");
                    quantity150.setSelected(false);
                }
                else if(addOrSubtract == false && quantityHolder - 150 >= 0)
                {
                    quantityHolder -= 150;
                    gramDisplay.setText("                " + quantityHolder + " g");
                    quantity150.setSelected(false);
                }
                else
                {
                    quantity150.setSelected(false);
                }
            }
            else if(e.getSource() == quantity200)
            {
                if(addOrSubtract == true)
                {
                    quantityHolder += 200;
                    gramDisplay.setText("                " + quantityHolder + " g");
                    quantity200.setSelected(false);
                }
                else if(quantityHolder - 200 >= 0) 
                {
                    quantityHolder -= 200;
                    gramDisplay.setText("                " + quantityHolder + " g");
                    quantity200.setSelected(false);
                }
                else
                {
                    quantity200.setSelected(false);
                }
            }

        }
    }
    
}
