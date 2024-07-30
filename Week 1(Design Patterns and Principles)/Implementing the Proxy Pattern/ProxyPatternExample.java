public class ProxyPatternExample {

    
    interface Image {
        void display();
    }

    
    static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadImageFromServer();
        }

        private void loadImageFromServer() {
            
            System.out.println("Loading image: " + fileName);
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }

    
    static class ProxyImage implements Image {
        private RealImage realImage;
        private String fileName;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    
    public static void main(String[] args) {
        
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        
        System.out.println("First call to display image1:");
        image1.display(); 

        System.out.println("Second call to display image1:");
        image1.display(); 

        System.out.println("First call to display image2:");
        image2.display(); 
    }
}
