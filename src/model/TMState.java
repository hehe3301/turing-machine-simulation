package model;

import java.util.Hashtable;

public class TMState {
	private String name;
	private Hashtable<Character, TMTrans> transitions;

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

	public boolean equals(TMState other) {
		return (this.name).equals(other.name);
	}
}
