package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LeaveEntitlementPage;

public class LeaveEntitlementTest extends BaseTest {

    private LeaveEntitlementPage openPage() {
        LeaveEntitlementPage page = new LeaveEntitlementPage(driver);
        // Direct route avoids a brittle menu-dropdown click and opens the exact target screen.
        page.openDirectly(BASE_URL);
        return page;
    }

    @Test
    public void TC01_verifyEmployeeEntitlementsPageOpens() {
        LeaveEntitlementPage page = openPage();
        Assert.assertTrue(page.isHeadingVisible(),
                "Leave Entitlements heading should be visible.");
    }

    @Test
    public void TC02_verifyAllSearchFiltersAreDisplayed() {
        LeaveEntitlementPage page = openPage();
        Assert.assertTrue(page.areAllFiltersVisible(),
                "Employee Name, Leave Type and Leave Period should be displayed.");
    }

    @Test
    public void TC03_verifyEmployeeNameIsMandatory() {
        LeaveEntitlementPage page = openPage();
        page.clickSearch();
        Assert.assertTrue(page.isRequiredValidationVisible(),
                "The application should show required-field validation for Employee Name.");
    }

    @Test
    public void TC04_verifyEmployeeAutocompleteSuggestions() {
        LeaveEntitlementPage page = openPage();
        page.typeEmployeePrefix("a");
        Assert.assertTrue(page.employeeSuggestionCount() > 0,
                "Typing an employee-name prefix should show autocomplete suggestions.");
    }

    @Test
    public void TC05_verifyLeaveTypeDropdownOptions() {
        LeaveEntitlementPage page = openPage();
        page.openLeaveTypeDropdown();
        Assert.assertTrue(page.leaveTypeOptionCount() > 0,
                "Leave Type dropdown should display at least one option.");
    }
}
