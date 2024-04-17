public class SpieleSammlung {
    int wuerfelspiele;
    int kartenspiele;
    int geschicklichkeitsspiele;
    
    public SpieleSammlung(int wuerfelspiele, int kartenspiele, int geschicklichkeitsspiele) {
        this.wuerfelspiele = wuerfelspiele;
        this.kartenspiele = kartenspiele;
        this.geschicklichkeitsspiele = geschicklichkeitsspiele;
    }
    
    public int GetWuerfelspieleProTüte(int tüten){
        return wuerfelspiele / tüten;
    }

    public int GetKartenspieleProTüte(int tüten){
        return kartenspiele / tüten;
    }

    public int GetGeschicklichkeitsspieleProTüte(int tüten){
        return geschicklichkeitsspiele / tüten;
    }

    public int GetSpieleGesamt(){
        return wuerfelspiele + kartenspiele + geschicklichkeitsspiele;
    }
}
