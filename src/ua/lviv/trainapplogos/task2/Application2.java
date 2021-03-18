package ua.lviv.trainapplogos.task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application2 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class sc = Student.class;
		
		Constructor<Student> constructor = sc.getConstructor(String.class, int.class, int.class, int.class);

		Person newInstancePerson = constructor.newInstance("Johnny Mnemonic", 22, 33, 4);
		System.out.println("Reflection class: "+ newInstancePerson);
		Field[] fields = sc.getFields();
		
		System.out.println("> Value of field '" + fields[0].getName() + "': " + fields[0].get(newInstancePerson));
		System.out.println("> Value of field '" + fields[1].getName() + "': " + fields[1].get(newInstancePerson));
		
		fields[1].set(newInstancePerson, 28);
		System.out.println("New value of field '" + fields[1].getName() + "': " + fields[1].get(newInstancePerson));
		System.out.println("Reflection class: "+ newInstancePerson);  
	
		//Method execution
		Method[] declaredMethods = sc.getMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			Method method = declaredMethods[i];
			System.out.println("> Method's #" + (i + 1) + " [name]: " + method.getName() + " [params count]: " + method.getParameterCount());
		}
		
		Method method = sc.getMethod("BreakSession");
		method.invoke(newInstancePerson); //BreakSession()
		
		Method method2 = sc.getMethod("OutputGritting", String.class);
		method2.invoke(newInstancePerson, "Hello");
		
		Class<?>[] paramTypes = {String.class, int.class};

		Method method3 = sc.getMethod("OutputGritting", paramTypes);
//		Method method3 = sc.getMethod("OutputGritting", String.class, String.class);
		
		method3.invoke(newInstancePerson, "Hello", 4);
		
		
	}
}
