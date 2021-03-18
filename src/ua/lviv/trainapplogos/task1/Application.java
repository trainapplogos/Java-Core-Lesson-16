package ua.lviv.trainapplogos.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Application {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, NoSuchFieldException {
		//Student st = new Student("Johnny Depp", 23, 178, 4);
		Class sc = Student.class;
		
		//get Class full name
		System.out.println("\n> Class full name: " + sc.getName());
		
		//get Class simple name
		String simpleName = sc.getSimpleName();
		System.out.println("\n> Class simple name: " + simpleName);
		
		//get super class
		System.out.println("\n> Parent class: " + sc.getSuperclass()); 
		
		//get used interfaces
		System.out.println("\n> Used interfaces:");
		GetInterfaces(sc);
		
		//get Class modifiers
		int mod = sc.getModifiers();
		System.out.println("\n> Modifier of class " + simpleName + ": " + Modifier.toString(mod)); ;
		
		//get Class constructors
		GetConstructor(sc, simpleName);
		
		//********************[ Fields ]********************
		System.out.println("\n> List of fields:");
		GetFields(sc, false);
		
		System.out.println("\n> List of declarated fields:");
		GetFields(sc, true);
		
		Field nameField = sc.getField("name");
		System.out.println("\n> Custom field name: " + nameField);
		
//		Field yearOfStudyField = sc.getField("yearOfStudy");
//		yearOfStudyField.setAccessible(true);
		//System.out.println("\n> Custom field yearOfStudy: " + yearOfStudyField); //can't access
		
		//********************[ Methods ]********************
		System.out.println("\n> Methods used in " + simpleName + " (without private):");
		OutputClassMethods(sc, false);
		
		System.out.println("\n> Declared methods used in " + simpleName + " (with private):");
		OutputClassMethods(sc, true);
		
	}

	private static void GetInterfaces(Class sc) {
		Object[] inters = sc.getInterfaces();
		for (int i = 0; i < inters.length; i++) {
			Object inter = inters[i];
			System.out.println(">> interface: " + inter);
		}
	}

	private static void GetConstructor(Class sc, String simpleName) throws NoSuchMethodException {
		Constructor<Student>[] cons = sc.getConstructors();
		System.out.println("\nAmount of constructors of class " + simpleName + ": " + cons.length);
		System.out.println("> Constructors of class " + simpleName + ":");
		
		for (int i = 0; i < cons.length; i++) { 				
			System.out.println(">> Constructor: " + cons[i]);
		}
		
		for (int i = 0; i < cons.length; i++) {
			Constructor<Student> constructor = cons[i];
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			int parametersCount = constructor.getParameterCount();
					
			if (parametersCount > 0) {
				System.out.println("\n> Count of parameters of " + (i + 1) + " constractor: " + parametersCount);
				System.out.println("> Parameters of " + (i + 1) + " constractor:");
			} else System.out.println("\n> Constractor " + (i + 1) + " hasn't parameters");
			
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" >> " + parameterTypes[j]);
			}
		}
		
		//get constructor by params
		Constructor<Student> constructor2 = sc.getConstructor(String.class, int.class, int.class, int.class);
		System.out.println("\n> Constructor by params: " + constructor2);
	}

	private static void GetFields(Class sc, boolean isDeclared) {
		Field[] fields = (isDeclared) ? sc.getDeclaredFields() : sc.getFields();
		for (int i = 0; i < fields.length; i++) {
//			System.out.println(">> Field " + (i + 1) + ": " + fields[i]);
			Field field = fields[i];
			System.out.println(" Field " + (i + 1) + "> modifier: [" + Modifier.toString(field.getModifiers())  + "]; type: [" + 
					field.getType() + "]; name: [" + field.getName() + "]");
//			System.out.println(" > Field generic type: " + field.getGenericType());
		}
	}

	private static void OutputClassMethods(Class sc, boolean isDeclared) {
		Method[] methods = (isDeclared) ? sc.getDeclaredMethods() : sc.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			
			System.out.println(">> Method #" + (i + 1) + ": " + method);
			System.out.println("   return type of method: " + method.getReturnType());
			Class<?>[] exceptionTypes = method.getExceptionTypes();			
			for (int j = 0; j < exceptionTypes.length; j++) {
				System.out.println(" Exception " + (j + 1) + ": "+ exceptionTypes[j]);
			}
			//+ "\n"
			System.out.println("  Name by field: " + method.getName() );
			System.out.println("  Modifier of method:" + Modifier.toString(method.getModifiers()));
			
			int parameterCount = method.getParameterCount();
			System.out.println("  Count of parameters: " + parameterCount);
			Parameter[] parameters = method.getParameters();
			if (parameterCount > 0) { 
				System.out.println(">>> Params settings: ");
				for (int n = 0; n < parameters.length; n++) {
					Parameter parameter = parameters[n];
					System.out.println("   *params type: [" + parameter.getType() + "]; params name: [" + parameter.getName() + "]"); 
					System.out.println("   *modifiers of parameters: " + Modifier.toString(parameter.getModifiers()));
					
					Class<?>[] parameterTypes2 = method.getParameterTypes();
					for (int m = 0; m < parameterTypes2.length; m++) {
						System.out.println("   *Parameters Type: " + parameterTypes2[m]);
					}
					
					Type parameterizedType = parameter.getParameterizedType();
					System.out.println("   *Parameterized Type: " + parameterizedType.getTypeName());
					
					TypeVariable<Method>[] typeParameters = method.getTypeParameters();
					for (int j = 0; j < typeParameters.length; j++) {
						System.out.println("   *Type parameters name: " + typeParameters[j].getName());
						System.out.println("   *Type parameters type name: " + typeParameters[j].getTypeName());
					}
				}
			}
		}
	}
	
	
}
