package circuits;

public abstract class Gate {
	protected Gate[] inGates;
	public Gate(Gate[] inGates) {//constructor
		this.inGates=inGates;
	}
	public boolean calc() throws CircuitException{//calc func that calc the boolean value of the gate
		if(inGates==null)//if there is no in gates call func
			return func(null);
		boolean[] inValues = new boolean[inGates.length];//define the array
		for(int i=0;i<inValues.length;i++)
		{
			inValues[i]=inGates[i].calc();//calc every index for the array
		}
		return func(inValues);//call func
	}
	protected abstract boolean func(boolean[] inValues) throws CircuitException;//all abstract functions
	public abstract String getName();
	public abstract Gate simplify();
	
	public String toString() {
		String s="";
		if (inGates==null)
			return getName();
		s+=getName();
		s+="[";
		for(int i=0;i<inGates.length;i++)
		{
			s+=inGates[i].toString();
			if(i!=inGates.length-1)
				s+=", ";
		}
		s+="]";
		return s;
	}


}
