package enums;

public enum AutoGeneratorStrategies {
	
	ITEM("item"),
	ULTIMA("ultima"),
	ITENS_PRESENTES("itens mais presentes");
	
	private String strategy;
	
	private AutoGeneratorStrategies(String strategy) {
		this.strategy = strategy;
	}

	public String getStrategy() {
		return strategy;
	}	
}
