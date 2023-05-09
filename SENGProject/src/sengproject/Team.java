package sengproject;

import java.util.ArrayList;

/**
 * the general class for team, will be used both for the players own team and opposing teams
 * parent class of club
 * @author rsc103
 *
 */

public class Team {
	
	/**
	 * The teams name
	 */
	protected String name;
	/**
	 * List of active players
	 */
	protected ArrayList<Athlete> activeTeam;
	/**
	 * Default constructor for team
	 */
	public Team(String name, ArrayList<Athlete> activeTeam) {
		setName(name);
		this.activeTeam = activeTeam;
	}
	/**
	 * returns the team name
	 * @return name The name of team
	 */
	public String viewName() {
		return name;
	}
	
	/**
	 * sets team name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * returns list of active players on the team
	 * @ return activeTeam
	 */
	public ArrayList<Athlete> viewActiveTeam() {
		return activeTeam;
	}	
	

}
