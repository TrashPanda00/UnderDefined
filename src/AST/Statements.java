/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 29.09.2006 Original version
 */
 
package AST;


import java.util.*;


public class Statements
	extends AST
{
	public Vector<Statement> stat = new Vector<Statement>();
	public Object visit( Visitor v, Object arg )
	{
		return v.visitStatements( this, arg );
	}
}