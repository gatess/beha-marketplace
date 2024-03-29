import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitAnnotationTest {

    static String websiteUrl = null;
    String user = null;

    //It will run only once
    @BeforeClass
    public static void SetInitialValues(){
        websiteUrl = "www.swtestacedemy.com";
        System.out.println("[fusion_builder_container hundred_percent='yes' overflow='visible'][fusion_builder_row][fusion_builder_column type='1_1' background_position='left top' background_color='' border_size='' border_color='' border_style='solid' spacing='yes' background_image='' background_repeat='no-repeat' padding='' margin_top='0px' margin_bottom='0px' class='' id='' animation_type='' animation_speed='0.3' animation_direction='left' hide_on_mobile='no' center_content='no' min_height='none'][@BeforeClass] Setting Initial Values...\\nWebsite URL is: ' + websiteUrl + '\\n");
    }

    //It runs before every test. Default user is always Onur
    @Before
    public void setUserInfo(){
        user = "Onur";
        System.out.println("[@Before] Before test set user values.\nDefault user is: " + user + "\n");
    }

    //First test outputs "Ezgi"
    @Test
    public void T01_firstTest(){
        user = "Ezgi";
        System.out.println("[@Test] This is first test and user is: " + user + "\n" );
    }

    //Second test outputs "Mike"
    @Test
    public void T02_secondTest(){
        user = "Mike";
        System.out.println("[@Test] This is second test and user is: " + user + "\n");
    }

    //Third test outputs "Onur" because I did not set another name to user value
    @Test
    public void T03_thirdTest(){
        System.out.println("[@Test] This is third test and user is: " + user + "\n" );
    }

    //It runs at the end of each test clasess and set user value to null
    @After
    public void afterTest(){
        user = null;
        System.out.println("[@After] This test is finished...\nUser is: " + user + "\n");
    }

    //It runs only once when all test finished
    @AfterClass
    public static void afterClass(){
        System.out.println("[@AfterClass] All tests are finished!\n");
    }
}
