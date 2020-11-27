import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = System.getProperty("user.dir") + File.separator + "src" + File.separator;

    public static void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        final List<BankTransaction> transactions = bankStatementProcessor.findTransaction(bankTransaction ->
           bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1000
        );
        final List<BankTransaction> moreTransactions = bankTransactions
                                                        .stream()
                                                        .filter(bankTransaction ->
                                                                bankTransaction.getAmount() >= 1_000)
                                                        .collect(Collectors.toList());
        collectSummary(bankStatementProcessor);
    }//end main

    private static void collectSummary(final BankStatementProcessor processor){
        println("The total for all transactions is " + processor.calculateTotalAmount());
        println("The total for transactions in January is " + processor.calculateTotalInMonth(Month.JANUARY));
        println("The total for transactions in February is " + processor.calculateTotalInMonth(Month.FEBRUARY));
        println("The total salary received is " + processor.calculateTotalInCategory("Salary"));
    }

    private static void println(String statement){
        System.out.println(statement);
    }
}//end BankTransactionAnalyzer
