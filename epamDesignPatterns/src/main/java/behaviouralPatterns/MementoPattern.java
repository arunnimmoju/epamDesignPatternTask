package behaviouralPatterns;

import java.util.*;

class Originator {

	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	public void getStateFromMemento(Memento Mem) {
		state = Mem.getState();
	}
}

class Memento {

	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

}

class Caretaker {

	private List<Memento> memList = new ArrayList<Memento>();

	public void add(Memento state) {
		memList.add(state);
	}

	public Memento get(int index) {
		return memList.get(index);
	}

}

public class MementoPattern {

	public static void main(String[] args) {

		Originator org = new Originator();

		Caretaker cT = new Caretaker();

		for (int i = 1; i <= 4; i++) {
			org.setState("State " + i);
			cT.add(org.saveStateToMemento());
		}

		System.out.println("Current State: " + org.getState());
		org.getStateFromMemento(cT.get(0));
		System.out.println("First saved State: " + org.getState());
		org.getStateFromMemento(cT.get(1));
		System.out.println("Second saved State: " + org.getState());
		org.getStateFromMemento(cT.get(2));
		System.out.println("Third saved State: " + org.getState());
	}

}
