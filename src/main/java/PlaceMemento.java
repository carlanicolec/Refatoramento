
public class PlaceMemento {
    protected Location[][] position;

    public void savePosition(Location[][] position){
        position = position;
    }

    public Location[][] getPlace(){
        return position;
    }
}
