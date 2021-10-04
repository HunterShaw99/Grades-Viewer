import java.io.IOException;
import java.util.Scanner;

public class Grades {

    public static void main(String[] args) throws IOException {
        AverageDisplay aveGrades = new AverageDisplay(DataMgr.GetInstance());
        AllDisplay allGrades = new AllDisplay(DataMgr.GetInstance());
        int gradeToAdd = 0;
        int input = 0;
        Scanner scan = new Scanner(System.in);
        DataMgr.getFirstGrade();
        do {
            System.out.println("Options - 1. add grade | 2. delete all grades | 3. quit");
            System.out.println("Please enter your options {1, 2, 3}");
            input = scan.nextInt();
            System.out.println();
            switch(input) {
                case 1:
                    System.out.println("Enter a grade to add");
                    gradeToAdd = scan.nextInt();
                    DataMgr.GetInstance().addGrade(gradeToAdd);
                    break;
                case 2:
                    System.out.println("Deleting all grades");
                    DataMgr.GetInstance().deleteAllGrades();
                    break;
                default:
                    System.out.println("Goodbye!!");
                    break;
            }
        } while(input!=3);

    }

}
