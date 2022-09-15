package Scan;

public enum TokenKind
{
	IDENTIFIER,
	INTEGERLITERAL,
	OPERATOR,
	
	START( "START" ),
	END( "END" ),
	DEFINE( "DEFINE" ),
	RETURN( "RETURN" ),
	NULL( "NULL" ),
	INT( "INT" ),
	ARRAY( "ARR" ),
	BOOL( "BOOL" ),
	IF( "IF" ),
	WHILE( "WHILE" ),
	PRINT( "PRINT" ),
	INPUT( "INPUT" ),
	
	COMMA( "," ),
	SEMICOLON( ";" ),
	LEFTPARAN( "(" ),
	RIGHTPARAN( ")" ),
	LEFTSQUARE( "[" ),
	RIGHTSQUARE( "]" ),
	LEFTARROW( "<" ),
	RIGHTARROW( ">" ),
	
	EOT,
	
	ERROR;
	
	
	private String spelling = null;
	
	
	private TokenKind()
	{
	}
	
	
	private TokenKind( String spelling)
	{
		this.spelling = spelling;
	}
	
	
	public String getSpelling()
	{
		return spelling;
	}
}