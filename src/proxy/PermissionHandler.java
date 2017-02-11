package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import model.Context;
import annotation.Permission;

/**
 * ������
 */
public class PermissionHandler implements InvocationHandler{
	

	private Object target;
	
	public PermissionHandler( Object target ) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Permission anno = method.getAnnotation( Permission.class );
		if ( anno != null ) {
			//��ȡ��ǰ�û���Ȩ��
			int make = Context.INSTATNCE.getCurrentPermission();
			if ( !( ( make & anno.value() ) == anno.value() ) ) {
				throw new SecurityException( "�û�Ȩ�޲��㣡" );
			}
		}
		//��������е�����ͱ�ʾ��Ȩ�ޣ���ô����ʵ�ʵ���ȥ����
		return method.invoke( target, args );
	}
	
}
