public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;




    public LinearEquation(int x1,int y1,int x2,int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;




    }




    public double roundToHundredth(double toRound){
        double temp = Math.round(toRound*100.0)/100.0;
        return temp;
    }
    public double xDifference(){
        return x2-x1;
    }
    public double yDifference(){
        return y2-y1;
    }
    public double distance(){
        double distance = roundToHundredth(Math.sqrt((Math.pow(xDifference(),2)+(Math.pow(yDifference(),2)))));
        return distance;
    }
    public double slope(){
        double slope = yDifference()/xDifference();
        return roundToHundredth(slope);
    }
    public double yIntercept(){
        double yIntercept = y1-(x1*slope());
        return roundToHundredth(yIntercept);
    }
    public String equation(){
        String equation = "";
        int tempX = Math.abs((int)xDifference());
        int tempY = Math.abs((int)yDifference());
        double yInt = Math.abs(yIntercept());

        if(slope()==1){
            equation+=("y = x");
        }
        else if(slope()==-1){
            equation+=("y = -x");
        }
        else if(slope()==0){
            equation = "y = " + yIntercept();
            return equation;
        }
        else if ((yDifference()%xDifference())==0){
            equation+=("y = " +slope() + "x");
        }
        else if ((xDifference() > 0 && yDifference() >0) || (xDifference() < 0 && yDifference() < 0)){
            equation = ("y = " + tempY + "/" + tempX + "x");
        }
        else if ((xDifference() < 0 && yDifference() > 0) || (xDifference() > 0 && yDifference() < 0)){
            equation = ("y = " + "-" + tempY + "/" + tempX + "x");
        }


        if (yIntercept()>0){
            return equation + " + " + yInt;
        }
        else if(yIntercept()<0){
            return equation + " - " + yInt;
        }
        else{
            return equation;
        }

        }
    public String coordinateForX(double x){
        double yCoord = (slope()*x + yIntercept());
        return("("+x +","+yCoord+")");
    }
    public String lineInfo(){
        return ("The two point are: " + "("+x1+","+y1+")" + " and " + "("+x2+","+y2+")" +"\nThe equation of the line between these points is:" + equation() + "\nThe slope of this line is:" + slope() + "\nThe y-intercept of this line is:" + yIntercept() + "\nThe distance between these points is " + distance());

    }




}


