package circuits;

public class AndGate extends Gate {

	public AndGate(Gate[] inGates) {//constructor
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		if(inValues==null)//check if inValues is null
			throw new CircuitException();
		for(boolean b:inValues)//check and condition
		{
			if(b==false)
				return false;
		}
		return true;
	}
	@Override
	public String getName() {
		return "AND";
	}

	@Override
	public Gate simplify() {
		Gate[] newAnd=new Gate[inGates.length];
		int index=0;
		for(int i=0;i<inGates.length;i++)//check or condition
		{
			if(inGates[i].simplify() instanceof FalseGate)
				return FalseGate.instance();
			else
			{
				if(inGates[i].simplify() instanceof TrueGate)
				{
					continue;
				}
				newAnd[index]=inGates[i].simplify();
				index++;
			}	
		}
		if(index==1)
			return newAnd[0].simplify();
		else if (index==0)
			return TrueGate.instance();
		else 
			{
			Gate[] innewAnd=new Gate[index];
			for(int j=0;j<index;j++)
				innewAnd[j]=newAnd[j];
			return new AndGate(innewAnd);
			}
	}

}
