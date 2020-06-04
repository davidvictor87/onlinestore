package spring.online.store.login.model;

public enum LevelType {

	ADMIN(1), MANAGER(2), CUSTOMER(3), VISITOR(4);

	private int level;

	private LevelType(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

}
