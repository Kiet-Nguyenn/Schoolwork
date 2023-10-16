public class AllStarPacket extends StarterPacket {
    private int photoMagazineCover;
    private int photoTradingCards;

    public AllStarPacket(){
        super();
        photoMagazineCover = 1;
        photoTradingCards = 16;
    }

    @Override
    public String getPacketName(){
        return "AllStar Packet";
    }

    @Override
    public String toString(){
        return super.toString() + "\nMagazine Cover = " + photoMagazineCover + "\nTrading Cards = " + photoTradingCards;
    }

}