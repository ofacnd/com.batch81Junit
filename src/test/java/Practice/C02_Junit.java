package Practice;

import org.junit.*;

public class C02_Junit {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Befor Class");
        //  Her Classta ILK ve 1 KERE calisir.
    }

    @AfterClass
    public static void afterClass () {   // Before cLass gibi her class`tan sonra calisir ve 1 kere calisir.
        System.out.println("After Class");
    }

    @Before
    public void before() {   // Her testten once calisir.
        System.out.println("Before");
    }
    @After
    public void after() {
        System.out.println("After");
    }



    @Test
    public void test1() {
        System.out.println("Test 01");
    }
    @Test
    public void test2() {
        System.out.println("Test 02");
    }
    @Test
    public void test3() {
        System.out.println("Test 03");
    }
}
