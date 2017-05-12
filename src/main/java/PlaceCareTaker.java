import java.util.ArrayList;

public class PlaceCareTaker {
    protected ArrayList<Integer> allX = new ArrayList<Integer>();
    protected ArrayList<Integer> allY = new ArrayList<Integer>();


    public void addXMemento(int xPos){
        allX.add(xPos);
    }

    public void addYMemento(int yPos){
        allY.add(yPos);
    }

    public int getLastX(){
        int lastX = allX.size()-1;
        return lastX;
    }
    public int getLastY(){
        int lastY = allY.size()-1;
        return lastY;
    }


}
