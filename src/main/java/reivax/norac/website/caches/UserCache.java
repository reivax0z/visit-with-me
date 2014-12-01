package reivax.norac.website.caches;

import java.util.List;

import reivax.norac.website.dto.UsersDTO;

public class UserCache extends Cache<UsersDTO> {

	public UserCache(String name) {
		super(name);
	}

	private static UserCache instance = new UserCache("User cache");
	
	public static UserCache getInstance(){
		return instance;
	}
	
	@Override
	protected List<UsersDTO> refreshAllAction() {
		return webSiteEJB.getAllUsersFromDb();
	}

	@Override
	protected void addAction(UsersDTO element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	protected void updateAction(UsersDTO element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
