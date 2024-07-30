public class BuilderPatternExample {

    
    public static class Computer {
        
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private boolean isWiFiEnabled;

        
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.isWiFiEnabled = builder.isWiFiEnabled;
        }

        
        public String toString() {
            return "Computer{" +
                    "CPU='" + CPU + '\'' +
                    ", RAM='" + RAM + '\'' +
                    ", storage='" + storage + '\'' +
                    ", graphicsCard='" + graphicsCard + '\'' +
                    ", isWiFiEnabled=" + isWiFiEnabled +
                    '}';
        }

        
        public static class Builder {
            
            private final String CPU;
            private final String RAM;

            
            private String storage = "256GB SSD";
            private String graphicsCard = "Integrated";
            private boolean isWiFiEnabled = true;

            
            public Builder(String CPU, String RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            
            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setWiFiEnabled(boolean isWiFiEnabled) {
                this.isWiFiEnabled = isWiFiEnabled;
                return this;
            }

            
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    
    public static void main(String[] args) {
        

        
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();
        System.out.println("Basic Computer: " + basicComputer);

        
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 7", "16GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA GeForce RTX 3080")
                .setWiFiEnabled(true)
                .build();
        System.out.println("Gaming Computer: " + gamingComputer);

        
        Computer officeComputer = new Computer.Builder("Intel i7", "16GB")
                .setStorage("512GB SSD")
                .build();
        System.out.println("Office Computer: " + officeComputer);
    }
}
