package br.com.hivecloud.msbookregister.model.enums;

public enum StatusBook {

	READING(1, "Lendo"),
	READ(2, "Lido"),
	TO_READ(3, "Para Ler");

	private int cod;
	private String description;

	private StatusBook(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static StatusBook toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (StatusBook p : StatusBook.values()) {
			if (cod.equals(p.getCod())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Invalid ID " + cod);
	}
}