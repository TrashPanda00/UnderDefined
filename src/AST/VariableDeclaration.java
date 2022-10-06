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
	public Type type1;
	public Type type2;
	public IntegerLiteral lit;
	public Identifier id;
	public Statements stat;
	public Statement statSingle;

	public VariableDeclaration( Type type1, Identifier id)
	{
		this.type1 = type1;
		this.type2 = type2;
		this.id = id;
	}

	public VariableDeclaration( Type type1, Identifier id, Statement stat )
	{
		this.type1 = type1;
		this.id = id;
		this.statSingle = stat;
	}

	public VariableDeclaration( Type type1, Type type2, IntegerLiteral lit, Identifier id, Statements stat )
	{
		this.type1 = type1;
		this.type2 = type2;
		this.lit = lit;
		this.id = id;
		this.stat = stat;
	}


}