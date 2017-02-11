package annotation;

/**
 * 权限常量
 */
public interface PermissionValue {
	
	int READ = 1;   //对应二进制 0001
	int CREATE = 2; //对应二进制 0010
	int UPDATE = 4; //对应二进制 0100
	int DELETE = 8; //对应二进制 1000

}
