package pl.coderslab.collection;

public class Main3 {

    public static void main(String[] args) {
        System.out.println("asd123asdasd - " + verifyLogin("asd123asdasd"));
        System.out.println("123123.213412341234 - " + verifyLogin("123123.213412341234"));
        System.out.println("2asdffaadasfsdfasdas - " + verifyLogin("2asdffaadasfsdfasdas"));
        System.out.println("asdfasdfasdf - " + verifyLogin("asdfasdfasdf"));
        System.out.println("a.,sdfasdasd - " + verifyLogin("a.,sdfasdasd"));
        System.out.println("asdfaas@d - " + verifyLogin("asdfaas@d"));
        System.out.println("sdfasdfasdfasdf - " + verifyLogin("sdfasdfasdfasdf"));
        System.out.println("asdf2314123fasdf - " + verifyLogin("asdf2314123fasdf"));
    }

    static boolean verifyLogin(String email) {
        String reg = "^[a-zA-Z-_][\\w-]{4,}$";
        return email.matches(reg);
    }
}
