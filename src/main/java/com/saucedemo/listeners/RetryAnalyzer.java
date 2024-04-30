package com.saucedemo.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.saucedemo.TestBase.TestBase;

public class RetryAnalyzer extends TestBase implements IRetryAnalyzer, ITestNGListener  {
	
	
	int count=0;
	int maxCount=2;
	

	@Override
	public boolean retry(ITestResult result) {
		if (count < maxCount) {
			logger.info("Test failed, Retrying for " + count + " ,Test Name : " + result.getMethod().getMethodName());
			count++;
			return true;
			}
		
		return false;
	}
	
	

}
