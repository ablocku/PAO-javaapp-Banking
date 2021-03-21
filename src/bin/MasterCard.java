package bin;

abstract public class MasterCard extends Card{

    @Override
    public void CardInfo() {
        String type = "MasterCard";
        System.out.println(type);
        super.CardInfo();
    }
}
