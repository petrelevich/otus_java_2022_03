package functional;

public class TestObjectMutable {
    public int value = 0;

    public TestObjectMutable( int value ) {
        this.value = value;
    }

    public TestObjectMutable updateValue( int value ) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "TestObjectMutable{" +
                "value=" + value +
                '}';
    }
}
