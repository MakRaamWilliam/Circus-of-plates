package eg.edu.alexu.csd.oop.game;

public class SubjectObserved {

	Check f;
	Observer Ob;
	Observer2 Ob2 = new Observer2();
	public SubjectObserved(Check f,Observer ob) {this.f=f; this.Ob=ob;}
	public void notification() {
		if(f.getSame() == 1) {
			Ob.update();
			Ob2.update();
		}
	}
}
