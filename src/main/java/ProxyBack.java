
public class ProxyBack implements Place {
    PlaceCareTaker places = PlaceCareTaker.getInstance();
    public void goBack(){
        if (places.getXSize() >0 && places.getYSize() >0){
            int xPos = places.getLastX();
            int yPos = places.getLastY();
            World.xPos = xPos;
            World.yPos = yPos;
            System.out.println(xPos +", "+ yPos);
            String location = World.getLocationName(xPos, yPos);
            System.out.println(location);
        }else {
            System.out.println("You are in the beginning, can't go back");
        }
    }
}


