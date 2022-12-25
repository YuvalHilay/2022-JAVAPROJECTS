package tasks;

public class NamedTasks extends Tasks {
	private String[] names;
	public NamedTasks(String[] names) {//constructor
		super(names.length);
		this.names=names;
	}
	private int getindex(String task) {//find index of task in names
		for(int i=0;i<names.length;i++) {
			if(task.equals(names[i]))
				return i;
		}
		return -1;
	}
	public boolean dependsOn(String task1, String task2) {//dependsOn using super
		
		return super.dependsOn(getindex(task1), getindex(task2));
	}
	public String[] nameOrder() {
		
		String[] out;
		int[] retorder=super.order();//take what order gives us
		if(retorder==null)
			return null;
		out=new String[names.length];//define length of out
		for (int i = 0; i < names.length; i++)//build out
			out[i] = names[retorder[i]];

		return out;
	
	}




}
