package entity;

/**
 * �û�
 * @author macos
 *
 */
public class User {
	/**
	 * �û���
	 */
	private String username;
	/**
	 * ����
	 */
	private String pwd;
	/**
	 * �Ƿ��ס����
	 */
	private boolean isRemember;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isRemember() {
		return isRemember;
	}
	public void setRemember(boolean isRemember) {
		this.isRemember = isRemember;
	}
	public User(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}
	public User() {
	}
	
}
