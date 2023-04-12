package hyl;


public class UserAccount {

	private int id;
	private String userName;
	private String password;
	private String email;
	private int admin;
	 
	public UserAccount(){ 
	}
	 
	public UserAccount(int id ,String username, String password, String email, int admin){
		 this.id=id;
		 this.userName=username;
		 this.password=password;
		 this.admin = admin;
	}
	 
	public UserAccount(int id ,String username, String password){
		this.id=id;
		this.userName=username;
		this.password=password;
	}
	
	public UserAccount(String username, String password, String email, int admin){
		this.userName=username; 
		this.password=password;
		this.email=email;
		this.admin=admin;
	}
	 
	public UserAccount(String username, String password){
		this.userName=username; 
		this.password=password;
	}
	 
	public UserAccount(UserAccount us){
		this.id=us.id;
		this.userName=us.userName;
		this.password=us.password;
		this.admin = us.admin;
	}
	  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdmin() {
		return admin;
	}
	
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	 
}
