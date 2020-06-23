import java.util.Scanner;
public class Game
{
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
    //
    //
    //
    //three pole stacks
    private MyStack pole1 = new MyStack();
    private MyStack pole2 = new MyStack();
    private MyStack pole3 = new MyStack();
    public static final int GAP=285;
    public static final int POLE_WIDTH=15;
    public static final int POLE_HEIGHT=530;
    public static final int USABLE_POLE_HEIGHT=500;
    public static final int MAX_WIDTH=GAP+POLE_WIDTH;
    public static final int PLAYING=0;
    public static final int WON=1;
    private int numOfBlocks;
    private int diskHeight;
    private int changeWidth;
    private int turns=0;
    private int status=PLAYING;
    public Game()
    {
        Scanner k=new Scanner(System.in);
        System.out.print("How many Disks would you like to play with?(1-7)");
        int numOfBlocks2=k.nextInt();
        while(numOfBlocks2<1||numOfBlocks2>7)
        {
            System.out.print("How many Disks would you like to play with?(3-7)");
            numOfBlocks2=k.nextInt();
        }
        numOfBlocks=numOfBlocks2;
        diskHeight=USABLE_POLE_HEIGHT/numOfBlocks;
        changeWidth=MAX_WIDTH/numOfBlocks;
        //block1=biggest
        //block7=smallest
        for(int x=numOfBlocks-1;x>=0;x--)
        {
            pole1.push(x);
            System.out.println(x);
            System.out.println(pole1.peek());
        }
    }
    public int getNumOfBlocks() {
        return numOfBlocks;
    }

    public void setNumOfBlocks(int numOfBlocks) {
        this.numOfBlocks = numOfBlocks;
    }
    public int getDiskHeight() {
        return diskHeight;
    }
    public void setDiskHeight(int diskHeight) {
        this.diskHeight = diskHeight;
    }
    public MyStack getPole1() {
        return pole1;
    }

    public void setPole1(MyStack pole1) {
        this.pole1 = pole1;
    }

    public MyStack getPole2() {
        return pole2;
    }

    public void setPole2(MyStack pole2) {
        this.pole2 = pole2;
    }

    public MyStack getPole3() {
        return pole3;
    }

    public void setPole3(MyStack pole3) {
        this.pole3 = pole3;
    }
    public int getChangeWidth() {
    return changeWidth;
}

    public void setChangeWidth(int changeWidth) {
        this.changeWidth = changeWidth;
    }
    public void shiftBlock(int selected1, int selected2)
    {
        System.out.println(selected1+", "+selected2);
        if (selected1 == 1 && selected2 == 2 &&(pole2.empty() || (int)(pole1.peek())>(int)(pole2.peek())))
        {
            //System.out.println(pole1.peek());
            if(pole2.empty())
            {
                pole2.push(pole1.peek());
                pole1.pop();
                turns++;
                return;
            }
            pole2.add(pole1.peek());
            pole1.pop();
            turns++;
            return;
        }
        else if (selected1 == 1 && selected2 == 3 &&(pole3.empty() ||(int) (pole1.peek())>(int)(pole3.peek())))
        {
            if(pole3.empty())
            {
                pole3.push(pole1.peek());
                pole1.pop();
                turns++;
                return;
            }
            System.out.println("I am in the 1, 3 method");
            System.out.println(selected1+","+selected2);
            pole3.add(pole1.peek());
            pole1.pop();
            turns++;
            return;
        }
        else if (selected1 == 2 && selected2 == 1 &&( pole1.empty() || (int)(pole2.peek())>(int)(pole1.peek())))
        {
            if(pole1.empty())
            {
                pole1.push(pole2.peek());
                pole2.pop();
                turns++;
                return;
            }
            System.out.println("in the 2, 1 method");
            System.out.println(selected1+", "+selected2);
            pole1.add(pole2.peek());
            pole2.pop();
            turns++;
            return;
        }
        else if (selected1 == 2 && selected2 == 3 &&(pole3.empty() || (int)(pole2.peek())>(int)(pole3.peek())))
        {
            if(pole3.empty())
            {
                pole3.push(pole2.peek());
                pole2.pop();
                turns++;
                return;
            }
            pole3.add(pole2.peek());
            pole2.pop();
            turns++;
            return;
        }
        else if (selected1 == 3 && selected2 == 2 &&(pole2.empty() ||(int)(pole3.peek())>(int)(pole2.peek())))
        {
            if(pole2.empty())
            {
                pole2.push(pole3.peek());
                pole3.pop();
                turns++;
                return;
            }
            System.out.println("in the method");
            pole2.add(pole3.peek());
            System.out.println(pole3.peek()+"was added to pole two");
            System.out.print(pole3.pop()+"was removed from pole 3");
            turns++;
            return;
        }
        else if (selected1 == 3 && selected2 == 1 &&(pole1.empty() || (int)(pole3.peek())>(int)(pole1.peek())))
        {
            if(pole1.empty())
            {
                pole1.push(pole3.peek());
                pole3.pop();
                turns++;
                return;
            }
            pole1.add(pole3.peek());
            pole3.pop();
            turns++;
            return;
        }
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
