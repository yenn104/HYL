package hyl;

public class Benh {
	private int idB;
	private String tenB;
	private int slg;
	private float xs;
	private String info;
	
	public Benh() {
		super();
	}

	public Benh(int idB, String tenB, int slg, float xs, String info) {
		this.idB = idB;
		this.tenB = tenB;
		this.slg = slg;
		this.xs = xs;
		this.info = info;
	}
	
	public Benh(Benh benh) {
		this.idB = benh.idB;
		this.tenB = benh.tenB;
		this.slg = benh.slg;
		this.xs = benh.xs;
		this.info = benh.info;
	}

	public Benh(String tenB, int slg, float xs, String info) {
		this.tenB = tenB;
		this.slg = slg;
		this.xs = xs;
		this.info = info;
	}
	
	public Benh(String tenB, int slg, float xs) {
		this.tenB = tenB;
		this.slg = slg;
		this.xs = xs;
	}

	public Benh(int idB, String tenB, int slg, String info) {
		this.idB = idB;
		this.tenB = tenB;
		this.slg = slg;
		this.info = info;
	}
	
	public Benh(int idB, String tenB, String info) {
		this.idB = idB;
		this.tenB = tenB;
		this.info = info;
	}

	public Benh(String tenB, String info) {
		this.tenB = tenB;
		this.info = info;
	}
	
	public Benh(int idB, int slg) {
		this.idB = idB;
		this.slg = slg;
	}

	public float getXs() {
		return xs;
	}

	public void setXs(float xs) {
		this.xs = xs;
	}

	public Benh(String tenB, int slg) {
		this.tenB = tenB;
		this.slg = slg;
	}

	public int getIdB() {
		return idB;
	}

	public void setIdB(int idB) {
		this.idB = idB;
	}

	public String getTenB() {
		return tenB;
	}

	public void setTenB(String tenB) {
		this.tenB = tenB;
	}

	public int getSlg() {
		return slg;
	}

	public void setSlg(int slg) {
		this.slg = slg;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
