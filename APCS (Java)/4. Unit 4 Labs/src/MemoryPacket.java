public class MemoryPacket extends StarterPacket {
    private int photo5x7;
    private int privateWallets;

    public MemoryPacket(){
        super();
        photo5x7 = 2;
        privateWallets = 8;
    }

    @Override
    public String getPacketName(){
        return "Memory Packet";
    }

    public String toString(){
        return super.toString() + "\n5 x 7 = " + photo5x7 + "\nWallets = " + privateWallets;
    }

}