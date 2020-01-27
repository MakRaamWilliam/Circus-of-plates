package eg.edu.alexu.csd.oop.game;

public class Facade {

	IStrategy Strategy;
	public IStrategy GameLevel (String s) {
		if(s.equalsIgnoreCase("normal")) {
			Strategy = new StrategyNormal();
		}
		else if(s.equalsIgnoreCase("easy")) {
			Strategy = new StrategyEasy();
		}
		else if(s.equalsIgnoreCase("hard")) {
			Strategy = new StrategyHard();
		}
		return Strategy;
	}
	
}
