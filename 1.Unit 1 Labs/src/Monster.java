class Monster
{
    private String type;
    private int scareFactor;
    private double size;
    public Monster(String t, int sf, double s)
    {
        type = t;
        scareFactor = sf;
        size = s;
    }
// write method equals below

    @Override
    public boolean equals(Object obj){
        Monster temp = (Monster) obj;
        return this.type.equalsIgnoreCase(temp.type) &&
                this.size == temp.size;
    }
}