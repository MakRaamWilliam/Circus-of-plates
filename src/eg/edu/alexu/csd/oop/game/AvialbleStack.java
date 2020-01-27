package eg.edu.alexu.csd.oop.game;

import eg.edu.alexu.csd.oop.game.object.Shape;

public class AvialbleStack implements StackState {

	Stack stack;
    public AvialbleStack(Stack st) {this.stack=st;}
	@Override
	public boolean add(Shape s) {
		stack.add(s);
		return true;
	}

}
