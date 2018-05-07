import apcslib.*;
public class Rectangle
{
    private double myX;      // the x coordinate of the rectangle
    private double myY;      // the y coordinate of the rectangle
    private double myWidth;  // the width of the rectangle
    private double myHeight; // the height of the rectangle
    // saves the direction the pen is pointing
    // (0 = horizontal, pointing right)
    private double myDirection;
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

    public Rectangle(double x, double y, double width, double height, double myDirection){
        this.myX = x;
        this.myY = y;
        this.myHeight = height;
        this.myWidth = width;
        this.myDirection = myDirection;
    }
    // Creates a new instance of a Rectangle object that is a copy of an
    // existing Rectangle object.
    public Rectangle(Rectangle rect){
        this.myX = rect.myX;
        this.myY = rect.myY;
        this.myHeight = rect.myHeight;
        this.myWidth = rect.myWidth;
        this.myDirection = rect.myDirection;
    }
    // Sets the x coordinate of this Rectangle
    public void setXPos(double x){
        myX = x;
    }   
    // Sets the y coordinate of this Rectangle
    public void setYPos(double y){
        myY = y;
    }
    // Sets the width this Rectangle
    public void setWidth(double width){
        myWidth = width;
    }
    // Sets the height of this Rectangle
    public void setHeight(double height){
        myHeight = height;
    }
    // Sets the direction the DrawingTool is pointing
    // 0 = horizontal to the right
    public void setDirection(double direction){
        myDirection = direction;
    }
    // Returns the x coordinate of this Rectangle
    public double getXPos(){
        return myX;
    }
    // Returns the y coordinate of this Rectangle
    public double getYPos(){
        return myY;
    }
    // Returns the width of this Rectangle
    public double getWidth(){
        return myWidth;
    }
    // Returns the height of this Rectangle
    public double getHeight(){
        return myHeight;
    }
    // Returns the direction the DrawingTool is pointing
    // 0 = horizontal to the right
    public double getDirection(){
        return myDirection;
    }
    // Draws String str at the specified x and y coordinates
    public void drawString(String str, double x, double y){
        pen.up();
        pen.move(x ,y);
        pen.down();
        pen.drawString(str);
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
        pen.setDirection(myDirection);
        pen.forward(myWidth);
        pen.turnLeft(90);
        pen.forward(myHeight);
        pen.turnLeft(90);
        pen.forward(myWidth);
        pen.turnLeft(90);
        pen.forward(myHeight);
        pen.turnLeft(90);
    }
}
