
/**
 *  Author:      Jad Ariss
 *  Lab:         LA2.1 - Benzene 
 *  Description: Creates a piece of paper and a pencil,
 *               and draws a benzene symbol.

 */
import apcslib.*;
public class Benzene
{
    public static void main(String[]args){
        DrawingTool pencil;
        SketchPad poster;

        poster = new SketchPad(600,600);
        pencil = new DrawingTool(poster);
        
        //draw Hexagon
        pencil.setDirection(0);
        pencil.forward(100);
        for(int i = 0; i < 5; i++){
            pencil.turnLeft(60);
            pencil.forward(100);
        }
        
        //draw Circle
        pencil.up();
        pencil.move(50, 85);
        pencil.down();
        pencil.drawCircle(75);


    }
}
