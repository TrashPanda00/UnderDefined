/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 23.10.2006 IdList replaced by Declarations for function parameters
 * 29.09.2006 Original version
 */
 
package AST;


public class FunctionDeclaration
	extends Declaration
{
	public Type type;
	public Identifier name;
	public Declarations params;
	public Block block;
	public Expression retExp;
	
	
	public FunctionDeclaration(Type type, Identifier name, Declarations params,
	                           Block block, Expression retExp )
	{
		this.type = type;
		this.name = name;
		this.params = params;
		this.block = block;
		this.retExp = retExp;
	}

	public FunctionDeclaration(Type type, Identifier name, Declarations params,
	                           Block block)
	{
		this.type = type;
		this.name = name;
		this.params = params;
		this.block = block;
	}
}