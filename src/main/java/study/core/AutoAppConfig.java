package study.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;

/*
    실습하면서 만들어 놓은 것을 제외하기 위해서
    @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)을 써 주었다.
 */
@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
