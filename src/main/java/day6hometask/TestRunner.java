package day6hometask;

import day6hometask.tests.ExecutionTests;
import day6hometask.tests.WorkerAtomTest;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ExecutionTests.class, WorkerAtomTest.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRunner {
}
