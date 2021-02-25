package eci.arsw.covidanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A Camel Application
 */
public class CovidAnalyzerTool {


    public static ResultAnalyzer resultAnalyzer;
    public static TestReader testReader;
    private int amountOfFilesTotal;
    public static  AtomicInteger amountOfFilesProcessed;
    private int cantidadThreads = 5;
    public static boolean pausar = false;
    private static ArrayList<CovidAnalizerThread> threads;
    
    public static Object monitor= new Object();
    
    

    public CovidAnalyzerTool() {
        resultAnalyzer = new ResultAnalyzer();
        testReader = new TestReader();
        amountOfFilesProcessed = new AtomicInteger();
    }

    public void processResultData() {
        amountOfFilesProcessed.set(0);
        List<File> resultFiles = getResultFileList();
        amountOfFilesTotal = resultFiles.size();
        
        int start = 0;
        int stop = cantidadThreads;
        int cant = amountOfFilesTotal/cantidadThreads;
        
        threads = new ArrayList<CovidAnalizerThread>();
        
        for(int i = 0; i < cantidadThreads; i++) {
        	if(i+1 == cantidadThreads && stop < amountOfFilesTotal) {
        		stop=amountOfFilesTotal;
        	}
        	
        	System.out.println(start+ "de" +stop);
        	CovidAnalizerThread thread = new CovidAnalizerThread(resultFiles.subList(start,stop));
            start=stop;
            stop= stop + cant;
            thread.start();
            threads.add(thread);
        	
        }
        
        for (File resultFile : resultFiles) {
            List<Result> results = testReader.readResultsFromFile(resultFile);
            for (Result result : results) {
                resultAnalyzer.addResult(result);
            }
            amountOfFilesProcessed.incrementAndGet();
        }
    }

    private List<File> getResultFileList() {
        List<File> csvFiles = new ArrayList<>();
        try (Stream<Path> csvFilePaths = Files.walk(Paths.get("src/main/resources/")).filter(path -> path.getFileName().toString().endsWith(".csv"))) {
            csvFiles = csvFilePaths.map(Path::toFile).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvFiles;
    }


    public Set<Result> getPositivePeople() {
        return resultAnalyzer.listOfPositivePeople();
    }

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
    	
        CovidAnalyzerTool covidAnalyzerTool = new CovidAnalyzerTool();
        covidAnalyzerTool.processResultData();
        
        //Thread processingThread = new Thread(() -> covidAnalyzerTool.processResultData());
        //processingThread.start();
        
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.contains("exit")) {
            	System.exit(0);
            	
            	if(pausar=false) {
            		pausar=true;
            	}if(pausar=true) {
            		pausar=false;
            	}
            	
            	for(CovidAnalizerThread h : threads) {
            		
            		h.continuar();
            		
            	}
            	
                String message = "Processed %d out of %d files.\nFound %d positive people:\n%s";
                Set<Result> positivePeople = covidAnalyzerTool.getPositivePeople();
                String affectedPeople = positivePeople.stream().map(Result::toString).reduce("", (s1, s2) -> s1 + "\n" + s2);
                message = String.format(message, covidAnalyzerTool.amountOfFilesProcessed.get(), covidAnalyzerTool.amountOfFilesTotal, positivePeople.size(), affectedPeople);
                System.out.println(message);
            	
            }
               
        }
    }
    
    
    private static boolean pause(){
        return pausar;
    }

}

