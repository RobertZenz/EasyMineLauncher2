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
	private boolean fullscreen = false;
	private String height = "";
	private String libDir = null;
	private String mainClass = Kickstarter.MAIN_CLASS;
	private String mainMethod = Kickstarter.MAIN_METHOD;
	private String nativeDir = null;
	private String parentDir = null;
	private String port = "";
	private String server = "";
	private String version = "1.6.2";
	private String width = "";
	
	public Parameters(String[] arguments) {
		parentDir = System.getProperty("user.home");
		libDir = new File(parentDir, ".minecraft/libraries").getAbsolutePath();
		nativeDir = new File(parentDir, ".minecraft/testnatives").getAbsolutePath();
	}
	
	public boolean isDemo() {
		return demo;
	}
	
	public boolean isFullscreen() {
		return fullscreen;
	}
	
	public String getHeight() {
		return height;
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
	
	public String getWidth() {
		return width;
	}
}
