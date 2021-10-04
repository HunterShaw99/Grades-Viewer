import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataMgr implements Subject {

    private volatile static DataMgr onlyInstance = null;
    private static ArrayList<Integer> gradesList = null;
    private String filePath;
    private File dataFile;
    private ArrayList<Observer> observers;

    private DataMgr() {
        gradesList = new ArrayList<>();
        filePath = "data.txt";
        dataFile = new File(filePath);
        observers = new ArrayList<>();
    }

    public static DataMgr GetInstance() {
        if (onlyInstance == null) {
            synchronized (DataMgr.class) {
                if (onlyInstance == null) {
                    onlyInstance = new DataMgr();
                }
            }
        }
        return onlyInstance;
    }

    public void addGrade(int toAdd) throws IOException {
        gradesList.add(toAdd);
        saveData();
        //Send notification out to Observers
        notifyObservers();
    }

    public void deleteAllGrades() {
        gradesList.clear();
        deleteData();
        //Notify Observers of change
        notifyObservers();
    }

    public static ArrayList<Integer> getAllGrades() {
        return gradesList;
    }

    public static Integer getFirstGrade() {
        if (gradesList.size() == 0) {
            return null;
        }
        return gradesList.get(0);
    }

    private void saveData() throws IOException {
        PrintWriter fs = new PrintWriter(dataFile);
        for (int x : gradesList) {
            fs.println(x);
        }
        fs.close();
    }

    private void loadData() throws IOException {
       try (Scanner scanner = new Scanner(dataFile)) {
           while (scanner.hasNext()) {
               gradesList.add(scanner.nextInt());
           }
       }
    }

    private void deleteData() {
        dataFile.delete();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(gradesList);
        }
    }

}
