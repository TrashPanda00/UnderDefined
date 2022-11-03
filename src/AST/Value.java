package AST;

public class Value extends Expression
{
	public Boolean value;

	public Value()
	{

	}

	public Value(Boolean value)
	{
		this.value = value;
	}

	public Object visit( Visitor v, Object arg )
	{
		return v.visitValue( this, arg );
	}
}