package model;

public class TMTrans {
	private TM machine;
	private int movement;
	private boolean makesChange;
	private Character change;

	public TMTrans(Character future, int movement, TM machine) {
		makesChange = true;
		this.movement = movement;
		this.machine = machine;
		this.change = future;

	}// constructor1

	public TMTrans(int movement, TM machine) {
		makesChange = false;
		this.movement = movement;
		this.machine = machine;

	}// constructor2

	public void runTrans() {
		if (makesChange) {
			machine.tape[machine.index] = change;
			machine.index += movement;
		} else {
			machine.index += movement;
		}

	}

}
