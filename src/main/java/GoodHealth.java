
public class GoodHealth extends HealthState {

    public GoodHealth() {
    }

    public void GoodHealth(int h){
        super.setLife(h);
    }

    @Override
    public HealthState decreaseHealth(int decrease) {
        super.setLife(super.getLife() - decrease);

        if (super.getLife() <= 5){
            System.out.println("You have a bad health. You need to eat. Health: " + super.getLife());
            BadHealth health = new BadHealth();
            health.BadHealth(super.getLife());
            return health;
        }else {
            System.out.println("You have a good health. Health: " + super.getLife());
            GoodHealth health = new GoodHealth();
            health.GoodHealth(super.getLife());
            return health;
        }
    }
}
