public abstract class HealthState extends Processor{

	private static int life;

	public static void setLife(int life) {
		HealthState.life = life;
	}

	public static int getLife() {
		return life;
	}

	public HealthState() {
	}

	public  HealthState increaseHealth(int increase) {
		life += increase;
	    return null;
	}

	public  HealthState decreaseHealth(int decrease) {
		life -= decrease;
	    return null;
	}


}