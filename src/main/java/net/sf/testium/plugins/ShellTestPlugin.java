package net.sf.testium.plugins;

import net.sf.testium.configuration.ConfigurationException;
import net.sf.testium.executor.TestCaseShellExecutor;
import net.sf.testium.executor.TestStepShellExecutor;
import org.testtoolinterfaces.testresultinterface.TestCaseResultWriter;
import org.testtoolinterfaces.utils.RunTimeData;

/**
 * @author Arjan Kranenburg
 *
 */
public final class ShellTestPlugin implements Plugin
{
	public ShellTestPlugin()
	{
		// nop
	}
	
	public void loadPlugIn( PluginCollection aPluginCollection,
	                        RunTimeData aRtData) throws ConfigurationException
	{
		// Executors
		TestStepShellExecutor tsShellExecutor = new TestStepShellExecutor( );
		aPluginCollection.addStepScriptExecutor(tsShellExecutor);

		TestCaseResultWriter tcResultWriter = aPluginCollection.getTestCaseResultWriter();
		
		TestCaseShellExecutor tcShellExecutor = new TestCaseShellExecutor( tcResultWriter );
		aPluginCollection.addTestCaseExecutor(tcShellExecutor);
	}
}
