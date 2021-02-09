import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author quattroformaggi, 2021
 */

/*
Define the class Fraction (Rational Fraction) as a pair of numbers: m and n. 
1. Declare and initialize an array of k fractions, enter / output values for the array of fractions. 
2. Create an array / list / set of objects and pass it to a method that modifies each element of the array with an even index by adding the next element after it.
*/

class Fraction
{
    private double m,n;                 //numerator & denominator
    public Fraction(double x, double y) //alternative Fraction setter
    {
        this.m = x;
        this.n = y;
        System.out.println("Fraction was imported successfully!");
    }
    public double getFraction()
    {
        return m/n;
    }
}

public class NumDenums extends Fraction {  
    public NumDenums(double x, double y) {
        super(x, y);
    }

    public static void main(String[] args) throws InterruptedException 
    {   
        List<Fraction> FractionList = new ArrayList<Fraction>();//an array, looking like this: [1/7][3,7/5][...][2/24,5]
        Scanner jin = new Scanner(System.in);
        System.out.print("Enter k number of fractions to enter:");
        short k = jin.nextShort();
        if(k<=0)
        {
            System.out.println("Hell no, this won't work");
        }
        jin.reset();
        System.out.println("Required to enter: " + k + " fractions, or " + 2*k + " numbers  in 1.5s...");
        Thread.sleep(1500);
        double numer,denom; //numerator & denominator
        //1.FRACTIONS INPUT
        for(short i = 0; i < k; i++)
        {
            System.out.print("Enter the numerator:");
            numer = jin.nextDouble();
            jin.reset();
            System.out.print("Enter the denominator:");
            denom = jin.nextDouble();
            jin.reset();
            Fraction e = new Fraction(numer,denom);
            FractionList.add(e);
        }
        jin.close();
        //ADDED FRACTIONS OUTPUT
        for(Fraction out : FractionList)
        {
            double gotcha = out.getFraction();
            System.out.println("Fraction " + gotcha);
        }
        //2.COUNTING
        if(k<2 | k > 32767 | (k % 2 > 0))
            System.out.println("Second task is impossible due to the specific size (k) of the FractionsList Array");
        else
        for(short M = 0; M < k; M+=2)
        {
            System.out.println("#" + M + " + " + " #" + (M+1) + " = " 
                                + FractionList.get(M).getFraction() + " + " + FractionList.get(M+1).getFraction() + " = " 
                                + (FractionList.get(M).getFraction() + FractionList.get(M+1).getFraction()));
        }
        FractionList.clear();
    }
}