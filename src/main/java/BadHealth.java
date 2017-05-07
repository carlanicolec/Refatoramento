
public class BadHealth extends HealthState{
    public BadHealth() {
    }

    public void BadHealth(int h){
        super.setLife(h);
    }


    @Override
    public HealthState decreaseHealth(int decrease){
        super.setLife(super.getLife() - decrease);
        if(super.getLife() > 0 && super.getLife() <= 5){
            System.out.println("You have a bad health. You need to eat. Health: " + super.getLife());
            BadHealth health = new BadHealth();
            health.BadHealth(super.getLife());
            return health;
        }else{
            System.out.println("You didnt eat enough going around campus and ended up in the Wellness Center");
            System.out.println("");
            System.out.println("                         GAME OVER                                            ");
            System.exit(0);
            return null;
        }
    }


    @Override
    public HealthState increaseHealth(int increase){
        super.setLife(super.getLife() + increase);

        if (super.getLife() > 5){
            System.out.println("Your health is better. Health: " + super.getLife());
            GoodHealth health = new GoodHealth();
            health.GoodHealth(super.getLife());
            return health;
        } else if(super.getLife() > 0 && super.getLife() <= 5){
            System.out.println("You have a bad health. You need to eat. Health: " + super.getLife());
            BadHealth health = new BadHealth();
            health.BadHealth(super.getLife());
            return health;
        }else{
          return null;
        }
    }
}
