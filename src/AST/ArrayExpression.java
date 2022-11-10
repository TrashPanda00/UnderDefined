package AST;

public class ArrayExpression extends Expression
{
	public Identifier id;
	public Expression exp;
	public TypeValue typeValueClass;

	public ArrayExpression(Identifier id, TypeValue typeValueClass, Expression exp)
	{
		this.id = id;
		this.typeValueClass = typeValueClass;
		this.exp = exp;
	}

	public ArrayExpression(Identifier id, Expression exp)
	{
		this.id = id;
		this.exp = exp;
	}

	public Object visit( Visitor v, Object arg )
	{
		return v.visitArrayExpression( this, arg );
	}

}
