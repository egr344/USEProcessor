import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class TestUSEProcessor {

    private ApplicationContext context = new AnnotationConfigApplicationContext(ResultsProcessorConfigurations.class);

    @Test
    public void testGetResultsForExam() {
        File key = new File("src/main/java/Test/testKey.txt");
        File answer = new File("src/main/java/Test/testAnswer.txt");
        int result = context.getBean(ResultsProcessor.class).getResultsForExam(key, answer);
        Assertions.assertEquals(result, 9);
    }
}
