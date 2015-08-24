package jse7;

public class DemoMulticatch {

	public static void main(String[] args) {
		Object o = null;
		try {
			Class clazz = Class.forName("java.lang.String");
			o = clazz.newInstance();
			System.out.println(o.getClass());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			System.err.println("Erro na criacao do objeto: " + ex.getMessage());
		}
	}

}
