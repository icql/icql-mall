//package work.icql.icm.product.b.server.util.pdf;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.pdf.PdfCopy;
//import com.itextpdf.text.pdf.PdfImportedPage;
//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.SimpleBookmark;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.*;
//
//public class PdfMergeUtils {
//    private PdfMergeUtils() {
//    }
//
//    public static void merge(String inPath, String outPath) throws Exception {
//        if (!Files.isDirectory(Paths.get(inPath)) || !Files.isDirectory(Paths.get(outPath))) {
//            throw new IllegalArgumentException("参数inPath和outPath必须为文件夹");
//        }
//        File[] inPdfFileArray = new File(inPath).listFiles(f -> f.getName().endsWith(".pdf"));
//        if (inPdfFileArray == null || inPdfFileArray.length < 2) {
//            throw new IllegalArgumentException("inPath文件夹内pdf文件数量至少为2个");
//        }
//
//        //按照文件名排序
//        List<File> inPdfFiles = Arrays.asList(inPdfFileArray);
//        inPdfFiles.sort(Comparator.comparing(File::getPath));
//        String outFile = Paths.get(outPath, "00_" + (System.currentTimeMillis() + "_输出.pdf")).toString();
//
//        Document outPdf = new Document();
//        PdfCopy outPdfWriter = new PdfCopy(outPdf, new FileOutputStream(outFile));
//        outPdf.open();
//        int pageOffset = 0;
//        List<HashMap<String, Object>> allBookmarks = new ArrayList<>();
//        for (File pdfFile : inPdfFiles) {
//            PdfReader reader = new PdfReader(pdfFile.getPath());
//            reader.consolidateNamedDestinations();
//            int pages = reader.getNumberOfPages();
//            //处理内容
//            for (int pageNum = 0; pageNum < pages; pageNum++) {
//                PdfImportedPage page = outPdfWriter.getImportedPage(reader, pageNum + 1);
//                outPdfWriter.addPage(page);
//            }
//            //处理书签
//            HashMap<String, Object> firstPage = new HashMap<>(3);
//            firstPage.put("Action", "GoTo");
//            firstPage.put("Color", "0 0 0");
//            firstPage.put("Title", pdfFile.getName());
//            firstPage.put("Page", (pageOffset + 1) + " FitH " + reader.getPageSize(1).getHeight());
//            allBookmarks.add(firstPage);
//            List<HashMap<String, Object>> bookmarks = SimpleBookmark.getBookmark(reader);
//            if (bookmarks != null && bookmarks.size() > 0) {
//                SimpleBookmark.shiftPageNumbers(bookmarks, pageOffset, null);
//                allBookmarks.addAll(bookmarks);
//            }
//            pageOffset += pages;
//        }
//        outPdfWriter.setOutlines(allBookmarks);
//        outPdf.close();
//    }
//}
