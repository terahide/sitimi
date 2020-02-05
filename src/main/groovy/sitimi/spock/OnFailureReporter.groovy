package sitimi.spock

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.ErrorInfo

import static org.spockframework.runtime.model.MethodKind.FEATURE

class OnFailureReporter extends AbstractRunListener implements IMethodInterceptor {

    private SitimiReportingSpec spec

    void intercept(IMethodInvocation invocation) throws Throwable {
        spec = invocation.instance
        invocation.proceed()
    }

    void error(ErrorInfo error) {
        if (error.method.kind == FEATURE) {
            try {
                spec.reportFailure()
            } catch (Exception e) {
                //ignore
            }
        }
    }
}