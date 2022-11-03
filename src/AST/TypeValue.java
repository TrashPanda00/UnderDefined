package AST;

public class TypeValue extends AST
{
	public TypeName type;
	public boolean rvalueOnly;

	public enum TypeName {
		INT,
		ARR,
		BOOL,
		NULL,
		ERROR
	}
	public TypeValue(boolean rvalueOnly)
	{
		this.rvalueOnly = rvalueOnly;
	}

	public TypeValue(TypeName name)
	{
		type = name;
	}

	public Object visit(Visitor v, Object arg)
	{
		return null;
	}

}
