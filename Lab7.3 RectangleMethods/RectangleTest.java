public class RectangleTest
{
    public static void main(String[]args){
        int turnInc = 30;
        int widthDec = 10;
        Rectangle rectA = new Rectangle(0, 0, 200, 50, 0);
        rectA.draw();
        Rectangle rectB = new Rectangle(rectA);
        rectB.setXPos(-230);
        rectB.setYPos(140);        
        rectB.drawString("Area = " + rectB.getArea(), -200, 160);
        rectB.drawString("Perimeter = " + rectB.getPerimeter(), -200, 125);
        rectB.drawString("Width = " + rectB.getWidth(), -200, 200);
        rectB.drawString("Height = " + rectB.getHeight(),-25, 160);
        rectB.draw();
        for(int i = 0; i<10; i++){
            rectA.setDirection(rectA.getDirection() - turnInc);
            rectA.setWidth(rectA.getWidth() - widthDec);
            rectA.draw();
        }
        System.out.println(rectA.getDirection()+" " + rectA.getWidth());
        
    }
}