package pl.edu.pw.ee.aisd2024zex4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.aisd2024zex4.service.MapInterface;

public class RbtMapTest {

    private MapInterface<Integer, String> students;

    @BeforeEach
    public void setup() {
        students = new RbtMap<>();
    }

    @Test
    public void ThrowException_PuttingNullKey() {
        // given
        Integer studentId = null;
        String studentFullName = "Miś Uszatek";

        // when
        Throwable thrown = catchThrowable(() -> students.setValue(studentId, studentFullName));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Params (key, value) cannot be null.");
    }

    @Test
    public void ThrowException_PuttingNullValue() {
        // given
        Integer studentId = 1;
        String studentFullName = null;

        // when
        Throwable thrown = catchThrowable(() -> students.setValue(studentId, studentFullName));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Params (key, value) cannot be null.");
    }

    @Test
    public void AddAndRetrieveValue_ForValidKey() {
        // given
        Integer studentId = 1;
        String studentFullName = "Jan Kowalski";

        // when
        students.setValue(studentId, studentFullName);
        String result = students.getValue(studentId);

        // then
        assertThat(result).isEqualTo(studentFullName);
    }

    @Test
    public void Exception_GettingNullKey() {
        // given
        Integer nullKey = null;

        // when
        Throwable thrown = catchThrowable(() -> students.getValue(nullKey));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cannot get value by null key.");
    }

    @Test
    public void ReturnNull_KeyDoesNotExist() {
        // given
        Integer nonExistentKey = 42;

        // when
        String result = students.getValue(nonExistentKey);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void HandleMultipleKeys_AndPreserveOrder() {
        // given
        students.setValue(3, "Alice");
        students.setValue(1, "Bob");
        students.setValue(2, "Charlie");

        // when
        String result1 = students.getValue(1);
        String result2 = students.getValue(2);
        String result3 = students.getValue(3);

        // then
        assertThat(result1).isEqualTo("Bob");
        assertThat(result2).isEqualTo("Charlie");
        assertThat(result3).isEqualTo("Alice");
    }

    @Test
    public void UpdateValue_ForExistingKey() {
        // given
        Integer key = 1;
        students.setValue(key, "Original");

        // when
        students.setValue(key, "Updated");
        String result = students.getValue(key);

        // then
        assertThat(result).isEqualTo("Updated");
    }


    @Test
    public void HandleEmptyTree_WhenDeletingMin() {
        // when
        Throwable thrown = catchThrowable(() -> ((RbtMap<Integer, String>) students).tree.deleteMin());

        // then
        assertThat(thrown).isNull(); // Nie powinno być żadnego wyjątku
    }

    @Test
    public void RemoveMinimumValue_FromTree() {
        // given
        students.setValue(3, "Alice");
        students.setValue(1, "Bob");
        students.setValue(2, "Charlie");

        // when
        ((RbtMap<Integer, String>) students).tree.deleteMin();
        String result = students.getValue(1);

        // then
        assertThat(result).isNull();
        assertThat(students.getValue(2)).isEqualTo("Charlie");
    }
}