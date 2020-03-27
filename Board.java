import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class Board extends JPanel{
    int start = 2;
    //board
    private Coord[][] coords = new Coord[16][30];
    //tiles
    ImageIcon tileI = new ImageIcon("tile.png");
    private Image tile = tileI.getImage();  
    //tiles
    ImageIcon openedI = new ImageIcon("opened.png");
    private Image opened = openedI.getImage();
    //bombs
    ImageIcon bombI = new ImageIcon("bomb.png");
    private Image bomb = bombI.getImage();
    //flagged
    ImageIcon flagI = new ImageIcon("flag.png");
    private Image flag = flagI.getImage();  
    public Board() {
        
        initBoard();
        addMouseListener(new MouseAdapter(){
            @Override
                public void mouseClicked(MouseEvent e) {
                    int c =(e.getX())/30;
                    int r =(e.getY())/30;
                    coords[r][c].setState(coords[r][c].getImage());
                    System.out.println(r+", "+c);
                    repaint();
                }
        });
        setVisible(true);
    }
    private void initBoard(){
        loadImages();
        int w = bomb.getWidth(this);
        int h = bomb.getHeight(this);
        setPreferredSize(new Dimension(w,h));
    }
    private void loadImages(){
        int count =0;
        for(int j=0; j<16; j++){
            for(int i=0; i<30; i++){
                double r = Math.random();
                if(r<.2){
                    coords[j][i] = new Coord(j,i,3,0);
                }
                else{
                    coords[j][i] = new Coord(j,i,1,0);
                }
                count++;
            }
        }
        System.out.println(count + " things loaded");
    }
    
    @Override
    public void paintComponent(Graphics g){
            for(int r=0; r<16; r++){
                for(int c=0; c<30; c++){
                    if(coords[r][c].matchesState()==false){
                        Image image = tile;
                        g.drawImage(image,c*30,r*30,null);
                    }
                    else
                    {
                        Image image;
                        if(coords[r][c].getImage()==1)  image=opened;
                        else if(coords[r][c].getImage()==2)  image=flag;
                        else image=bomb;
                        g.drawImage(image,c*30,r*30,null);
                    }
                }
            }
    }
}