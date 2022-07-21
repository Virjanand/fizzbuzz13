package fizzbuzz;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzMainIT {

    @Test
    void logFizzBuzzNumbers() {

        Logger logger = (Logger) LoggerFactory.getLogger(FizzBuzzMain.class);

        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        logger.addAppender(listAppender);

        FizzBuzzMain.main(new String[]{});

        assertThat(listAppender.list)
                .extracting(ILoggingEvent::getMessage, ILoggingEvent::getLevel)
                .containsExactly(Tuple.tuple("1\r\n2\r\nFizz\r\n4\r\nBuzz", Level.INFO));
    }
}
