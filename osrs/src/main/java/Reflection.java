import java.lang.reflect.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ObfuscatedClassMap;

public class Reflection {
	static Map<String, Class<?>> classes = new HashMap<>();

	//These are mixed in
	public static void reportFindClass(String className) {}
	public static void reportFindField(Class<?> className, String fieldName) {}
	public static void reportInvoke(Method method, Object object, Object[] args) {}

	static {
		ObfuscatedClassMap.INSTANCE.forEach((deobClassName, obfuscatedClassName) -> {
			if (!deobClassName.contains("/") && !obfuscatedClassName.contains("/")) {
				Class<?> c = null;
				try {
					c = Class.forName(deobClassName);
				} catch (Exception e) {
					e.printStackTrace();
				}
				classes.put(obfuscatedClassName, c);
			}
		});
	}

	public static Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> clazz = classes.get(name);
		if (clazz != null) {
			reportFindClass(clazz.getName());
			return clazz;
		}
		return Class.forName(name);
	}

	public static Field findField(Class<?> clazz, String name) throws NoSuchFieldException {
		reportFindField(clazz, name);
		for (Field f : clazz.getDeclaredFields()) {
			ObfuscatedName annotation = f.getAnnotation(ObfuscatedName.class);
			if ((annotation != null) && annotation.value().equals(name)) {
				return f;
			}
		}
		return clazz.getDeclaredField(name);
	}

	public static String getMethodName(Method method) {
		ObfuscatedName annotation = method.getAnnotation(ObfuscatedName.class);
		if (annotation != null) {
			return annotation.value();
		}
		return method.getName();
	}

	public static Class<?>[] getParameterTypes(Method method) {
		ObfuscatedSignature sig = method.getAnnotation(ObfuscatedSignature.class);
		Class<?>[] types = method.getParameterTypes();
		if (sig == null) {
			return types;
		}
		String s = sig.descriptor();
		int i = s.lastIndexOf(')');
		char c = s.charAt(i - 1);
		Class<?> last;
		switch (c) {
			case 'B' :
				last = byte.class;
				break;
			case 'I' :
				last = int.class;
				break;
			case 'S' :
				last = short.class;
				break;
			default :
				throw new IllegalStateException();}

		types = Arrays.copyOf(types, types.length + 1);
		types[types.length - 1] = last;
		return types;
	}

	public static int getInt(Field field, Object obj) throws IllegalArgumentException, IllegalAccessException {
		boolean unset = false;
		if ((field.getModifiers() & Modifier.PRIVATE) == 0) {


			field.setAccessible(true);
			unset = true;
		}
		int i;
		try {
			i = field.getInt(obj);
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (unset) {
				field.setAccessible(false);
			}
		}
		ObfuscatedGetter og = field.getAnnotation(ObfuscatedGetter.class);
		if (og != null) {
			int getter = og.intValue();
			int setter = modInverse(getter);

			i *= setter;
		}
		return i;
	}

	public static void setInt(Field field, Object obj, int value) throws IllegalArgumentException, IllegalAccessException {
		ObfuscatedGetter og = field.getAnnotation(ObfuscatedGetter.class);
		if (og != null) {
			int getter = og.intValue();

			value *= getter;
		}
		boolean unset = false;
		if ((field.getModifiers() & Modifier.PRIVATE) == 0) {


			field.setAccessible(true);
			unset = true;
		}
		try {
			field.setInt(obj, value);
		} finally {
			if (unset) {
				field.setAccessible(false);
			}
		}
	}

	public static BigInteger modInverse(BigInteger val, int bits) {
		BigInteger shift = BigInteger.ONE.shiftLeft(bits);
		return val.modInverse(shift);
	}

	public static int modInverse(int val) {
		return modInverse(BigInteger.valueOf(val), 32).intValue();
	}

	public static Object invoke(Method method, Object object, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		reportInvoke(method, object, args);
		try {
			return method.invoke(object, args);
		} catch (Throwable ex) {
			throw ex;
		}
	}
}