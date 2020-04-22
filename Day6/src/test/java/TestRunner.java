
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import tests.ExecutionTests;
import tests.WorkerAtomTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ExecutionTests.class, WorkerAtomTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRunner {
}
