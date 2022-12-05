package com.googleclassroom.listeners;

import com.tesults.tesults.Results;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestResultsListener implements ITestListener {

	List<Map<String, Object>> testCases = new ArrayList<>();

	public static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	public static Object[] getTestParams(ITestResult iTestResult) {
		return iTestResult.getParameters();
	}
   @Override
	public void onTestStart(ITestResult result) {
		System.out.println("I am in onTestStart method " + getTestMethodName(result) + " start");

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "Jira API Test Suite");
		testCase.put("result", "pass");
		testCase.put("params", getTestParams(iTestResult));
		testCases.add(testCase);
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "TestResultsExample");
		testCase.put("result", "fail");
		testCase.put("params", getTestParams(iTestResult));
		testCases.add(testCase);
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "Jira API Test Suite");
		testCase.put("result", "fail");
		testCase.put("params", getTestParams(iTestResult));
		testCases.add(testCase);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		// Map<String, Object> to hold your test results data.
		Map<String, Object> data = new HashMap<>();
		data.put("target","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImEzYTQ1MTQ5LWM2ZTUtNGE4NS04NjJmLWQ4NzU1ZDQwNzgwOC0xNTg2ODczODU3Mjg1IiwiZXhwIjo0MTAyNDQ0ODAwMDAwLCJ2ZXIiOiIwIiwic2VzIjoiZjQ4ZmM4MWQtZjliYS00NWVhLWJlMGEtN2M2NjRlZGNkNjE5IiwidHlwZSI6InQifQ.Erg30WtYvEaXlEXdH9emZnAl93wwFCsLarEE-2nZxgg");

		Map<String, Object> results = new HashMap<>();
		results.put("cases", testCases);
		data.put("results", results);

		// Upload
		Map<String, Object> response = Results.upload(data);
		System.out.println("success: " + response.get("success"));
		System.out.println("message: " + response.get("message"));
		System.out.println("warnings: " + ((List<String>) response.get("warnings")).size());
		System.out.println("errors: " + ((List<String>) response.get("errors")).size());
	}

}

