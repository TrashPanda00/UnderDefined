/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 01.01.2006 Original version
 */
 
package AST;


import java.util.*;


public class ExpList
	extends AST


{
	private int a ;

	public void func(){
		int a = 1;
		this.a = a;
	}

	public Vector<Expression> exp = new Vector<Expression>();
	public Object visit( Visitor v, Object arg )
	{
		return v.visitExpList( this, arg );
	}
}