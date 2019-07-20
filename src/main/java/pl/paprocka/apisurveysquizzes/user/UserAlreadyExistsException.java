package pl.paprocka.apisurveysquizzes.user;

public class UserAlreadyExistsException extends Throwable {

    public UserAlreadyExistsException(String message) {
        super (message);
    }
}