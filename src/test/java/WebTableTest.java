
import com.demoqa.entities.Employee;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

import java.util.List;

import static com.demoqa.enums.Endpoints.WEBTABLES;


public class WebTableTest extends BaseTest {
    @Test(description = "")
    public void test123() throws InterruptedException {
       browserHelper.open(ConfigReader.getValue("baseURL")+WEBTABLES.getEndpoint());
        demoQAPages.getWebTablePages().addNewEmployee(randomUtils.createMockEmployee());
        List<Employee> employees = demoQAPages.getWebTablePages().getEmployeesFormTable();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    @Test(description = "verify updates")
    public void editValuesTest() {
        browserHelper.open(ConfigReader.getValue("baseURL")+WEBTABLES.getEndpoint());
        demoQAPages.getWebTablePages().editEmployeeData("cierra@example.com", "age", "34");
        List<Employee> employees = demoQAPages.getWebTablePages().getEmployeesFormTable();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test(description = "delete employee by email ")
    public void deleteEmployeeByEmail() {
        browserHelper.open(ConfigReader.getValue("baseURL")+WEBTABLES.getEndpoint());
        //driver.get("https://demoqa.com/webtables");
        demoQAPages.getWebTablePages().deleteEmployeeByEmail("cierra@example.com");
    }
}