package com.netsuite.tlh.operations;



public class MethodNameReportingOprations extends BaseOperations {
	static String methodName;
	
	public void setMethodName(String methodName) {
		MethodNameReportingOprations.methodName = methodName;
	}

	public String getMethodName()  {		
		return methodName;	
	}
	
	 
	
}
