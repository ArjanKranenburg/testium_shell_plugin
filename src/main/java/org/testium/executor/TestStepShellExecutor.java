/**
 * 
 */
package org.testium.executor;

import java.io.File;
import java.io.FileNotFoundException;

import org.testtoolinterfaces.testresult.TestStepResult;
import org.testtoolinterfaces.testresult.TestResult.VERDICT;
import org.testtoolinterfaces.testsuite.TestStepScript;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestStepShellExecutor extends TestStepScriptAbstractExecutor
{
	public static final String TYPE = "shell";

	/**
	 * @param myTestStepExecutors
	 */
	public TestStepShellExecutor()
	{
		// nop
	}

	/**
	 * @param aStep
	 * @param aShellScript
	 * @param aResult
	 * @param aLogDir
	 */
	public File executeScript( TestStepScript aStep,
	                           File aShellScript,
	                           TestStepResult aResult,
	                           File aLogDir )
	{
    	File runLog = new File( aLogDir, aShellScript.getName() + "_run.log" );
		try
		{
			aResult.setResult( ShellScript.execute(aShellScript, aStep.getParameters(), runLog) );
		}
		catch (FileNotFoundException e)
		{
			aResult.addComment( "Execution Failed: " + e.getMessage() );
			aResult.setResult( VERDICT.ERROR );
		}
		
		return runLog;
	}

	public String getType()
	{
		return TYPE;
	}
}
