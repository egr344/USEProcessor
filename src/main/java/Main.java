import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ResultsProcessorConfigurations.class);
        int res = context.getBean(ResultsProcessor.class).getResultsForExam(new File("C:\\Users\\Ольга\\IdeaProjects\\USEProcessor\\src\\main\\java\\Test\\testKey.txt"),new File("C:\\Users\\Ольга\\IdeaProjects\\USEProcessor\\src\\main\\java\\Test\\testAnswer.txt"));
        System.out.println(res);
    }
}
