package org.inventivetalent.reflectionhelper.test;

import org.inventivetalent.reflection.resolver.wrapper.MethodWrapper;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class Test {

	public double primitiveDummyMethod(String aString, double returnValue) {
		return returnValue;
	}

	public Method genericDummyMethod(Thread aThread, Exception aException) {
		return null;
	}

	public void voidDummyMethod(Character aCharacter, Class aClass, String aString) {
	}

	@org.junit.Test
	public void primitiveSignatureTest() throws ReflectiveOperationException {
		String signature = MethodWrapper.getMethodSignature(Test.class.getMethod("primitiveDummyMethod", String.class, double.class));
		assertEquals("double primitiveDummyMethod(String,double)", signature);
	}

	@org.junit.Test
	public void genericSignatureTest() throws ReflectiveOperationException {
		String signature = MethodWrapper.getMethodSignature(Test.class.getMethod("genericDummyMethod", Thread.class, Exception.class));
		assertEquals("Method genericDummyMethod(Thread,Exception)", signature);
	}

	@org.junit.Test
	public void voidSignatureTest() throws ReflectiveOperationException {
		String signature = MethodWrapper.getMethodSignature(Test.class.getMethod("voidDummyMethod", Character.class, Class.class, String.class));
		assertEquals("void voidDummyMethod(Character,Class,String)", signature);
	}

	@org.junit.Test
	public void fullNameSignatureTest() throws ReflectiveOperationException {
		String signature = MethodWrapper.getMethodSignature(Test.class.getMethod("genericDummyMethod", Thread.class, Exception.class), true);
		assertEquals("java.lang.reflect.Method genericDummyMethod(java.lang.Thread,java.lang.Exception)", signature);
	}

}
