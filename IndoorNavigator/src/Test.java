import java.util.ArrayList;


public class Test {
	public static void main(String[] args) {
		App test = new App();
		Map ground = new GroundFloor();
		Map levelone = new LevelOne();
		System.out.println(ground.getTile(13, 12).getType().roomName);
		
		test.findOutRoute("pharmacy", "hair and beauty", "Campus centre", "Ground");
		
	}
}
