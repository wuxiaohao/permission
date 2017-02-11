package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Authenticator.RequestorType;

/**
 * 权限注解
 */
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
public @interface Permission {

	/**
	 * 0000：没有权限
	 * 0001：read   对应的10进制为 ：1
	 * 0010：create 对应的10进制为 ：2
	 * 0100：update 对应的10进制为 ：4
	 * 1000：delete 对应的10进制为 ：8
	 */
	int value();
	
}
