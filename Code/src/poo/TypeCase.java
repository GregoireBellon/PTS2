package poo;

public enum TypeCase {
	Innexistante, Vide, Cochon, Loup, Jardin, Maison;

	@Override
	public String toString() {

		switch (this) {
		case Innexistante:
			return "   ";
		case Vide:
			return "[ ]";
		case Cochon:
			return "[C]";
		case Loup:
			return "[L]";
		case Jardin:
			return "[J]";
		case Maison:
			return "[M]";
		}
		return "";
	}
}
