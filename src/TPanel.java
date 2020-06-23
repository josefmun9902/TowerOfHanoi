import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*Math Stuff
max_width=gap+pole_width
disk_height=used_height/ num of disks
change_width=max_width/num of disks
//
//
//
when drawing rectangles
x=pole.x-(disk_width-pole_width)/2
y=base.height-(Math)*disk_height
*/
public class TPanel extends JPanel implements MouseListener, KeyListener
{
    private int numOfBlocks;
    private Game game = new Game();
    private int selected1=0;
    private int selected2=0;
    public TPanel()
    {
        super();
        setSize(900, 620);
        //add the mouse listener
        addMouseListener(this);
        addKeyListener(this);
    }
    public void paint(Graphics g)
    {

        //white background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 901, 620);
        //ground
        g.setColor(Color.GRAY);
        g.fillRect(0, 580, 901, 40);
        //poles
        g.setColor(Color.BLACK);
        g.fillRoundRect(game.GAP/2, 50, 15, game.POLE_HEIGHT, 10, 10);
        g.fillRoundRect(game.GAP*2-game.GAP/2+game.POLE_WIDTH, 50, 15, game.POLE_HEIGHT, 10, 10);
        g.fillRoundRect(game.GAP*3-game.GAP/2+game.POLE_WIDTH*2, 50, 15, game.POLE_HEIGHT, 10, 10);
        //drawing blocks
        //x=pole.x-(disk_width-pole_width)/2
        //y=base.height-(Math)*disk_height
        g.setColor(Color.GREEN);
        for(int x=0;x<game.getPole1().size();x++)
        {
            g.fillRoundRect(148-((game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole1().get(x)))))/2 ,580-game.getDiskHeight()*(x+1), (game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole1().get(x)))), game.getDiskHeight() , 10, 10);
            g.setColor(Color.BLACK);
            g.drawRoundRect(148-((game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole1().get(x)))))/2 ,580-game.getDiskHeight()*(x+1), (game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole1().get(x)))), game.getDiskHeight() , 10, 10);
            g.setColor(Color.GREEN);
        }
        for(int x=0;x<game.getPole2().size();x++)
        {
            g.fillRoundRect(164-((game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole2().get(x)))))/2+game.GAP,580-game.getDiskHeight()*(x+1), (game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole2().get(x)))), game.getDiskHeight() , 10, 10);
            g.setColor(Color.BLACK);
            g.drawRoundRect(164-((game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole2().get(x)))))/2+game.GAP,580-game.getDiskHeight()*(x+1), (game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole2().get(x)))), game.getDiskHeight() , 10, 10);
            g.setColor(Color.GREEN);
        }
        for(int x=0;x<game.getPole3().size();x++)
        {
            g.fillRoundRect(164-((game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole3().get(x)))))/2+game.GAP*2+game.POLE_WIDTH,580-game.getDiskHeight()*(x+1), (game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole3().get(x)))), game.getDiskHeight() , 10, 10);
            g.setColor(Color.BLACK);
            g.drawRoundRect(164-((game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole3().get(x)))))/2+game.GAP*2+game.POLE_WIDTH,580-game.getDiskHeight()*(x+1), (game.MAX_WIDTH-game.getChangeWidth()*(int)((game.getPole3().get(x)))), game.getDiskHeight() , 10, 10);
            g.setColor(Color.GREEN);
        }
        //poles become red if selected
        g.setColor(Color.RED);
        if(selected1>0&&selected2>0)
        {
            game.shiftBlock(selected1, selected2);
            selected1=0;
            selected2=0;
        }
        if(selected1==1)
        {
            g.fillRoundRect(game.GAP/2, 50, 15, game.POLE_HEIGHT, 10, 10);
        }
        if(selected1==2)
        {
            g.fillRoundRect(game.GAP*2-game.GAP/2+game.POLE_WIDTH, 50, 15, game.POLE_HEIGHT, 10, 10);
        }
        if(selected1==3)
        {
            g.fillRoundRect(game.GAP*3-game.GAP/2+game.POLE_WIDTH*2, 50, 15, game.POLE_HEIGHT, 10, 10);
        }
        if(game.getPole3().size()==game.getNumOfBlocks())
        {
            g.setColor(Color.RED);
            game.setStatus(Game.WON);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g.drawString("You won in "+(game.getTurns())+" turns!" , 200, 200);
            repaint();
            return;
        }
        repaint();
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {}
    public void mouseReleased(MouseEvent e)
    { }
    public void mouseEntered(MouseEvent e)
    {}
    public void mouseExited(MouseEvent e)
    {}
    public void keyPressed(KeyEvent e)
    {
        //System.out.println(game.getPole2().empty());
        if(e.getKeyChar()=='1'&&selected2==0&&selected1==0&&game.getPole1().empty())
        {
            return;
        }
        if(e.getKeyChar()=='2'&&selected2==0&&selected1==0&&game.getPole2().empty())
        {
            return;
        }
        if(e.getKeyChar()=='3'&&selected2==0&&selected1==0&&game.getPole3().empty())
        {
            return;
        }
        if(e.getKeyChar()=='1'&&game.getStatus()==game.PLAYING)
        {
            if(selected1==1)
            {
                selected1=0;
            }
            else if(selected1==0)
            {
                selected1=1;
            }
            else if(selected1==2||selected1==3)
            {
                selected2=1;
            }
            else if(selected1==2&&selected2==0)
            {
                selected2=1;
            }
            else if(selected1==3&&selected2==0)
            {
                selected2=1;
            }
        }
        if(e.getKeyChar()=='2'&&game.getStatus()==game.PLAYING)
        {
            if(selected1==2)
            {
                selected1=0;
            }
            else if(selected1==0)
            {
                selected1=2;
            }
            else if(selected1==1||selected1==3)
            {
                selected2=2;
            }
            else if(selected1==1&&selected2==0)
            {
                selected2=2;
            }
            else if(selected1==3&&selected2==0)
            {
                selected2=2;
            }
        }
        if(e.getKeyChar()=='3'&&game.getStatus()==game.PLAYING)
        {
            if(selected1==3)
            {
                selected1=0;
            }
            else if(selected1==0)
            {
                selected1=3;
            }
            else if(selected1==2||selected1==1)
            {
                selected2=3;
            }
            else if(selected1==2&&selected2==0)
            {
                selected2=3;
            }
            else if(selected1==2&&selected2==0)
            {
                selected2=3;
            }
        }
        repaint();
    }
    public void keyReleased(KeyEvent e)
    {}
    public void keyTyped(KeyEvent e)
    {}
    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
}

