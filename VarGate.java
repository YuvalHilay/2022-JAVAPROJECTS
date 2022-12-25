package circuits;

public class VarGate extends Gate {
	private String name;
	private Gate g;
	public VarGate(String name) {
		super(null);
		this.name=name;
	}
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		if(g==null)
			throw new CircuitException();
		return g.func(inValues);
	}

	public void setVal(boolean value) {
		if(value)
			g=TrueGate.instance();
		else
			g=FalseGate.instance();
	}

	@Override
	public String getName() {
		return "V"+name;
	}

	@Override
	public Gate simplify() {
		if(g!=null)
			return g;
		else
			return this;
	}
}
