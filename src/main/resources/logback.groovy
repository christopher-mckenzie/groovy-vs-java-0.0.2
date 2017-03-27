import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender

def appenders = ['CONSOLE', 'FILE']
def logback_pattern = "%d{HH:mm:ss.SSS - MM/dd/yyyy} [%thread] %-5level %logger{36} - %msg%n"
def APP_LOG = System.getProperty('APP_LOG')

appender(appenders.get(0), ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = logback_pattern
    }
}

appender(appenders.get(1), FileAppender) {
    file = "$APP_LOG/groovy-vs-java/groovy-vs-java-0.0.2.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = logback_pattern
    }
}

root(INFO, appenders)