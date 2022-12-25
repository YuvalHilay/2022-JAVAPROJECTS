package circuits;

public class OrGate extends Gate {

	public OrGate(Gate[] inGates) {//constructor
		super(inGates);
	}
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		if(inValues==null)//check if inValues is null
			throw new CircuitException();
		for(boolean b:inValues)//check or condition
		{
			if(b==true)
				return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return "OR";
	}

	@Override
	public Gate simplify() {
		Gate[] newOr=new Gate[inGates.length];
		int index=0;
		for(int i=0;i<inGates.length;i++)//check or condition
		{
			if(inGates[i].simplify() instanceof TrueGate)
				return TrueGate.instance();
			else
			{
				if(inGates[i].simplify() instanceof FalseGate)
				{
					continue;
				}
				newOr[index]=inGates[i].simplify();
				index++;
			}	
		}
		if(index==1)
			return newOr[0].simplify();
		else if (index==0)
			return FalseGate.instance();
		else 
			{
			Gate[] innewOr=new Gate[index];
			for(int j=0;j<index;j++)
				innewOr[j]=newOr[j];
			return new OrGate(innewOr);
			}
	}

}
