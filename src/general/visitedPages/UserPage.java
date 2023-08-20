package general.visitedPages;

public class UserPage {

    private int user;
    private char page;

    public UserPage(int user, char page) {
        this.user = user;
        this.page = page;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public char getPage() {
        return page;
    }

    public void setPage(char page) {
        this.page = page;
    }

}
