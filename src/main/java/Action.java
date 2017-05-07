public class Action extends Processor{
	
	public Action()
	{ 	

	}

	public void beginning(){
		if (healthState.getLife() > 5){
			GoodHealth good = new GoodHealth();
			good.decreaseHealth(1);
			healthState = good;
		}else if (healthState.getLife() <= 5){
			BadHealth bad = new BadHealth();
			bad.decreaseHealth(1);
			healthState = bad;
		}
		moves += 1;
		ProxyPlace proxyPlace = new ProxyPlace();
		proxyPlace.goToStart();
	}

	public void goBack(){
		Location[][] last = places.getLast();
		world.setBoard(last);
	}

	public void move(String instr){
		places.addMemento(world.returnBoard());
		if (instr.equals("north")) {
			if(world.checkNorth()){
				world.moveNorth();
				world.getBoardPosition();
				if (healthState.getLife() > 5){
					GoodHealth good = new GoodHealth();
					good.decreaseHealth(1);
					healthState = good;
				}else if (healthState.getLife() <= 5){
					BadHealth bad = new BadHealth();
					bad.decreaseHealth(1);
					healthState = bad;
				}
				moves += 1;
				}
			else {
				System.out.println("Cant go there");
			}
		}

		if (instr.equals("east")){
			if(world.checkEast()) {
							world.moveEast();
							world.getBoardPosition();
							if (healthState.getLife() > 5){
								GoodHealth good = new GoodHealth();
								good.decreaseHealth(1);
								healthState = good;
							}else if (healthState.getLife() <= 5){
								BadHealth bad = new BadHealth();
								bad.decreaseHealth(1);
								healthState = bad;
							}
							moves += 1;
						}
					else{
						System.out.println("Cant go there");
					}
				}

			if (instr.equals("south")) {
					if(world.checkSouth()) {
							world.moveSouth();
							world.getBoardPosition();
							if (healthState.getLife() > 5){
								GoodHealth good = new GoodHealth();
								good.decreaseHealth(1);
								healthState = good;
							}else if (healthState.getLife() <= 5){
								BadHealth bad = new BadHealth();
								bad.decreaseHealth(1);
								healthState = bad;
							}
							moves += 1;
						}
					else{
							System.out.println("Cant go there");
					}
				}

			if (instr.equals("west")){
					if(world.checkWest())
						{	
							world.moveWest();
							world.getBoardPosition();
							if (healthState.getLife() > 5){
								GoodHealth good = new GoodHealth();
								good.decreaseHealth(1);
								healthState = good;
							}else if (healthState.getLife() <= 5){
								BadHealth bad = new BadHealth();
								bad.decreaseHealth(1);
								healthState = bad;
							}
							moves += 1;
						}
					
					else {
						System.out.println("You cant go there");
					}
				}
	
	}

	public void take(String toRemove) {
		// if ToRemove = Item listed in location remove it from location
		Item item = world.getLocation().remove(toRemove);

		// place item in Inventory
		inventory.add(item);
	}

	public void drop(String toDrop) {
		Item d = inventory.getInventoryItem(toDrop);

		Item d2 = inventory.drop(d);

		world.getLocation().addItemToLocation(d2);

	}

	public void examine(String toExamine)
	{
		Item item = inventory.getInventoryItem(toExamine);

		String itemDescription = item.getDescription();
		
		System.out.println(itemDescription);

	}

	public void eat(String toEat)
	{	
		if (toEat.equals("spicy_chicken_sandwich"))
		{	
			Item food = inventory.getInventoryItem(toEat);
			Item eatenItem = inventory.drop(food);
			healthState.increaseHealth(10);
			System.out.println("Eating sandwich");

		}

		else if (toEat.equals("taco_stack"))
		{	
			Item food = inventory.getInventoryItem(toEat);
			Item eatenItem = inventory.drop(food);
			healthState.increaseHealth(15);
			System.out.println("Eating stack");

		}
		else if (toEat.equals("pizza"))
		{	
			Item food = inventory.getInventoryItem(toEat);
			Item eatenItem = inventory.drop(food);
			healthState.increaseHealth(7);
			System.out.println("Eating pizza");

		}
		else if (toEat.equals("chips"))
		{	
			Item food = inventory.getInventoryItem(toEat);
			Item eatenItem = inventory.drop(food);
			healthState.increaseHealth(5);
			System.out.println("Eating chips");

		}


		else
		{
			System.out.println("You can't eat that");
		}

	}

	public void drink(String toDrink)
	{
		if (toDrink.equals("heineken"))
		{	
			Item drink = inventory.getInventoryItem(toDrink);
			Item eatenItem = inventory.drop(drink);
			healthState.increaseHealth(20);
			System.out.println("drinking heineken");

		}

		else if (toDrink.equals("soda"))
		{	
			Item drink = inventory.getInventoryItem(toDrink);
			Item eatenItem = inventory.drop(drink);
			healthState.increaseHealth(5);
			System.out.println("drinking soda");

		}

		else
		{
			System.out.println("You can't drink that");
		}

	}
	
	public void use()
	{	
		boolean winLocation = world.checkLocation();
		boolean winItems = inventory.checkInventory();

		if(winLocation && winItems)
		{	
			System.out.println("");
			System.out.println("Congrats made to the Final Exam in time");
			System.out.println("Thanks For Playing You Win");
			System.out.println("");
			System.out.println("Game Over");

			//break out of the game//
		}

		else if (winLocation)
		{
			System.out.println("You do not have the things required to take this test!!!");
		}

		else if (winItems)
		{
			System.out.println("The Final Exam isn't in this Location");
		}

	}


	public void nextMove()
	{
		try
		{ 
			if(world.getNorthLocation().getLocationName() != null)
			{	
				System.out.print("North:");
				System.out.println(world.getNorthLocation().getLocationName());
			}
		}

			catch (NullPointerException ex)
			{
				System.out.println("");
			}


		try
		{ 
			if(world.getEastLocation().getLocationName() != null)
			{	
				System.out.print("East:");
				System.out.println(world.getEastLocation().getLocationName());
				
			}
		}

		catch (NullPointerException ex)
			{
				System.out.println("");
			}

		try
		{ 
			if(world.getSouthLocation().getLocationName() != null)
			{	
				System.out.print("South:");
				System.out.println(world.getSouthLocation().getLocationName());
			}
		}

		catch (NullPointerException ex)
		{
			System.out.println("");
		}

		try
		{ 
			if(world.getWestLocation().getLocationName() != null)
			{	
				System.out.print("West:");
				System.out.println(world.getWestLocation().getLocationName());
			}
		}

		catch (NullPointerException ex)
		{
			System.out.print("");
		}
	}



	public static void main(String args[])
	{}


}