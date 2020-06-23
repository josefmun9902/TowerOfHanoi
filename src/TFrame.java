import java.awt.*;
import javax.swing.*;
public class TFrame extends JFrame
{
    public TFrame(String title)
    {
        super(title);
        setDefaultCloseOperation(TFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        TPanel o=new TPanel();
        Insets insets=getInsets();
        int width=o.getWidth()+insets.left+insets.right;
        int height=o.getHeight()+insets.top+insets.bottom;
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        add(o);
        pack();
        setVisible(true);
    }
}
