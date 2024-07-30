public class FactoryMethodPatternExample {

    
    interface Document {
        void open();
    }

    
    static class WordDocument implements Document {
        
        public void open() {
            System.out.println("Opening Word Document.");
        }
    }

    static class PdfDocument implements Document {
        
        public void open() {
            System.out.println("Opening PDF Document.");
        }
    }

    static class ExcelDocument implements Document {
        
        public void open() {
            System.out.println("Opening Excel Document.");
        }
    }

    
    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    static class WordDocumentFactory extends DocumentFactory {
        
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    
    public static void main(String[] args) {
        
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        
        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}
