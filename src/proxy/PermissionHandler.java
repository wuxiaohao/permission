package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import model.Context;
import annotation.Permission;

/**
 * 代理类
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
			//获取当前用户的权限
			int make = Context.INSTATNCE.getCurrentPermission();
			if ( !( ( make & anno.value() ) == anno.value() ) ) {
				throw new SecurityException( "用户权限不足！" );
			}
		}
		//如果能运行到这里，就表示有权限，那么交给实际的类去处理
		return method.invoke( target, args );
	}
	
}
