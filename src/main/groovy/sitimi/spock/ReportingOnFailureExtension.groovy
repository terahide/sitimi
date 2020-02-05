package sitimi.spock

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class ReportingOnFailureExtension implements IGlobalExtension {

    @Override
    void start() {
    }

    @Override
    void stop() {
    }

    void visitSpec(SpecInfo spec) {
        if (SitimiReportingSpec.isAssignableFrom(spec.reflection)) {
            def reporter = new OnFailureReporter()
            spec.addListener(reporter)
            spec.allFeatures*.addIterationInterceptor(reporter)
        }
    }
}