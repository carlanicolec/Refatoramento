import java.util.ArrayList;

public class PlaceCareTaker {
    protected ArrayList<Location[][]> allLocations = new ArrayList<Location[][]>();

    public void addMemento(Location[][] newLocation){
        allLocations.add(newLocation);
    }

    public Location[][] getLast(){
        if (allLocations.size()==0){
            System.out.println("You are at the beginning. Can't go back.");
            return null;
        }else{
            Location[][] lastLocation = allLocations.get(allLocations.size()-1);
            allLocations.remove(allLocations.size()-1);
            return lastLocation;
        }
    }
}
