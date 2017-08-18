package cn.bdqn.seriver.User;

import cn.bdqn.bean.User;
import cn.bdqn.seriver.ConSeriver;

public interface UserSeriver extends ConSeriver<User> {
	User login(String name,String  password);
}
