class Temps {
    private int heure;
    private int minute;
    private int seconde;

    public void setTime(int h, int m, int s){
        if( (h >=0 && h <24) && ( m >= 0 && m < 60) &&
            ( s>= 0 && s<60)){
                heure = h;
                minute = m;
                seconde = s;
            }
        else
            throw new IllegalArgumentException( "l'heure, minute et/ou seconde est incorrect");
    }

    public String universelle()
    {
        return String.format("%02d:%02d:%02d", heure, minute, seconde);
    }

    @Override
    public String toString()
    {
        return String.format("%02d:%02d:%02d %s", ( (heure == 0 || heure == 12) ? 12 : heure % 12),
                                minute, seconde, (heure < 12 ? "AM" : "PM"));
    }



}