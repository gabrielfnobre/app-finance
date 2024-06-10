package br.com.nobrecoder.fin_interface;

import java.lang.reflect.Field;

import br.com.nobrecoder.operations.animal.Cat;

public class Aula04_UsingReflectionWithOpenModules {

	public static void main(String[] args) {
		
		Cat cat = new Cat();
		System.out.println(cat.getMeow());
		
		Field field;
		try {
			field = Cat.class.getDeclaredField("meow");
			field.setAccessible(true);
			field.set(cat, "Hau!Hau!");
			field.setAccessible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(cat.getMeow());
		
	}
	
}
