package AST;

public class FuncExpression extends Expression
{
  public Identifier id1;
  public Identifier id2;
  public IntegerLiteral lit;

  public FuncExpression(Identifier id1,Identifier id2)
  {
    this.id1 = id1;
    this.id2 = id2;
  }

  public FuncExpression(Identifier id1, IntegerLiteral lit)
  {
    this.id1 = id1;
    this.lit = lit;
  }


  @Override public Object visit(Visitor v, Object arg)
  {
    return v.visitFuncExpression(this,arg);
  }
}
