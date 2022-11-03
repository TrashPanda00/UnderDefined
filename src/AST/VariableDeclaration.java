/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 29.09.2006 Original version
 */
 
package AST;


public class VariableDeclaration
	extends Declaration
{
	public TypeValue typeValueClass1;
	public TypeValue typeValueClass2;
	public IntegerLiteral lit;
	public Identifier id;
	public Statements stat;
	public Statement statSingle;

	public VariableDeclaration(TypeValue typeValueClass1, Identifier id)
	{
		this.typeValueClass1 = typeValueClass1;
		this.typeValueClass2 = typeValueClass2;
		this.id = id;
	}

	public VariableDeclaration(TypeValue typeValueClass1, Identifier id, Statement stat)
	{
		this.typeValueClass1 = typeValueClass1;
		this.id = id;
		this.statSingle = stat;
	}

	public VariableDeclaration(TypeValue typeValueClass1, TypeValue typeValueClass2, IntegerLiteral lit, Identifier id, Statements stat)
	{
		this.typeValueClass1 = typeValueClass1;
		this.typeValueClass2 = typeValueClass2;
		this.lit = lit;
		this.id = id;
		this.stat = stat;
	}
	public Object visit( Visitor v, Object arg )
	{
		return v.visitVariableDeclaration( this, arg );
	}


}