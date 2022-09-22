package Scan;

import static Scan.TokenKind.*;

public class Token
{
//	public byte kind;
	
	public TokenKind kind;
	public String spelling;
	
	
	public Token( TokenKind kind, String spelling)
	{
		this.kind = kind;
		this.spelling = spelling;
			for( TokenKind tk: KEYWORDS )
				if( spelling.equals( tk.getSpelling() ) ) {
					this.kind = tk;
					break;
				}
	}
	
	
	public boolean isAssignOperator()
	{
		if( kind == OPERATOR )
			return containsOperator( spelling, ASSIGNOPS );
		else
			return false;
	}
	
	public boolean isAddOperator()
	{
		if( kind == OPERATOR )
			return containsOperator( spelling, ADDOPS );
		else
			return false;
	}
	
	public boolean isMulOperator()
	{
		if( kind == OPERATOR )
			return containsOperator( spelling, MULOPS );
		else
			return false;
	}
	
	
	private boolean containsOperator(String spelling, String OPS[])
	{
		for( int i = 0; i < OPS.length; ++i )
			if( spelling.equals( OPS[i] ) )
				return true;
				
		return false;
	}
	
	private static final TokenKind[] KEYWORDS = { START, END, DEFINE, RETURN, NULL, INT, ARRAY, BOOL, IF, ELSE, WHILE, PRINT, INPUT, NOT, EQUAL, OVER, UNDER };
	
	
	private static final String ASSIGNOPS[] =
	{
		"->",
	};

	
	private static final String ADDOPS[] =
	{
		"+",
		"-",
	};

	
	private static final String MULOPS[] =
	{
		"*",
		"/",
	};

	private static final String COMPOPS[] =
			{
					"EQ",
					"OV",
					"UN",
					"NOT",
			};
}