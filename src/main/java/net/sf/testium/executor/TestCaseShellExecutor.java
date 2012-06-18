/**
 * 
 */
package net.sf.testium.executor;

import java.io.File;
import java.io.FileNotFoundException;


import org.testtoolinterfaces.testresult.TestCaseResult;
import org.testtoolinterfaces.testresult.TestResult.VERDICT;
import org.testtoolinterfaces.testresultinterface.TestCaseResultWriter;
import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestCaseShellExecutor extends TestCaseAbstractExecutor
{
	public static final String TYPE = "shell";

	/**
	 */
	public TestCaseShellExecutor( TestCaseResultWriter aTestCaseResultWriter )
	{
		super( aTestCaseResultWriter, LOGTYPE.LOGONLY );
		Trace.println(Trace.CONSTRUCTOR);
	}

	/**
	 * @param anExecutable
	 * @param aLogFile
	 * @param aResult
	 */
	public void executeScript( File anExecutable,
	                           File aLogFile,
	                           TestCaseResult aResult )
	{
		Trace.println( Trace.EXEC_PLUS, "executeScript( "
		               + anExecutable.getAbsolutePath() + ", "
		               + aLogFile.getAbsolutePath() + ", "
		               + "<TestCaseResult> )", true );
//		File logDir = aLogFile.getParentFile();
//		File logFile = new File( logDir, aResult.getId() + "_shell.log" );
		try
		{
       		aResult.setResult( ShellScript.execute(anExecutable, aLogFile) );
		}
		catch (FileNotFoundException e)
		{
			aResult.addComment( "Execution Failed: " + e.getMessage() );
			aResult.setResult( VERDICT.ERROR );
		}
	}

	@Override
	public String getType()
	{
		return TYPE;
	}
}
