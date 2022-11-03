package AST;

public class TypeName extends Terminal
{
	public TypeName( String spelling )
	{
		this.spelling = spelling;
	}

	public Object visit(Visitor v, Object arg)
	{
		return null;
	}
}
