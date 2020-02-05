package sitimi.spock

import org.junit.Rule
import org.junit.rules.TestName
import spock.lang.Shared

class SitimiReportingSpec extends SitimiSpec{
    @Rule
    TestName specTestName
    private int perTestCounter = 1
    @Shared
    private int specTestCounter = 1

    def cleanup() {
        report('end')
        ++specTestCounter
    }

    void report(String label = "") {
        getComputer().capture(createReportLabel(label))
    }

    void reportFailure() {
        report('failure')
    }

    String createReportLabel(String label = ""){
        toTestReportLabel(specTestCounter, perTestCounter++, specTestName?.methodName ?: 'fixture', label)
    }

    static String toTestReportLabel(int testCounter, int reportCounter, String methodName, String label) {
        def numberFormat = "%03d"
        "${String.format(numberFormat, testCounter)}-${String.format(numberFormat, reportCounter)}-$methodName-$label"
    }
}
