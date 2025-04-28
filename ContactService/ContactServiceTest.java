package ContactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setup() {
        service = new ContactService();
        contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
    }

    @Test
    public void testAddContactSuccess() {
        Contact newContact = new Contact("456", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(newContact);
        assertEquals("Jane", service.getContact("456").getFirstName());
    }

    @Test
    public void testDeleteContact() {
        service.deleteContact("123");
        assertNull(service.getContact("123"));
    }

    @Test
    public void testUpdateFirstName() {
        service.updateFirstName("123", "Jane");
        assertEquals("Jane", service.getContact("123").getFirstName());
    }

    @Test
    public void testUpdateAllFields() {
        service.updateLastName("123", "Smith");
        service.updatePhone("123", "9999999999");
        service.updateAddress("123", "789 Oak Ave");
        Contact updated = service.getContact("123");
        assertEquals("Smith", updated.getLastName());
        assertEquals("9999999999", updated.getPhone());
        assertEquals("789 Oak Ave", updated.getAddress());
    }
}
