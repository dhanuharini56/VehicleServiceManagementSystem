# TEST CASES

## Vehicle Service Management and Maintenance Analysis System

The following test cases are used to verify the major functionalities of the application.

| ID | Test Scenario | Expected Result | Actual Result | Status |
|---|---|---|---|---|
| TC01 | Add valid customer | Customer details should be saved in MySQL | Customer details saved successfully | Pass |
| TC02 | Add vehicle for valid customer ID | Vehicle should be linked to the customer | Vehicle registered successfully | Pass |
| TC03 | Add vehicle with unknown customer ID | Invalid customer reference should be rejected | Not tested yet | Not Tested |
| TC04 | Book appointment with valid IDs | Appointment should be saved | Appointment booked successfully | Pass |
| TC05 | Add service record | Total labour and parts cost should be saved | Service record saved with total cost of 1500 | Pass |
| TC06 | Generate bill for valid service ID | Bill should be saved | Bill generated successfully with amount 1500 | Pass |
| TC07 | Refresh dashboard | Counts should match database records | Dashboard displayed the correct available record counts | Pass |
| TC08 | Run Python analysis | Summary and charts should be created | Maintenance analysis charts generated successfully | Pass |

## Testing Summary

- Total Test Cases: 8
- Passed: 7
- Failed: 0
- Not Tested: 1

## Conclusion

The major functionalities of the Vehicle Service Management and Maintenance Analysis System were tested successfully. Customer management, vehicle registration, appointment booking, service records, billing, dashboard operations, and Python-based maintenance analysis worked as expected.

The invalid customer reference test case remains to be tested.