class NegativeYearException extends Exception{
    NegativeYearException(){
        super("Negative Year");
    }
}

public class Calender {
    private int year;
    private String[] DAYS = new String[]{"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
    private String[] YEARS = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static int[] noOfDays = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    private int count;

    Calender(int year){
        this.year = year;
        if(isLeapYear(year))
            noOfDays[1] = 29;
        this.count = getStartDay(year);
    }

    private boolean isLeapYear(int year){
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    void display(){
        if(year<1000 && year>=100) System.out.println("     Year: 0" + year);
        if(year<100 && year>=10) System.out.println("     Year: 00" + year);
        if(year<10) System.out.println("     Year: 000" + year);
        else System.out.println("     Year: " + year);
        System.out.println();

        for(int i=0; i<12; i++){
            System.out.println(" ".repeat((20-YEARS[i].length())/2)+YEARS[i]);

            for(int j=0; j<7; j++){
                System.out.print(DAYS[j]+" ");
            }
            System.out.println();

            for(int j=0; j<count; j++){
                System.out.print("   ");
            }

            for(int j=1; j<=noOfDays[i]; j++){
                System.out.print((j<10 ? ("0"+j) : j)+" ");
                count++;

                if(count == 7 && j!=noOfDays[i]){
                    count = 0;
                    System.out.println();
                }
            }
            if(count == 7){
                count = 0;
            }
            System.out.println();
            System.out.println();
        }
    }

    private int getStartDay(int year){
        int leap=0, diff= this.year;
        for(int i = 1; i< this.year; i++){
            if(isLeapYear(i)) leap++;
        }

        int totalDays = (diff-leap)*365 + leap*366;
        int day = totalDays%7;

        return day;
    }
}
