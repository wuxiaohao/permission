package model;

/**
 * ����û���Ȩ��
 * @author wxh
 *
 */
public enum Context {

	INSTATNCE;
	
	private ThreadLocal<Integer> permission = new ThreadLocal<Integer>();

	public void setCurrentPermission(int make) {
		permission.set( make );
	}
	
	public int getCurrentPermission() {
		return permission.get();
	}
	
}
