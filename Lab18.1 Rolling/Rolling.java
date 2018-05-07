//d1 != d2 && d1 != d3 && d2 != d1 && d2 != d3 && d3 != d1 && d3 != d2
public class Rolling{
    public static void main(String[]args){
        
        for(int i =0; i <5 ;i++){
            int d1 = (int)(Math.random()*7+1);
            System.out.print(d1 + " ");
            int d2 = (int)(Math.random()*7+1);
            System.out.print(d2 + " ");
            int d3 = (int)(Math.random()*7+1);
            System.out.println(d3);
            int ctr = 1;
            while(d1 == d2 || d1 == d3 || d2 == d3 ){
                d1 = (int)(Math.random()*7+1);
                System.out.print(d1 + " ");
                d2 = (int)(Math.random()*7+1);
                System.out.print(d2 + " ");
                d3 = (int)(Math.random()*7+1);
                System.out.println(d3);
                ctr++;
            }
            System.out.println("count = " + ctr);
        }
    }
}
