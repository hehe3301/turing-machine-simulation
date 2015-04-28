package model;

import java.util.Hashtable;

public class TMState {
	private String name;
	private Hashtable<Character, TMTrans> transitions;
	private boolean isAccept = false;

	public TMState(String name) {
		this.name = name;

	}

	public TMTrans getTrans(Character in) {
		if (transitions.containsKey(in)) {
			return transitions.get(in);
		} else {
			return null;
		}

	}
	
	public void makeAccept(){
		this.isAccept=true;
	}
	public boolean isAccept(){
		return isAccept;
	}
	public void addTrans(Character in, TMTrans trans){
		transitions.put(in, trans);
	}

	public boolean equals(TMState other) {
		return (this.name).equals(other.name);
	}
}
