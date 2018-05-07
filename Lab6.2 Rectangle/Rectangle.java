import apcslib.*;
public class Rectangle
{
    private double myX;      // the x coordinate of the rectangle
    private double myY;      // the y coordinate of the rectangle
    private double myWidth;  // the width of the rectangle
    private double myHeight; // the height of the rectangle

    // Creates a 500 x 500 SketchPad with a DrawingTool, pen, that is used
    // to display Rectangle objects. The Drawingtool is declared static
    // so that multiple Rectangle objects can be drawn on the Sketchpad
    // at the same time.
    private static DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
    public Rectangle(){
        this.myX = 0;
        this.myY = 0;
        this.myWidth = 0;
        this.myHeight = 0;
    }
    public Rectangle(double x, double y, double width, double height){
        myX = x;
        myY = y;
        myHeight = height;
        myWidth = width;
    }
    
    // calculates and returns the perimeter of the rectangle
    public double getPerimeter(){
        return (myWidth*2) + (myHeight * 2);
    }

    // Calculates and returns the are of the rectangle.
    public double getArea(){
        return myWidth * myHeight;
    }
    // Draws a new instance of a Rectangle object with the left and right
    // edges of the rectangle at x and x + width. The top and bottom edges
    // are at y and y + height.
    public void draw(){
        pen.up();
        pen.move(myX, myY);
        pen.down();
        pen.setDirection(0);
        for(int i = 0; i < 2; i++){
            pen.forward(myWidth);
            pen.turnLeft(90);
            pen.forward(myHeight);
            pen.turnLeft(90);
        }
    }
}
