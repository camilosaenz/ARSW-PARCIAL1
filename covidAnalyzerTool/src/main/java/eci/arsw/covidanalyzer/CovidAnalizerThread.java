package eci.arsw.covidanalyzer;

import java.io.File;
import java.util.List;

public class CovidAnalizerThread extends Thread{
	
	private TestReader testReader;
	private List<File> resultFiles;
	
	public CovidAnalizerThread(List<File> subList) {
		
		resultFiles=subList;
		testReader = new TestReader();
		
	}
	
	public void run() {
		
		for(File resultFile :resultFiles ) {
			
			List<Result> results = testReader.readResultsFromFile(resultFile);
			
			for(Result result : results) {
				synchronized(CovidAnalyzerTool.monitor) {
					
					if(CovidAnalyzerTool.pausar) {
						try {
							CovidAnalyzerTool.monitor.wait();
						}catch (InterruptedException e){
		                      e.printStackTrace();
		                }
					}
					
				}
				
				CovidAnalyzerTool.resultAnalyzer.addResult(result);
				
			}
			
			
			CovidAnalyzerTool.amountOfFilesProcessed.incrementAndGet();
		}
		
	}
	
	
	public synchronized void continuar() {
		CovidAnalyzerTool.monitor.notifyAll();
	}

}
