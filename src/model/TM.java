package model;

import java.util.Hashtable;
import java.util.Set;

public class TM {
	public Character[] tape;
	public int index;
	public TMState currentState;
	private Hashtable<String, TMState> states;
	private Set<String> stateList;

	public TM() {
		index = 0;
		states = new Hashtable<String, TMState>();
		states.put("Accept", new TMState("Accept"));
		states.get("Accept").makeAccept();
	}

	public void addTransition(String currentState, String nextState,
			Character current, Character change, int movement) {
		if (!states.containsKey(currentState)) {// if the start state does not
												// exsist yet
			states.put(currentState, new TMState(currentState));
		}
		if (!states.containsKey(nextState)) {// if the end state does not exsist
												// yet
			states.put(nextState, new TMState(nextState));
		}
		TMTrans trans;
		if (change == null) {// if we are not changing the tape
			trans = new TMTrans(movement, this, states.get(nextState));
		} else {// if we are changing the tape
			trans = new TMTrans(change, movement, this, states.get(nextState));
		}
		states.get(currentState).addTrans(current, trans);

	}

	public void run(String tapeIn) {
		this.tape = tapeIn.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		System.out.println(tape);
	}

}
