package sportstournament.main;


import java.util.ArrayList;


/**
 * This class contains the source code for the club interface 
 * This is where the player can manage their team
 * child class of team
 * author @Reuben Schoonbee
 */
public class Club extends Team{
	

	/**
	 * List of reserves
	 */
	private ArrayList<Athlete> reserves;
	/**
	 * List of items available for use
	 */
	private ArrayList<Item> inventory;
	/**
	 * A boolean that is true only when the reserves are full
	 * (when a player cannot be added to the team without replacing another)
	 */
	private boolean teamFull;

	
	public Club(String name, ArrayList<Athlete> activeTeam) {
		super(name, activeTeam);
		inventory = new ArrayList<Item>();
		reserves = new ArrayList<Athlete>();
	}
	
	public Club(String name, ArrayList<Athlete> activeTeam, ArrayList<Athlete> reserves) {
		super(name, activeTeam);
		inventory = new ArrayList<Item>();
		this.reserves = reserves;
	}
	/**
	 * Returns a boolean that is true if the team is full.
	 * 
	 * @return boolean of whether team is full or not.
	 */
	public boolean isTeamFull() {
		return teamFull;
	}
	
	/**
	 * Sets when the team is full or not.
	 * 
	 * @param teamFull true or false, depending on whether the team is full or not.
	 */
	public void setTeamFull(boolean teamFull) {
		this.teamFull = teamFull;
	}
	/**
	 * returns list of players on the bench
	 * @return reserves
	 */
	public ArrayList<Athlete> viewReserves() {
		return reserves;
	}
	
	/**
	 * returns list of items in inventory
	 * @return inventory
	 */
	public ArrayList<Item> viewItems(){
		return inventory;
	}
	
	/**
	 * boosts the attribute of a given player with the property and value of a given item
	 * then removes the item from the inventory
	 * @param item The item to be used
	 * @param athlete The athlete to use the item on
	 */
	public void useItem(Item item, Athlete athlete) {
		
		
		switch(item) {
		case PROTEIN_SHAKE:
			athlete.setDefenceStat(athlete.getDefenceStat() + item.getStatBoost());
			break;
		case ENERGY_DRINK:
			athlete.setStamina(athlete.getStamina() + item.getStatBoost());
			break;
		case KNEE_SLEEVE:
			athlete.setOffenceStat(athlete.getOffenceStat() + item.getStatBoost());
			break;
		}
		
		inventory.remove(item);
	}
	
	/**
	 * adds an item to the inventory
	 * @param item
	 */
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	
	/**
	 * takes a reserve and an active player and adds the reserve to the active team and the active player to the reserves
	 * @param player Player to be put on team
	 * @param sub Player to be benched
	 */
	public void subAthlete(Athlete player, Athlete sub){
		
		activeTeam.remove(sub);
		activeTeam.add(player);
		reserves.remove(player);
		reserves.add(sub);
	}
	
	/**
	 * Takes a new player and puts them on the reserves. 
	 * @param newPlayer
	 */
	public void addNewAthlete(Athlete newPlayer) {
		if(reserves.size() == 5) {
			setTeamFull(true);
			throw new ArrayIndexOutOfBoundsException("Maximum size of reserves is 5");
		}
		else {
			reserves.add(newPlayer);
			if(reserves.size() == 5) {
				setTeamFull(true); 
			}
		} 	
	}	
	/**
	 * removes given athlete from team
	 * @param athlete
	 */
	public void removeReserve(Athlete athlete) {
		
		reserves.remove(athlete);
		setTeamFull(false);
			
	}
	
}
		
		
