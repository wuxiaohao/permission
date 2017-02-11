package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Authenticator.RequestorType;

/**
 * Ȩ��ע��
 */
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
public @interface Permission {

	/**
	 * 0000��û��Ȩ��
	 * 0001��read   ��Ӧ��10����Ϊ ��1
	 * 0010��create ��Ӧ��10����Ϊ ��2
	 * 0100��update ��Ӧ��10����Ϊ ��4
	 * 1000��delete ��Ӧ��10����Ϊ ��8
	 */
	int value();
	
}
