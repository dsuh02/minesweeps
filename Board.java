import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Board extends JPanel{
    //board
    private Coord[][] coords = new Coord[16][30];
    //bombs
    ImageIcon bombI = new ImageIcon("bomb.png");
    private Image bomb = bombI.getImage();    
    //tiles
    ImageIcon tileI = new ImageIcon("tile.png");
    private Image tile = tileI.getImage();  
    //flagged
    ImageIcon flagI = new ImageIcon("flag.png");
    private Image flag = flagI.getImage();  
    public Board() {
        
        initBoard();
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
                    coords[j][i] = new Coord(j,i,bomb,0);
                }
                else{
                    coords[j][i] = new Coord(j,i,tile,0);
                }
                count++;
            }
        }
        System.out.println(count + " things loaded");
    }
    
    @Override
    public void paintComponent(Graphics g){
        for(int j=0; j<16; j++){
            for(int i=0; i<30; i++){
                Image image = coords[j][i].getImage();
                g.drawImage(image,i*30,j*30,null);
            }
        }
    }
}