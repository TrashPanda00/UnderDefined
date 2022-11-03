package AST;

public class ArrayExpression extends Expression
{
	public Identifier id1;
	public Identifier id2;
	public TypeValue typeValueClass;
	public IntegerLiteral lit;

	public ArrayExpression(Identifier id1)
	{
		this.id1 = id1;
	}

	public ArrayExpression(Identifier id1, TypeValue typeValueClass, IntegerLiteral lit)
	{
		this.id1 = id1;
		this.typeValueClass = typeValueClass;
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
	public Object visit( Visitor v, Object arg )
	{
		return v.visitArrayExpression( this, arg );
	}

}
