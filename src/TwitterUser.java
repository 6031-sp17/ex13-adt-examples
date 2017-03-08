/**
 * TwitterUser is an immutable datatype representing a Twitter user account.
 */
public class TwitterUser {

    private final String username;

    // Rep invariant:
    //   username.length > 0
    //   username consists only of letters (A-Z or a-z), digits, and underscores ("_")
    // Abstraction function: 
    //   AF(username) = a case-insensitive username of a Twitter user 
    //                  (so "rbmllr" and "RbMllr" represent the same abstract username)
    // Safety from rep exposure:
    //   All fields are private and immutable.
    
    // TODO: checkRep()
    
    /**
     * TODO: specification
     */
    public TwitterUser(String username) {
        this.username = username;
    }
    
    @Override
    public String toString() {
        return username;
    }
    
    // TODO: this immutable type needs equals() and hashCode()
}
