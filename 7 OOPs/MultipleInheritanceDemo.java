interface Camera {
    void clickPhoto();
}

interface MusicPlayer {
    void playMusic();
}

class SmartPhone implements Camera, MusicPlayer {
    public void clickPhoto() {
        System.out.println("Photo Clicked");
    }

    public void playMusic() {
        System.out.println("Playing Music");
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {

        SmartPhone phone = new SmartPhone();

        phone.clickPhoto();
        phone.playMusic();
    }
}