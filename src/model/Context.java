package model;

/**
 * 存放用户的权限
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
