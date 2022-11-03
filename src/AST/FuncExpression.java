package AST;

public class FuncExpression extends Expression
{
  public Identifier id1;
  public Expression exp;

  public FuncExpression(Identifier id1,Expression exp)
  {
    this.id1 = id1;
    this.exp = exp;
  }




  @Override public Object visit(Visitor v, Object arg)
  {
    return v.visitFuncExpression(this,arg);
  }
}
