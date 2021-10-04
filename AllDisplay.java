import java.util.ArrayList;

public class AllDisplay implements Observer, DisplayElement {



    public AllDisplay(DataMgr data) {
        data.registerObserver(this);
    }

    @Override
    public void update(ArrayList<Integer> gradsList) {
        display(gradsList);
    }

    @Override
    public void display(ArrayList<Integer> updatedGrades) {
        StringBuilder allGrades = new StringBuilder();
        if (updatedGrades.size() > 0) {
            for (int s : updatedGrades) {
                allGrades.append(s);
                allGrades.append(" ");
            }
        }
        System.out.println("All grades: "+allGrades);
    }
}
