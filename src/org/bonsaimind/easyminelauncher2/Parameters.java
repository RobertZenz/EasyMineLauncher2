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

import org.bonsaimind.minecraftmiddleknife.post16.Kickstarter;

public class Parameters {
	
	private boolean demo = false;
	private int height = 600;
	private String jar = "";
	private String jarDir = "";
	private String libDir = "";
	private String mainClass = Kickstarter.MAIN_CLASS;
	private String mainMethod = Kickstarter.MAIN_METHOD;
	private String nativeDir = "";
	private String parentDir = "";
	private String port = "25565";
	private boolean printDump = false;
	private boolean printHelp = false;
	private boolean printVersion = false;
	private String server = "";
	private String version = "1.6.2";
	private int width = 800;
	
	public Parameters(String[] arguments) {
		for (String argument : arguments) {
			if (argument.equals("--demo")) {
				demo = true;
			} else if (argument.equals("--dump")) {
				printDump = true;
			} else if (argument.startsWith("--height=")) {
				height = Integer.parseInt(argument.substring(9));
			} else if (argument.equals("--help")) {
				printHelp = true;
			} else if (argument.startsWith("--lib-dir=")) {
				libDir = argument.substring(10);
			} else if (argument.startsWith("--main-class=")) {
				mainClass = argument.substring(13);
			} else if (argument.startsWith("--main-method=")) {
				mainMethod = argument.substring(14);
			} else if (argument.startsWith("--native-dir=")) {
				nativeDir = argument.substring(13);
			} else if (argument.startsWith("--parent-dir=")) {
				parentDir = argument.substring(13);
			} else if (argument.startsWith("--port=")) {
				port = argument.substring(7);
			} else if (argument.startsWith("--server=")) {
				server = argument.substring(9);
			} else if (argument.startsWith("--version=")) {
				version = argument.substring(10);
			} else if (argument.equals("--version")) {
				printVersion = true;
			} else if (argument.startsWith("--width=")) {
				width = Integer.parseInt(argument.substring(8));
			} else {
				printHelp = true;
			}
		}
		
		if (version.isEmpty()) {
			version = "minecraft";
		}
		
		if (parentDir.isEmpty()) {
			parentDir = new File(System.getProperty("user.home"), ".minecraft").getAbsolutePath();
		}
		
		if (libDir.isEmpty()) {
			libDir = new File(parentDir, "libraries").getAbsolutePath();
		}
		
		if (jarDir.isEmpty()) {
			jarDir = new File(parentDir, "bin").getAbsolutePath();
		}
		
		if (jar.isEmpty()) {
			jar = new File(jarDir, version + ".jar").getAbsolutePath();
		}
		
		if (nativeDir.isEmpty()) {
			nativeDir = libDir;
		}
		
		// Sanity checks
		if (height <= 0) {
			height = 600;
		}
		if (width <= 0) {
			width = 800;
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public String getJar() {
		return jar;
	}
	
	public String getJarDir() {
		return jarDir;
	}
	
	public String getLibDir() {
		return libDir;
	}
	
	public String getMainClass() {
		return mainClass;
	}
	
	public String getMainMethod() {
		return mainMethod;
	}
	
	public String getNativeDir() {
		return nativeDir;
	}
	
	public String getParentDir() {
		return parentDir;
	}
	
	public String getPort() {
		return port;
	}
	
	public String getServer() {
		return server;
	}
	
	public String getVersion() {
		return version;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean isDemo() {
		return demo;
	}
	
	public boolean isPrintDump() {
		return printDump;
	}
	
	public boolean isPrintHelp() {
		return printHelp;
	}
	
	public boolean isPrintVersion() {
		return printVersion;
	}
	
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		value.append("jarDir (exists: ").append(new File(jarDir).exists()).append("): ").append(jarDir).append("\n");
		value.append("jar (exists: ").append(new File(jar).exists()).append("): ").append(jar).append("\n");
		// value.append("lwjglDir (exists: ").append(new
		// File(lwjglDir).exists()).append("): ").append(lwjglDir).append("\n");
		// value.append("password: ").append(password).append("\n");
		value.append("nativeDir (exists: ").append(new File(nativeDir).exists()).append("): ").append(nativeDir).append("\n");
		// value.append("additionalJars:").append("\n");
		// for (String additionalJar : additionalJars) {
		// value.append("    ").append(additionalJar).append("\n");
		// }
		// value.append("noFrame: ").append(noFrame).append("\n");
		// value.append("optionsFileFrom (exists: ").append(new
		// File(optionsFileFrom).exists()).append("): ").append(optionsFileFrom).append("\n");
		// value.append("options:").append("\n");
		// for (String option : options) {
		// value.append("    ").append(option).append("\n");
		// }
		value.append("demo: ").append(demo).append("\n");
		value.append("parentDir (exists: ").append(new File(parentDir).exists()).append("): ").append(parentDir).append("\n");
		// value.append("applet: ").append(appletToLoad).append("\n");
		// value.append("blendWith: ").append("\n");
		// for (String file : blendWith) {
		// value.append("	(exists: ").append(new
		// File(file).exists()).append("): ").append(file).append("\n");
		// }
		// value.append("blendJarName: ").append(blendJarName).append("\n");
		// value.append("blendKeepManifest: ").append(blendKeepManifest).append("\n");
		value.append("port: ").append(port).append("\n");
		value.append("server: ").append(server).append("\n");
		// value.append("authenticate: ").append(authenticate).append("\n");
		// value.append("authenticationFailureBehavior: ").append(authenticationFailureBehavior).append("\n");
		// value.append("keepAliveTick: ").append(keepAliveTick).append("\n");
		// value.append("launcherVersion: ").append(launcherVersion).append("\n");
		// value.append("authenticationAddress: ").append(authenticationAddress).append("\n");
		// value.append("username: ").append(username).append("\n");
		// value.append("useLastLogin: ").append(useLastLogin).append("\n");
		// value.append("saveLastLogin: ").append(saveLastLogin).append("\n");
		// value.append("keepUsername: ").append(keepUsername).append("\n");
		// value.append("texturepack: ").append(texturepack).append("\n");
		// value.append("maximized: ").append(maximized).append("\n");
		value.append("width: ").append(width).append("\n");
		value.append("height: ").append(height).append("\n");
		// value.append("x: ").append(x).append("\n");
		// value.append("y: ").append(y).append("\n");
		// value.append("title: ").append(title).append("\n");
		// value.append("alwaysOnTop: ").append(alwaysOnTop).append("\n");
		// value.append("fullscreen: ").append(fullscreen).append("\n");
		// value.append("opacity: ").append(opacity).append("\n");
		return value.toString();
	}
}
