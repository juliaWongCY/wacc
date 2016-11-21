package type;

public abstract class Type {

    public Type getType() {
        return this;
    }

    public String getTypeInString() {
        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.getClass().equals(obj.getClass());
    }
}
