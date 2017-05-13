import java.util.ArrayList;

public class PlaceCareTaker {
    public static PlaceCareTaker instance;

    protected PlaceCareTaker(){
    }
    protected ArrayList<Integer> allX = new ArrayList<Integer>();
    protected ArrayList<Integer> allY = new ArrayList<Integer>();

    public static PlaceCareTaker getInstance(){
        if (instance == null){
            instance = new PlaceCareTaker();
        }
        return instance;
    }

    protected void removeX(int index){
        allX.remove(index);
    }

    protected void removeY(int index){
        allY.remove(index);
    }

    public void addXMemento(int xPos){
        allX.add(xPos);
    }

    public void addYMemento(int yPos){
        allY.add(yPos);
    }

    public int getXSize(){
        return allX.size();
    }
    public int getYSize(){
        return allY.size();
    }

    public int getLastX(){
        int lastX = allX.get(allX.size()-1);
        int index = allX.size()-1;
        removeX(index);
        return lastX;
    }
    public int getLastY(){
        int lastY =allY.get(allY.size()-1);
        int index = allY.size()-1;
        removeY(index);
        return lastY;
    }


}
