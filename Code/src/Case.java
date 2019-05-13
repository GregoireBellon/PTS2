
public class Case {

private TypeCase type;	
	
	public Case(TypeCase type) {
		this.setType(type);
	}
	
	public TypeCase getType() {
		return type;
	}
	
	public void setType(TypeCase type) {
		this.type=type;
	}
	
	@Override
	public String toString() {
		switch (this.getType()) {
		
		case Innexistante:
			return " ";
		case Vide:
			return "-";
		case Cochon:
			return "C";
		case Loup:
			return "L";
		case Jardin:
			return "J";
		case Maison:
			return "M";
		default :
			return "D";
		
		}
	}
	
}
