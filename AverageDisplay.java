import java.util.ArrayList;

public class AverageDisplay implements Observer, DisplayElement {



    public AverageDisplay(DataMgr data) {
        data.registerObserver(this);
    }

    @Override
    public void update(ArrayList<Integer> gradsList) {
        display(gradsList);
    }

    @Override
    public void display(ArrayList<Integer> updatedGrades) {
        int average = 0;
        if (updatedGrades.size() > 0) {
            for (int s : updatedGrades) {
                average += s;
            }
            average = average / updatedGrades.size();
        }
        System.out.println("Average grade: "+average);
    }
}
