import java.awt.Image;

public class Coord{
    private int x,y,i,state; // 0-covered 1-opened 2-flagged 3-exploded
    public Coord(int x, int y, int i, int s){
        this.x=x;
        this.y=y;
        this.i=i;
        this.state = s;
    }
    public int getDown(){ return x;}    
    public int getRight(){ return y;}
    public int getImage(){ return i;}
    public int getState(){ return state;}
    public void setState(int s){ state=s;}
    public boolean matchesState(){
        if(state==i)
            return true;
        return false;
    }
}