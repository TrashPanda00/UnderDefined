/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 01.10.2006 Original version
 */
 
package AST;


public class IntegerLiteral
	extends Terminal
{
	public IntegerLiteral( String spelling )
	{
		this.spelling = spelling;
	}
	public Object visit( Visitor v, Object arg )
	{
		return v.visitIntegerLiteral( this, arg );
	}
}