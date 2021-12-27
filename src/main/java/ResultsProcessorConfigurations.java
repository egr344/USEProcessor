import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@Configuration
@Import(PropertiesConfiguration.class)
public class ResultsProcessorConfigurations {

    @Value("#{'${score}'.split(',')}")
    private List<Integer> scores;

    @Bean
    public ResultsProcessor resultsProcessor() {
        return new ResultsProcessorImpl(scores);
    }

}
