package AST;

public class TypeClass extends AST
{
	public TypeName type;

	public enum TypeName {
		INT,
		ARR,
		BOOL,
		NULL,
		ERROR
	}

	public TypeClass(TypeName name)
	{
		type = name;
	}
}
