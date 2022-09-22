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
		accept(START);
		parseBlock();
		accept(END);
		if(currentTerminal.kind != EOT)
			System.out.println("Tokens found after end of program");
	}

	private void parseBlock()
	{
		parseDeclarations();
		parseStatements();
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
				if(currentTerminal.kind != SEMICOLON)
					parseOneStatement();
				accept(SEMICOLON);
				break;

			case ARRAY:
				accept(ARRAY);
				accept(IDENTIFIER);
				if(currentTerminal.kind != SEMICOLON)
					parseOneStatement();
				accept(SEMICOLON);
				break;

			case BOOL:
				accept(BOOL);
				accept(IDENTIFIER);
				if(currentTerminal.kind != SEMICOLON)
					parseOneStatement();
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
				parseBlock();
				if(currentTerminal.kind == RETURN)
					accept(RETURN);
				parseExpression();
				accept(RIGHTARROW);
				break;

			default:
				System.out.println("Declaration or statement expected.");
				break;
		}
	}

	private void parseIdList()
	{
		accept(IDENTIFIER);

		while(currentTerminal.kind == COMMA)
		{
			accept(COMMA);
			accept(IDENTIFIER);
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
				break;
			case IF:
				accept(IF);
				accept(LEFTSQUARE);
				parseExpression();
				accept(RIGHTSQUARE);
				accept(LEFTARROW);
				parseBlock();
				accept(RIGHTARROW);

				if(currentTerminal.kind == ELSE)
				{
					accept(ELSE);
					accept(LEFTARROW);
					parseBlock();
					accept(RIGHTARROW);
				}
				break;

			case WHILE:
				accept(WHILE);
				accept(LEFTSQUARE);
				parseExpression();
				accept(RIGHTSQUARE);
				accept(LEFTARROW);
				parseBlock();
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
					accept(INTEGERLITERAL);
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
			currentTerminal = scan.scan();
		else
			System.out.println("Expected token of kind " + expected);
	}
}
