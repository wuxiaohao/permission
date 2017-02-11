import annotation.Permission;
import annotation.PermissionValue;

/**
 * 关于位与（&）运算
 * @author wxh
 *
 */
public class Test {

	public static void main(String[] args) {
		//0110
		int make = 6;
		// 0110
		// 0001
		// 0000 ---》 0
		System.out.println( (6 & PermissionValue.READ) == PermissionValue.READ );
		// 0110
		// 0010
		// 0010 ---》 2	
		System.out.println((6 & PermissionValue.CREATE) == PermissionValue.CREATE );
	}
	
}
