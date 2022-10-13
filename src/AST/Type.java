package AST;

public class Type
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
	public Type( boolean rvalueOnly )
	{
		this.rvalueOnly = rvalueOnly;
	}
	public Type(TypeName name)
	{
		type = name;
	}
}
