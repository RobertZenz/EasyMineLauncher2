/*
 * Copyright 2014 Robert 'Bobby' Zenz. All rights reserved.
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
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bonsaimind.minecraftmiddleknife.ClassLoaderCreator;
import org.bonsaimind.minecraftmiddleknife.NativeLoader;
import org.bonsaimind.minecraftmiddleknife.post16.Kickstarter;
import org.bonsaimind.minecraftmiddleknife.post16.RunException;

public class Main {
	
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		Parameters parameters = new Parameters(args);
		
		NativeLoader.loadNativeLibraries(parameters.getNativeDir());
		
		String[] minecraftArgs = new String[] { "--version=4" };
		
		try {
			ClassLoaderCreator classLoaderCreator = new ClassLoaderCreator();
			classLoaderCreator.add(new File(parameters.getParentDir(), ".minecraft/versions/1.6.2/1.6.2.jar"));
			classLoaderCreator.addRecursively(parameters.getLibDir());
			
			Kickstarter.run(classLoaderCreator.createClassLoader(), parameters.getMainClass(), parameters.getMainMethod(), minecraftArgs);
		} catch (MalformedURLException ex) {
			LOGGER.log(Level.SEVERE, "Failed to load needed jars.", ex);
		} catch (RunException ex) {
			LOGGER.log(Level.SEVERE, "Failed to start Minecraft.", ex);
		}
	}
}
