package Scan;

import static Scan.TokenKind.*;

public class Parser
{
	private Scanner scan;
	private Token currentTerminal;

	public Parser(Scanner scan)
	{
		this.scan = scan;

		currentTerminal = scan.scan();
	}

	public void parseProgram()
	{
		parseBlock();
		if(currentTerminal.kind != EOT)
			System.out.println("Tokens found after end of program");
	}

	private void parseBlock()
	{
		accept(START);
		while(currentTerminal.kind != END)
		{
			parseDeclarations();
			parseStatements();
		}
		accept(END);
	}

	private void parseDeclarations()
	{
		while(currentTerminal.kind == INT ||
		      currentTerminal.kind == BOOL ||
		      currentTerminal.kind == ARRAY ||
		      currentTerminal.kind == DEFINE)
			parseOneDeclaration();
	}

	private void parseOneDeclaration()
	{
		switch(currentTerminal.kind)
		{
			case INT:
				accept(INT);
				accept(IDENTIFIER);
				if(currentTerminal.kind == RIGHTSQUARE)
					break;
				if(currentTerminal.kind != SEMICOLON)
					parseOneStatement();
				else
					accept(SEMICOLON);
				break;

			case ARRAY:
				accept(ARRAY);
				accept(IDENTIFIER);
				accept(LEFTARROW);
				if(currentTerminal.kind == INT)
					accept(INT);
				if(currentTerminal.kind == BOOL)
					accept(BOOL);
				accept(RIGHTARROW);
				accept(LEFTSQUARE);
				accept(INTEGERLITERAL);
				accept(RIGHTSQUARE);
				if(currentTerminal.kind != SEMICOLON)
					parseOneStatement();
				else
					accept(SEMICOLON);
				break;

			case BOOL:
				accept(BOOL);
				accept(IDENTIFIER);
				if(currentTerminal.kind != SEMICOLON)
					parseOneStatement();
				else
					accept(SEMICOLON);
				break;

			case DEFINE:
				accept(DEFINE);
				if(currentTerminal.kind == INT)
					accept(INT);
				if(currentTerminal.kind == BOOL)
					accept(BOOL);
				if(currentTerminal.kind == ARRAY)
					accept(ARRAY);
				if(currentTerminal.kind == NULL)
					accept(NULL);
				accept(IDENTIFIER);
				accept(LEFTSQUARE);
				parseDeclarations();
				accept(RIGHTSQUARE);
				accept(LEFTARROW);
				parseStatements();
				if(currentTerminal.kind == RETURN)
				{
					accept(RETURN);
					parseExpression();
				}
				accept(RIGHTARROW);
				break;

			default:
				System.out.println("Declaration or statement expected.");
				break;
		}
	}

	private void parseStatements()
	{
		while(currentTerminal.kind == IDENTIFIER ||
		      currentTerminal.kind == OPERATOR ||
		      currentTerminal.kind == INTEGERLITERAL ||
		      currentTerminal.kind == IF ||
		      currentTerminal.kind == WHILE ||
		      currentTerminal.kind == PRINT ||
		      currentTerminal.kind == INPUT)
			parseOneStatement();
	}

	private void parseOneStatement()
	{
		switch(currentTerminal.kind)
		{
			case IDENTIFIER:
			case INTEGERLITERAL:
			case OPERATOR:
				parseExpression();
				break;
			case IF:
				accept(IF);
				accept(LEFTSQUARE);
				parseExpression();
				accept(RIGHTSQUARE);
				accept(LEFTARROW);
				parseStatements();
				accept(RIGHTARROW);

				if(currentTerminal.kind == ELSE)
				{
					accept(ELSE);
					accept(LEFTARROW);
					parseStatements();
					accept(RIGHTARROW);
				}
				break;

			case WHILE:
				accept(WHILE);
				accept(LEFTSQUARE);
				parseExpression();
				accept(RIGHTSQUARE);
				accept(LEFTARROW);
				parseStatements();
				accept(RIGHTARROW);
				break;

			case PRINT:
				accept(PRINT);
				accept(LEFTSQUARE);
				parseExpression();
				accept(RIGHTSQUARE);
				accept(SEMICOLON);
				break;

			case INPUT:
				accept(INPUT);
				accept(LEFTSQUARE);
				if(currentTerminal.kind == INT)
					accept(INT);
				if(currentTerminal.kind == BOOL)
					accept(BOOL);
				if(currentTerminal.kind == ARRAY)
					accept(ARRAY);
				accept(COMMA);
				accept(IDENTIFIER);
				accept(RIGHTSQUARE);
				accept(SEMICOLON);
				break;

			default:
				System.out.println("Error in statement");
				break;
		}
	}

	private void parseExpression()
	{
		parsePrimary();
		while(currentTerminal.kind == OPERATOR)
		{
			accept(OPERATOR);
			parsePrimary();
		}
		if(currentTerminal.kind != COMMA && currentTerminal.kind != RIGHTPARAN && currentTerminal.kind != RIGHTSQUARE)
			accept(SEMICOLON);
	}

	private void parsePrimary()
	{
		switch(currentTerminal.kind)
		{
			case IDENTIFIER:
				accept(IDENTIFIER);

				if(currentTerminal.kind == LEFTARROW)
				{
					accept(LEFTARROW);

					if(currentTerminal.kind == INT)
						accept(INT);
					if(currentTerminal.kind == BOOL)
						accept(BOOL);
					if(currentTerminal.kind == ARRAY)
						accept(ARRAY);

					accept(RIGHTARROW);
					accept(LEFTSQUARE);
					accept(INTEGERLITERAL);
					accept(RIGHTSQUARE);
				}
				if(currentTerminal.kind == LEFTSQUARE)
				{
					accept(LEFTSQUARE);
					if(currentTerminal.kind == INTEGERLITERAL)
						accept(INTEGERLITERAL);
					if(currentTerminal.kind == IDENTIFIER)
						accept(IDENTIFIER);
					accept(RIGHTSQUARE);
				}
				break;

			case INTEGERLITERAL:
				accept(INTEGERLITERAL);
				break;

			case OPERATOR:
				accept(OPERATOR);
				parsePrimary();
				break;

			case LEFTPARAN:
				accept( LEFTPARAN );
				parseExpressionList();
				accept( RIGHTPARAN );
				break;

			case VALUE:
				accept(VALUE);
				break;

			default:
				System.out.println("Error in primary");
				break;
		}
	}

	private void parseExpressionList()
	{
		parseExpression();
		while(currentTerminal.kind == COMMA)
		{
			accept(COMMA);
			parseExpression();
		}
	}

	private void accept(TokenKind expected)
	{
		if(currentTerminal.kind == expected)
		{
			System.out.println(expected + "   " + currentTerminal.spelling);
			currentTerminal = scan.scan();
		}
		else
			System.out.println("Expected token of kind " + expected);
	}
}
