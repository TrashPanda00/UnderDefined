package AST;

public class Type
{
	TypeName type;

	public enum TypeName {
		INT,
		ARR,
		BOOL,
		NULL,
		ERROR
	}

	public Type(TypeName name)
	{
		type = name;
	}
}
