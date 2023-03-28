package library;

/*
 * 대여클래스
 * "이름", "핸드폰번호", "대여목록", 연체횟수 
 */

public class Rental {
	
	private String name; // 이름
	private String phone; // 연락처
	private String inventory; // 대여목록
	private int period; // 대여기간
	
	public Rental() {
		super();
	}

	public Rental(String name, String phone, String inventory, int period) {
		super();
		this.name = name;
		this.phone = phone;
		this.inventory = inventory;
		this.period = period;
	}                                                                                                                                                                                                                                                                                                                                                                                                                      

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public int getPeriod() {
		return period;
	}

	public void setOverdue(int period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "Rental [name=" + name + ", phone=" + phone + ", inventory=" + inventory + ", overdue=" + period + "]";
	}
	
	
	

}
