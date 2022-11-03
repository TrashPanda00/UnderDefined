package AST;


public interface Visitor
{
  public Object visitProgram( Program p, Object arg );

  public Object visitBlock( Block b, Object arg );

  public Object visitDeclarations( Declarations d, Object arg );

  public Object visitVariableDeclaration( VariableDeclaration v, Object arg );

  public Object visitFunctionDeclaration( FunctionDeclaration f, Object arg );

  public Object visitStatements( Statements s, Object arg );

  public Object visitExpressionStatement( ExpressionStatement e, Object arg );

  public Object visitIfStatement( IfStatement i, Object arg );

  public Object visitWhileStatement( WhileStatement w, Object arg );

  public Object visitPrintStatement( PrintStatement p, Object arg );

  public Object visitInputStatement (InputStatement i, Object arg);

  public Object visitValue(Value v,Object arg);

  public Object visitArrayExpression(ArrayExpression a,Object arg);

  public Object visitBinaryExpression( BinaryExpression b, Object arg );

  public Object visitVarExpression( VarExpression v, Object arg );

  public Object visitCallExpression( CallExpression c, Object arg );

  public Object visitUnaryExpression( UnaryExpression u, Object arg );

  public Object visitIntLitExpression( IntLitExpression i, Object arg );

  public Object visitFuncExpression(FuncExpression f,Object arg);

  public Object visitExpList( ExpList e, Object arg );

  public Object visitIdentifier( Identifier i, Object arg );

  public Object visitIntegerLiteral( IntegerLiteral i, Object arg );

  public Object visitOperator( Operator o, Object arg );
}
