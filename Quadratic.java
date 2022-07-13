public class Quadratic {
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        double determinant = Math.pow(b,2) - (4 * a * c);


        if(determinant < 0){
            double im = (Math.sqrt(Math.abs(determinant))/2.0);
            double real = -b/2;

            if(im == 1){
                if(real == Math.rint(real)){
                    System.out.print((int) real);
                    System.out.print(" + i, ");
                    System.out.print((int) real);
                    System.out.print(" - i ");
                }
                else{
                    System.out.print(real);
                    System.out.print(" + i, ");
                    System.out.print(real);
                    System.out.print(" - i ");
                }
            }
            else if(im == 0){
                if(real == Math.rint(real)){
                    System.out.print((int) real);
                }
                else{
                    System.out.print(real);

                }
            }
            else if(real == 0){
                if(im == Math.rint(im)){
                    System.out.println((int) im + "i , -" + (int)im + "i");
                }
                else{
                    System.out.println(im + "i , -" + im + "i");
                }
            }
            else{
                if(real == Math.rint(real) && im == Math.rint(im)){
                    System.out.print((int) real);
                    System.out.print(" + " + (int) im + "i,");
                    System.out.print((int) real);
                    System.out.print(" - " + (int)im + "i");
                }
                else if(im == Math.rint(im)){
                    System.out.print(real);
                    System.out.print(" + " + (int) im + "i,");
                    System.out.print (real);
                    System.out.print(" - " + (int) im + "i");
                }
                else if(real == Math.rint(real)){
                    System.out.print((int) real);
                    System.out.print(" + " + im + "i,");
                    System.out.print ((int) real);
                    System.out.print(" - " + im + "i");   
                }
                else{
                    System.out.print(real);
                    System.out.print(" + " + im + "i,");
                    System.out.print (real);
                    System.out.print(" - " + im + "i");
                }
                
            }
            
        }
        
        double answer1 = (-b + (Math.sqrt(determinant)))/ (2 * a);
        double answer2 = (-b - (Math.sqrt(determinant)))/ (2 * a);

        if(answer1 == Math.rint(answer1) && determinant >= 0){
            System.out.println((int) answer1 + "," + (int) answer2);
        }
        else if(determinant >= 0){
            System.out.println(answer1 + "," + answer2);    
        }
    }
}