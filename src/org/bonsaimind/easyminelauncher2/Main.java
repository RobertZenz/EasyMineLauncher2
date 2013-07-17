/*
 * Copyright 2012 Robert 'Bobby' Zenz. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list
 * of conditions and the following disclaimer in the documentation and/or other materials
 * provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY Robert 'Bobby' Zenz ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL Robert 'Bobby' Zenz OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of Robert 'Bobby' Zenz.
 */
package org.bonsaimind.easyminelauncher2;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String parentDir = System.getProperty("user.home");
		// Woah...wtf dude?!
		String libDir = new File(parentDir, "lib").getAbsolutePath();
		String nativeDir = new File(parentDir, "bin/natives").getAbsolutePath();
		String version = "1.6.2";
		String mainClass = "net.minecraft.client.main.Main";
		String mainMethod = "main";
		String server = "";
		String port = "";
		boolean demo = false;
		String width = "";
		String height = "";
		boolean fullscreen = false;

		List<String> minecraftArgs = new ArrayList<String>();
		
		// Loading native libraries.
		System.setProperty("org.lwjgl.librarypath", nativeDir);
		System.setProperty("net.java.games.input.librarypath", nativeDir);
		
		try {
			List<URL> urls = new ArrayList<URL>();
			urls.add(new File(parentDir, ".minecraft/versions/1.6.2/1.6.2.jar").toURI().toURL());

			// Get all jars from the lib dir.
			for (File file : new File(libDir).listFiles()) {
				urls.add(file.toURI().toURL());
			}

			URLClassLoader loader = new URLClassLoader(urls.toArray(new URL[urls.size()-1]));
			Class minecraftMainClass = loader.loadClass(mainClass);
			Method minecraftMainMethod = minecraftMainClass.getMethod(mainMethod, String[].class);
			minecraftMainMethod.invoke(null, minecraftArgs);
		} catch (MalformedURLException ex) {
			System.err.println(ex);
		} catch (ClassNotFoundException ex) {
			System.err.println(ex);
		} catch (NoSuchMethodException ex) {
			System.err.println(ex);
		} catch (SecurityException ex) {
			System.err.println(ex);
		} catch (IllegalAccessException ex) {
			System.err.println(ex);
		} catch (InvocationTargetException ex) {
			System.err.println(ex);
		}
	}
}
