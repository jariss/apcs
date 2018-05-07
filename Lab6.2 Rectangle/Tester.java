
public class Tester  
{
    public static void main(String[]args){
        Rectangle rectA = new Rectangle(-200,-200,400,400);
        rectA.draw();  // draw the rectangle
        rectA = new Rectangle(-67, -200, 133, 400);
        rectA.draw();
        rectA = new Rectangle(-200, -67, 400, 133);
        rectA.draw();
        System.out.println("Perimeter = " + rectA.getPerimeter()); 
        System.out.println("Area = " + rectA.getArea());
    }
}
