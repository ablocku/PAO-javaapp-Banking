package bin;

public class Visa extends Card{

    @Override
    public void CardInfo() {
        String type = "Visa";
        System.out.println(type);
        super.CardInfo();
    }
}
