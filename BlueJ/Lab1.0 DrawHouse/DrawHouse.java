import apcslib.*;

public class DrawHouse
{
    /**
     * Write a description of class DrawHouse here.
     * This will draw a house
     * @author (your name)
     * @version (a version number or a date)
     */
    public static void main(String[] args)
    {
        DrawingTool pencil;
        SketchPad paper;

        paper = new SketchPad(500, 500);
        pencil = new DrawingTool(paper);

        // draw the rectangle
        pencil.forward(100);
        pencil.turnLeft(90);
        pencil.forward(200);
        pencil.turnLeft(90);
        pencil.forward(100);
        pencil.turnLeft(90);
        pencil.forward(200);
        
        //draw the roof
        pencil.up();
        pencil.turnLeft(90);
        pencil.move(100);
        pencil.down();
        pencil.turnLeft(75);
        pencil.forward(105);
        pencil.turnLeft(30);
        pencil.forward(102);
        
        
        //draw the door
        pencil.up();
        pencil.move(-110,0);
        pencil.down();
        pencil.setDirection(90);
        pencil.forward(30);
        pencil.setDirection(0);
        pencil.forward(20);
        pencil.setDirection(-90);
        pencil.forward(30);
        
        //draw the window
        pencil.up();
        pencil.move(-150, 75);
        pencil.down();
        pencil.setDirection(0);
        pencil.forward(15);
        pencil.turnRight(90);
        pencil.forward(15);
        pencil.turnRight(90);
        pencil.forward(15);
        pencil.turnRight(90);
        pencil.forward(15);
        
        //2nd window
        pencil.up();
        pencil.move(-50, 75);
        pencil.down();
        pencil.forward(15);
        pencil.turnRight(90);
        pencil.forward(15);
        pencil.turnRight(90);
        pencil.forward(15);
        pencil.turnRight(90);
        pencil.forward(15);

        }
}


