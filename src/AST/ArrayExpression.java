package AST;

public class ArrayExpression extends Expression
{
	Identifier id1;
	Identifier id2;
	Type type;
	IntegerLiteral lit;

	public ArrayExpression(Identifier id1)
	{
		this.id1 = id1;
	}

	public ArrayExpression(Identifier id1, Type type, IntegerLiteral lit)
	{
		this.id1 = id1;
		this.type = type;
		this.lit = lit;
	}

	public ArrayExpression(Identifier id1,IntegerLiteral lit)
	{
		this.id1 = id1;
		this.lit = lit;
	}

	public ArrayExpression(Identifier id1, Identifier id2)
	{
		this.id1 = id1;
		this.id2 = id2;
	}
}
