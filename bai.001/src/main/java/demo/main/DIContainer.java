package demo.main;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class DIContainer {

	private Set<Object> instances = new HashSet<>();

	public DIContainer(Set<Class<?>> clazzes) throws Exception {

		// tạo thể hiện tương ứng với tên mỗi lớp được khai báo.
		for (Class<?> clazz : clazzes) {
			Constructor<?> constructor = clazz.getConstructor();
			constructor.setAccessible(true);
			Object instance = constructor.newInstance();
			instances.add(instance);
		}
		
		//gán giá trị cho tất cả các dependency có trong đối tượng được tạo thành.

	}
}
