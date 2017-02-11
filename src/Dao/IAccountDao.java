package Dao;

import annotation.Permission;
import annotation.Dao;
import annotation.PermissionValue;
import model.Account;

@Dao(AccountDao.class)
public interface IAccountDao {

	//添加账号
	@Permission(PermissionValue.CREATE) //对应二进制 0001
	void create(Account account);
	
	//删除账号
	@Permission(PermissionValue.DELETE) //对应二进制 0010
	void delete(String name);
	
	//修改账号
	@Permission(PermissionValue.UPDATE) //对应二进制 0100
	void update(Account account);
	
	//查询账号
	@Permission(PermissionValue.READ) //对应二进制 1000
	Account load(String name);
	
	@Permission(PermissionValue.CREATE + PermissionValue.UPDATE)
	void createAndUpdate(Account...accounts);
}
