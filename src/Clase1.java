import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

//nancy.ruiz@
//Logo, Enunciado y númnero de control.
public class Clase1  extends JFrame
{

    public Clase1()
    {
        initComponents();
    }

    public static void main(String[] args) 
    {
        Clase1 objeto1 = new Clase1();
        objeto1.setVisible(true);
        objeto1.setSize(1244, 715);
        objeto1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        objeto1.setResizable(false);
        objeto1.setLocationRelativeTo(null);
    }

    private void initComponents() 
    {
        addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent evt) 
            {
                formKeyPressed(evt);
            }

        });
    }

    private void formKeyPressed(KeyEvent evt)
    {
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL ) 
        {
            setTitle("ctrl");
        }

        if (evt.getKeyCode() == KeyEvent.VK_C) 
        {
            setTitle("c");
        }

    }

}