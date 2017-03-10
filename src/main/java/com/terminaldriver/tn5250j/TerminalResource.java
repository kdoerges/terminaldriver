package com.terminaldriver.tn5250j;

import java.io.IOException;

import org.junit.rules.ExternalResource;

/**
 * Stellt eine Terminal-Instanz als Resource fuer JUnit Tests zur Verfuegung. Die Konfiguration fuer den Connect
 * erfolgt ueber ein Fluent-Interface.
 * 
 * @author doerges
 *
 */
public class TerminalResource extends ExternalResource {

	/**
	 * Terminal
	 */
	public TerminalDriver driver;
	
	/**
	 * Host fuer den Connect
	 */
	String host;
	
	/**
	 * Port fuer den Connect
	 */
	int port;
	
	/**
	 * Gibt an ob das Terminal nach dem Test geschlossen werden soll.
	 * Standard ist "false"
	 */
	boolean reusableConnection = false;
	
	/**
	 * Standard Konstruktor
	 */
	public TerminalResource() {
		host = "";
		port = 0;
	}
	
	/**
	 * FluentInterface: Definition des Hosts.
	 * 
	 * @param aHost
	 * @return
	 */
	public TerminalResource withHost(String aHost) {
		this.host = aHost;
		return this;
	}
	
	/**
	 * FluentInterface: Definition des Ports.
	 * @param aPort
	 * @return
	 */
	public TerminalResource withPort(int aPort) {
		this.port = aPort;
		return this;
	}
	
	/**
	 * FluentInterface: Soll die Connection nach dem Test gehalten werden? 
	 * @param aDecision
	 * @return
	 */
	public TerminalResource withReusableConnection(boolean aDecision) {
		this.reusableConnection = aDecision;
		return this;
	}
	
	/**
	 * Vor dem Testfall wird die Resource initialisiert
	 */
	@Override
	protected void before() throws Throwable {
		if (reusableConnection) {
			return;
		}
		driver =  new TerminalDriver();
		driver.connectTo(host, port);
	}
	
	/**
	 * Nach dem Testfall wird das Terminal automatisch geschlossen
	 */
	@Override
	protected void after() {
		if (reusableConnection) {
			return;
		}
		try {
			driver.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TerminalDriver getDriver() {
		return driver;
	}
}
