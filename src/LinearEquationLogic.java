import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner scan;
    private LinearEquation obj;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String coord1;
    private String coord2;
    public LinearEquationLogic(){
        obj=null;
        scan = new Scanner(System.in);
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        coord1 = null;
        coord2 = null;
    }
    public void start(){
        intro();
        getCoord();

    }
    private void getCoord(){
        System.out.print("Enter coordinate 1: ");
        coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        coord2 = scan.nextLine();
        coord1 = coordP(coord1);
        coord2 = coordP(coord2);

        x1= xCoordParse(coord1);
        y1= yCoordParse(coord1);
        x2= xCoordParse(coord2);
        y2= yCoordParse(coord2);

        obj = new LinearEquation(x1,y1,x2,y2);
        choices();

    }
    private void repeat(){
        System.out.print("Would you like to enter another pair of coordinate? y/n: ");
        String choice = scan.nextLine();
        if (choice.equals("y")){
            getCoord();
        }
        else{
            System.out.print("Error.......Program End.");
        }
    }
    private String coordP(String coord){
        coord = coord.replace("(","");
        coord = coord.replace(")","");
        coord = coord.replace(" ","");
        return coord;
    }
    private int xCoordParse(String coord){
        return (Integer.parseInt(coord.substring(0,coord.indexOf(","))));
    }
    private int yCoordParse(String coord){
        return (Integer.parseInt(coord.substring(coord.indexOf(",")+2)));
    }
    private void intro(){
        System.out.println("This is Linear Equation Calculator (When asked for coordinate enter in the format of (x, y)");
    }
    private void choices(){
        System.out.println("--------------------------- Line Info ---------------------------");
        if (x1==x2 && y1==y2){
            System.out.println("The two points are the same and the distance between the two line would be 0");
            System.out.println("-----------------------------------------------------------------");
            repeat();
        }
        else if (x1==x2){
            System.out.println("The two point are (" + coord1 + ") and (" + coord2 + ")\nThe equation of the line between these points is:x="+ x1 + "\nThe slope of this line is: undefined \nThe distance between these points is " + obj.distance());
            System.out.println("For all values of the line x is equal to " + x1);
            System.out.println("-----------------------------------------------------------------");
            repeat();
        }
        else if (y1==y2){
            System.out.println(obj.lineInfo());
            System.out.println("The line is horizontal so for all value of x, y = " + y1);
            System.out.println("-----------------------------------------------------------------");
            repeat();
        }
        else {
            System.out.println(obj.lineInfo());
            System.out.print("Enter a value for x: ");
            double x = scan.nextDouble();
            scan.nextLine();
            System.out.println(obj.coordinateForX(x));
            System.out.println("-----------------------------------------------------------------");
            repeat();
        }

        }



}
