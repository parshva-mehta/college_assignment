package Java.CS111;

public class FinalExam {
    public static void main(String[] args){

        int a = Integer.parseInt(args[0]);
        int e1 = Integer.parseInt(args[1]);
        int e2 = Integer.parseInt(args[2]);
        int r = Integer.parseInt(args[3]);
        double f;
        
        double score  = 0.5 * a + 0.15 * e1 + 0.15 * e2 + 0.05 * r;  //calculating score w/out final grade

        // Threshold for an A = 90
        f = (90 - score)/(0.15); //calculating final grade needed
        
        System.out.println(f);
    }
}