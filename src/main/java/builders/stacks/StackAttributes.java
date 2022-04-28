package builders.stacks;

public class StackAttributes {

    private final StackAttribute[] a;

    public StackAttributes(StackAttribute... attributes){
        a = attributes;
    }

    public StackAttribute[] getAttributes() {
        return a;
    }
}
