/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 29.09.2006 Original version
 */
 
package AST;


public class Program
	extends AST
{
	public Block block;

	public Program( Block block )
	{
		this.block = block;
	}
	public Object visit( Visitor v, Object arg )
	{
		return v.visitProgram( this, arg );
	}
}