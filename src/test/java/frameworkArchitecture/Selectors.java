package frameworkArchitecture;

public class Selectors {
    //Login page err
    public static final String LOGIN_ERR = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > small";
    //Register page err
    public static final String LONGER_USERNAME = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > small.form-error";
    public static final String PASSWORDS = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(4) > small.form-error";
    //
    public static final String WELCOME_MSG = "#svelte > div.container-fluid > div.main.row > div.content > h1";
}
