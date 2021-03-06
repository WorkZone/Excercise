package com.one.app;



import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.PassingUponPendingStep;
import org.jbehave.core.failures.RethrowingFailure;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.AbsolutePathCalculator;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.FreemarkerViewGenerator;
import org.jbehave.core.reporters.PrintStreamStepdocReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.StepFinder;
import org.junit.runner.RunWith;

import com.one.steps.FizzBuzzSteps;
import com.thoughtworks.paranamer.NullParanamer;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

import static org.jbehave.core.reporters.Format.CONSOLE;  
import static org.jbehave.core.reporters.Format.TXT;

@RunWith(JUnitReportingRunner.class)
public class FizzBuzzBDDTest extends JUnitStories{

	
	private Configuration configuration;
	
	public FizzBuzzBDDTest() {
		super();
		//this.configuredEmbedder().candidateSteps().add(new FizzBuzzSteps());
		
		
		configuration = new Configuration() {
		};
 
		// configuration.doDryRun(false); "no dry run" is implicit by using
		// default StoryControls
 
		// configuration.useDefaultStoryReporter(new ConsoleOutput());
		// deprecated -- rather use StoryReportBuilder
 
		configuration.useFailureStrategy(new RethrowingFailure());
		configuration.useKeywords(new LocalizedKeywords(Locale.ENGLISH));
		configuration.usePathCalculator(new AbsolutePathCalculator());
		configuration.useParameterControls(new ParameterControls());
		configuration.useParameterConverters(new ParameterConverters());
		configuration.useParanamer(new NullParanamer());
		configuration.usePendingStepStrategy(new PassingUponPendingStep());
		configuration.useStepCollector(new MarkUnmatchedStepsAsPending());
		configuration.useStepdocReporter(new PrintStreamStepdocReporter());
		configuration.useStepFinder(new StepFinder());
		configuration.useStepMonitor(new SilentStepMonitor());
		configuration
				.useStepPatternParser(new RegexPrefixCapturingPatternParser());
		configuration.useStoryControls(new StoryControls());
		configuration.useStoryLoader(new LoadFromClasspath());
		configuration.useStoryParser(new RegexStoryParser(configuration
				.keywords()));
		configuration.useStoryPathResolver(new UnderscoredCamelCaseResolver());
		configuration.useStoryReporterBuilder(new StoryReporterBuilder());
		configuration.useViewGenerator(new FreemarkerViewGenerator());
 
		EmbedderControls embedderControls = configuredEmbedder()
				.embedderControls();
		embedderControls.doBatch(false);
		embedderControls.doGenerateViewAfterStories(true);
		embedderControls.doIgnoreFailureInStories(false);
		embedderControls.doIgnoreFailureInView(false);
		embedderControls.doSkip(false);
		embedderControls.doVerboseFailures(false);
		embedderControls.doVerboseFiltering(false);
		embedderControls.useStoryTimeoutInSecs(300);
		embedderControls.useThreads(1);
		
		
	}
 
	
	@Override
	public Configuration configuration() {
		return configuration;
	}
 
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new FizzBuzzSteps());
	}
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("com/one/features/fizzbuzz.feature.story");
		//return new StoryFinder().findPaths(org.jbehave.core.io.CodeLocations.codeLocationFromPath("com/one/features"),
		//		"**/fizzbuzz.feature.story", "");
	}
	
	//private static Embedder embedder = new Embedder();
	
	//private static List<String> storyPaths = Arrays.asList("com/one/features/fizzbuzz.feature.story");
	
	
	//public static void main(String args[]){
		//embedder.candidateSteps().add(new FizzBuzzSteps());
		//embedder.runStoriesAsPaths(storyPaths);
	//}
/*
	@Override
	protected List<String> storyPaths() {
		// TODO Auto-generated method stub
		return Arrays.asList;
	}*/
/*
	  @Override  
	   public Configuration configuration() { 
		  
		  Configuration c = super.configuration();
		  if(c == null){
			  System.out.println("....null...");
		  }
	     return super.configuration()  
	         .useStoryReporterBuilder(  
	             new StoryReporterBuilder()  
	                 .withDefaultFormats()  
	                 .withFormats(CONSOLE, TXT));  
	   }  

	   // Here we specify the steps classes  
	   @Override  
	   public InjectableStepsFactory stepsFactory() {  
	     return new InstanceStepsFactory(configuration(), new FizzBuzzSteps());  
	   }

	@Override
	protected List<String> storyPaths() {
		// TODO Auto-generated method stub
		return Arrays.asList("com/one/features/fizzbuzz.feature.story");
		//return new StoryFinder().findPaths(org.jbehave.core.io.CodeLocations.codeLocationFromPath("com/one/features"), "** /fizzbuzz.feature.story", "");
		
	}*/ 

}
