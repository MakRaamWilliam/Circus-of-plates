package eg.edu.alexu.csd.oop.game;

import java.util.logging.Logger;

import eg.edu.alexu.csd.oop.game.object.Shape;

public class FullStack implements StackState {

	Stack stack;
    public FullStack(Stack st) {this.stack=st;
    st.setType("full");
    Logger logger=Logger.getLogger("circus logger");
    logger.warning("Can't add more shapes in this stack");
    }
	@Override
	public boolean add(Shape s) {
		return false;
	}
}
