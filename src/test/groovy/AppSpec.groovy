import spock.lang.*

class AppSpec extends Specification {
    def "let's try this!"() {
        expect:
            Math.max(1, 2) == 2
    }
}