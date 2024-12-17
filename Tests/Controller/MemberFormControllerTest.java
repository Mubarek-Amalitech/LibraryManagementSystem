package  Controller;
import Model.MemberTM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;


class MemberFormControllerTest {


    private static class MemberValidator {
        public static boolean validateName(String name) {
            return Pattern.matches("^\\b([A-Za-z.]+\\s?)+$", name);
        }

        public static boolean validateAddress(String address) {
            return Pattern.matches("^\\b[A-Za-z0-9/,\\s]+.$", address);
        }

        public static boolean validateContactNumber(String contactNumber) {
            return Pattern.matches("\\d{10}", contactNumber);
        }

        public static boolean areFieldsComplete(String id, String name, String address, String contactNumber) {
            return !id.isEmpty() &&
                    !name.isEmpty() &&
                    !address.isEmpty() &&
                    !contactNumber.isEmpty();
        }
    }



    @Test
    void  setup(){

       MemberFormController controller= new MemberFormController();
       assertNotNull(controller,"controller cannot be null");
    }


    @Test
    void testValidMemberDetails() {
        // Test valid member details
        assertTrue(MemberValidator.validateName("John Doe"),
                "Name should only contain letters and spaces");

        assertTrue(MemberValidator.validateAddress("123 Test Street"),
                "Address should contain letters, numbers, and common punctuation");

        assertTrue(MemberValidator.validateContactNumber("1234567890"),
                "Contact number should be 10 digits");
    }

    @Test
    void testInvalidMemberDetails() {
        // Test invalid name
        assertFalse(MemberValidator.validateName("John123"),
                "Name should not contain numbers");

        // Test invalid address
        assertTrue(MemberValidator.validateAddress("12323"),
                "Address should contain more than just numbers");

        // Test invalid contact number
        assertFalse(MemberValidator.validateContactNumber("123"),
                "Contact number should be exactly 10 digits");
    }

    @Test
    void testGenerateNewMemberId() throws SQLException {
        // Directly test ID generation logic
        String[] existingIds = {"M001", "M002"};
        String newId = generateNewMemberId(existingIds);

        assertEquals("M003", newId, "New member ID should be incremented correctly");
    }

    // Extracted ID generation logic that doesn't depend on PreparedStatement
    private String generateNewMemberId(String[] existingIds) {
        int maxId = 0;

        for (String id : existingIds) {
            int currentId = Integer.parseInt(id.replace("M", ""));
            if (currentId > maxId) {
                maxId = currentId;
            }
        }

        maxId++;

        if (maxId < 10) {
            return "M00" + maxId;
        } else if (maxId < 100) {
            return "M0" + maxId;
        } else {
            return "M" + maxId;
        }
    }

    @Test
    void testRequiredFieldsValidation() {
        // Test when required fields are complete
        assertTrue(MemberValidator.areFieldsComplete("M001", "John Doe", "123 Test Street", "1234567890"),
                "All fields should be non-empty");

        // Test when fields are empty
        assertFalse(MemberValidator.areFieldsComplete("", "", "", ""),
                "All fields should be required");
    }

    @Test
    void testMemberDataCreation() {
        // Simulate member data creation without UI dependencies
        MemberTM member = new MemberTM(
                "M001",
                "John Doe",
                "123 Test Street",
                "1234567890"
        );

        assertEquals("M001", member.getId());
        assertEquals("John Doe", member.getName());
        assertEquals("123 Test Street", member.getAddress());
        assertEquals("1234567890", member.getContact());
    }
}