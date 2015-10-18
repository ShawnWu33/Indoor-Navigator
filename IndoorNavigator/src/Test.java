import java.lang.reflect.Array;
import java.util.ArrayList;


public class Test {
	public static void main(String[] args) {
		App test1 = new App();
		Map ground = new GroundFloor();
		Map levelone = new LevelOne();
		//System.out.println(ground.getTile(13, 12).getType().roomName);
		
		ArrayList<ArrayList<String>> output = new ArrayList<>();
		output = test1.findOutRoute("pharmacy", "hair and beauty", "Campus centre","Ground","ground","ground");
		
		
		//return_list.add(q_env_description);
		//return_list.add(q_route_description);
		//return_list.add(q_L_env_description);
		//return_list.add(q_R_env_description);
		//display env info 
		
		System.out.println(output.get(0));
		System.out.println(output.get(1));
		System.out.println(output.get(2));
		System.out.println(output.get(3));
		
		
		
		for(int i = 0;i<output.get(0).size();i++){
			System.out.println(output.get(0).get(i));
			System.out.println(output.get(1).get(i));
			if(output.get(2).get(i)!=""||output.get(2).get(i)!="  "||output.get(2).get(i)!=null){
				System.out.println("There are following objects on your left when you following the waling instructions :"+ output.get(2).get(i));
			}
			if(output.get(3).get(i)!=""){
				System.out.println("There are following objects on your right when you following the waling instructions :"+ output.get(3).get(i));
			}
			System.out.println();
		}


	
	}
		
}

