public class ConvertSeconds {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        
        int num_minutes = num/60;
        int remaining_seconds = num%60;
        int num_hours = num_minutes/60;
        int remaining_minutes = num_minutes%60;
        int num_days = num_hours/24;
        int remaining_hours = num_hours%24;
        int num_years = num_days/365;
        int remaining_days = num_days%365;

        System.out.printf("%d years, %d days, %d hours, %d minutes, and %d seconds", num_years, remaining_days, remaining_hours, remaining_minutes, remaining_seconds);
    }
}