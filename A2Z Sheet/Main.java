interface Camera{
    void click();
}

interface MusicPlayer{
    void playMusic();
}

class SmartPhone implements Camera, MusicPlayer{
    public void click(){
        System.out.println("Photo Clicked");
    }

    public void playMusic(){
        System.out.println("Playing Music");
    }
}

public class Main{
    public static void main(String[] args){

        SmartPhone phone = new SmartPhone();

        phone.click();

        phone.playMusic();
    }
}



