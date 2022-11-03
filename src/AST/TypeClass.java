package AST;

public class TypeClass extends AST
{
	TypeName type;
	public boolean rvalueOnly;
	public enum TypeName {
		INT,
		ARR,
		BOOL,
		NULL,
		ERROR
	}
	public TypeClass( boolean rvalueOnly )
	{
		this.rvalueOnly = rvalueOnly;
	}
	public TypeClass(TypeName name)
	{
		type = name;
	}
}
