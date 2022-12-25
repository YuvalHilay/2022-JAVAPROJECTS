package circuits;

public class NotGate extends Gate {

	public NotGate(Gate in) {
		super(new Gate[] {in});
	}
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		if(inValues==null||inValues.length>1)//check if inValues is null or bigger than 1
			throw new CircuitException();
		return !inValues[0];
	}

	@Override
	public String getName() {
		return "NOT";
	}

	@Override
	public Gate simplify() {
		if(inGates[0].simplify() instanceof TrueGate)
		{
			return FalseGate.instance();
		}
		else if(inGates[0].simplify() instanceof FalseGate)
		{
			return TrueGate.instance();
		}
		else if(inGates[0] instanceof NotGate)
			return inGates[0].inGates[0].simplify();
		return this;	
	}

}
