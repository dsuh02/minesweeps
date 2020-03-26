import java.awt.Image;

public class Coord{
    private int x,y;
    private Image image;
    private int state;
    public Coord(int x, int y, Image i, int s){
        this.x=x;
        this.y=y;
        this.image=i;
        this.state = s;
    }
    public int getDown(){ return x;}    
    public int getRight(){ return y;}
    public Image getImage(){ return image;}
}