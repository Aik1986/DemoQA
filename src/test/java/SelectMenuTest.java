import com.demoqa.pages.DemoQAPages;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

import java.util.List;

import static com.demoqa.enums.Endpoints.SELECTMENU;

public class SelectMenuTest extends BaseTest{

    @Test
    public void testSelectMenu(){
       browserHelper.open(ConfigReader.getValue("baseURL")+SELECTMENU.getEndpoint());

        List<String> multiSelectDropDownOptions = demoQAPages.getSelectMenuPage().getMultiSelectDropDownOptions();
        List<String> selectOneOptions = demoQAPages.getSelectMenuPage().getSelectOneOptions();
        List<String> selectValueOptions = demoQAPages.getSelectMenuPage().getSelectValueOptions();
        List<String> standardMultiSelect = demoQAPages.getSelectMenuPage().getStandardMultiSelectDropDownOptions();


        System.out.println("Select One Options: " + selectOneOptions);
        System.out.println("Select Value Options: " + selectValueOptions);
        System.out.println("MultiSelect Drop Down Options: " + multiSelectDropDownOptions);
        System.out.println("Standard MultiSelect Drop Down Options: " + standardMultiSelect);
    }

}



