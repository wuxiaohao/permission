package Dao;

import model.Account;

public class AccountDao implements IAccountDao {
	@Override
	public void create(Account account) {
		System.out.println("创建Account");
	}
	@Override
	public void delete(String name) {
		System.out.println("删除Account");
	}
	@Override
	public void update(Account account) {
		System.out.println("修改Account");
	}
	@Override
	public Account load(String name) {
		System.out.println("读取Account");
		Account account = new Account();
		account.setName(name);
		return account ;
	}
	@Override
	public void createAndUpdate(Account... accounts) {
		System.out.println("创建并更新");
	}

}
