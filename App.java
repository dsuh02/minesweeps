import java.awt.EventQueue;
import javax.swing.JFrame;

public class App extends JFrame {
    public App(){
        initUI();
    }
    private void initUI(){
        setSize(950,520);
        
        add(new Board());
        
        setVisible(true);
        
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            App ex = new App();
            ex.setVisible(true);
       });
    }
    
}