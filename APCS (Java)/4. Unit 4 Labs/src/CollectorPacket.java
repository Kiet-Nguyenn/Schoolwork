public class CollectorPacket extends ChampionPacket {
    private int photoWallets;

    public CollectorPacket(){
        super();
        photoWallets = 8;
    }

    @Override
    public String getPacketName(){
        return "Collector Packet";
    }

    @Override
    public String toString(){
        return super.toString() + "\nWallets = " + photoWallets;
    }
}