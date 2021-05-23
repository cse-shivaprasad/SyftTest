package com.syft.driver;

import com.syft.controller.FlowController;

public class Driver {
	
	public static void main(String[] args) {
		
		try {
			new FlowController().invokeFlow(args);;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
