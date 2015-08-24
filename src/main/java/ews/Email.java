package ews;

import java.util.UUID;

@FunctionalInterface
public interface Email<T> {
	
	T valida();
	
	default boolean status() {
		System.out.println("STATUS DEFULT");
		return false;
	}
	
	public static String idEmail() {
		return UUID.randomUUID().toString();
	}
	
}