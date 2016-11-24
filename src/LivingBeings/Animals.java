package LivingBeings;

public class Animals {
	public int legs;
	public int lengthOfLife;
	public String type;
	public String name;
	public String sex;
	public boolean isHuman;

	public Animals(int legs, int lengthOfLife, String type, String name, String sex, boolean isHuman) {
		this.legs = legs;
		if (lengthOfLife > 0 && lengthOfLife < 100) {
			this.lengthOfLife = lengthOfLife;
		} else {
			useValidValue("lengthOfLife");
		}
		this.type = type;
		this.name = name;
		if(sex == "male" || sex == "female") {
			this.sex = sex;
		} else {
			useValidValue("sex");
		}
		this.isHuman = isHuman;
	}

	public int getLegs() {
		return legs;
	}

	public int getLengthOfLife() {
		return lengthOfLife;
	}

	public String getName() {
		return name;
	}
	
	public String getSex() {
		return sex;
	}

	public String getType() {
		return type;
	}
	
	public static void useValidValue(String var) {
		System.err.println("Please enter valid value for variable " + var);
	}
}
