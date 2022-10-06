/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 29.09.2006 Original version
 */

package AST;


public class InputStatement
		extends Statement
{
	public Identifier idf;
	public Type type;

	public InputStatement(Type type, Identifier idf)
	{
		this.idf = idf;
		this.type = type;
	}
}