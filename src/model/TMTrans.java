package model;

public class TMTrans {
	private TM machine;
	private int movement;
	private boolean makesChange;
	private Character change;
	private TMState next;

	/**
	 * Constructor to be used if the transition changes the letter it is looking
	 * at
	 * 
	 * @param future
	 *            - the letter to change the current state into
	 * @param movement
	 *            - the direction to move
	 * @param machine
	 *            - the TM this belongs to
	 * @param name
	 *            - the state to transition to
	 */
	public TMTrans(Character future, int movement, TM machine, TMState next) {
		makesChange = true;
		this.movement = movement;
		this.machine = machine;
		this.change = future;
		this.next = next;

	}// constructor1

	/**
	 * The constructor to be used if the transition is just movement
	 * 
	 * @param movement
	 *            - the direction to move
	 * @param machine
	 *            - the TM this belongs to
	 * @param name
	 *            - the state to transition to
	 */
	public TMTrans(int movement, TM machine, TMState next) {
		makesChange = false;
		this.movement = movement;
		this.machine = machine;
		this.next = next;

	}// constructor2

	/**
	 * The method to apply this transition to the TM
	 */
	public void runTrans() {
		if (makesChange) {
			machine.tape[machine.index] = change;
			machine.index += movement;
			machine.currentState=next;
		} else {
			machine.index += movement;
			machine.currentState=next;
		}

	}

}
