import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.math.*;
/**
 * Class Receipt will display the values chosen in class Shop, with the appropriate calculations, and display the final
 * total. This total will include a 20% VAT (because who doesn't love taxes?). This is the final class in the program.
 * There is no way to go back to class Shop, as you've finished your purchase. To restart, launch class Welcome.
 *
 * @author onorregaard
 * @version 12.3.20
 */
public class Receipt extends JFrame
{
    private final Container contents;
    private final JTextArea textArea;
    private String cookedOrNot;
    private double totalBeforeTax, totalAfterTax = 0.0, total;
    /**
     * Constructor for class Receipt
     */
    public Receipt()
    {
        super("Receipt");
        contents = getContentPane();
        contents.setLayout(new FlowLayout());

        textArea = new JTextArea("                                   Shop \n                                 KT11 1BL \n \n  ------------------------------------\n Order: \n" );
        // Sets the text area to the values chosen in class Shop. Also formats said text area.
        for(int i = 0; i < Shop.brandChoice.size(); i++)
        {
            double brand = 0, cookedPrice;
            textArea.append("   - " + Shop.brandChoice.get(i) + "\n");
            // Sets up the brandChoice for calculation
            if(Shop.brandChoice.get(i).equals("Bush's"))
            {
                brand = 0.01;
            }
            else if(Shop.brandChoice.get(i).equals("Vans Camp"))
            {
                brand = 0.025;
            }
            else if(Shop.brandChoice.get(i).equals("Heinz"))
            {
                brand = 0.05;
            }
            textArea.append("    " + Shop.quantity.get(i) + "g" + "                                             + £" + Shop.quantity.get(i) * brand + "\n");
            // Sets up cookedOrNot for later calculation
            if(Shop.cookedOrNot.get(i) == true)
            {
                cookedOrNot = " Cooked                                            + £";
                cookedPrice = 0.5;
            }
            else
            {
                cookedOrNot = " Not cooked                                      + £";
                cookedPrice = 0;
            }
            textArea.append("   " + cookedOrNot + cookedPrice + "\n");
            totalBeforeTax = totalBeforeTax + Shop.quantity.get(i)*brand + cookedPrice;
            total = total + Shop.quantity.get(i)*brand + cookedPrice;
        }
        totalBeforeTax = totalBeforeTax*0.2;
        // Fixes an error with the multiplication
        BigDecimal bd = new BigDecimal(totalBeforeTax);
        bd = bd.round(new MathContext(3));
        double rounded = bd.doubleValue();
        
        totalAfterTax = total + totalBeforeTax;
        textArea.append("  ------------------------------------" + "\n                                             20% VAT + £" + rounded + "\n                                                     Total: £" + totalAfterTax);
        textArea.setEditable(false);
        
        contents.add(textArea);
        
        // Formatting
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setResizable(true);
        setSize(360, 800);
    }
    
}
