package my_little_monsters.error;

public class NoDataFoundError extends RuntimeException {
    public NoDataFoundError(String message) {
        super(message);
    }

    public static NoDataFoundError withId(String itemType, int id) {
        return new NoDataFoundError(
                itemType +" with id" + id + " not found");
    }
}
