package Imagen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{

    private String ruta = ".\\src\\Imagenes\\bodega.jpg";
    private BufferedImage I;

    public BufferedImage getI() {
        return I;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
         I=null;
        try{
            I=ImageIO.read(new File(ruta));
        }catch(IOException e){
            System.out.println("Fallo 404 consulte a los programadores buenorros");
        }
        g.drawImage(I, 0, 0, null);
    }
    public void suavizar(BufferedImage i, Graphics g){
        float[] difuminar ={
                0.111f, 0.111f, 0.111f,
                0.111f, 0.111f, 0.111f,
                0.111f, 0.111f, 0.111f};
        Kernel sharpkernel = new Kernel(3, 3, difuminar);
        ConvolveOp sop = new ConvolveOp(sharpkernel, ConvolveOp.EDGE_NO_OP,null);
        I = sop.filter(i, null);
        g.drawImage(I, 0, 0, null);
    }
    
    public void Realce(BufferedImage i,Graphics g){
        float[] resaltar ={
                    0.f, -1.f, 0.f,
                    -1.f, 5.0f, -1.f,
                    0.f, -1.f, 0.f};
        Kernel sharpkernel = new Kernel(3, 3, resaltar);
        ConvolveOp sop = new ConvolveOp(sharpkernel, ConvolveOp.EDGE_NO_OP,null);
        I = sop.filter(i, null);
        g.drawImage(I, 0, 0, null);
    }
}
