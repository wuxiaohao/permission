import annotation.PermissionValue;
import model.Account;
import model.Context;
import Dao.DaoFactory;
import Dao.IAccountDao;


public class Main {
	
	public static void main(String[] args) {
		//给当前线程设置读和改的权限
		Context.INSTATNCE.setCurrentPermission(PermissionValue.READ 
				+ PermissionValue.UPDATE);
		IAccountDao dao = DaoFactory.getDao( IAccountDao.class );
		Account account = dao.load("wxh"); //测试有无读取权限
		dao.update(account); //测试有无修改权限
		dao.delete("wxh");
	}

}
