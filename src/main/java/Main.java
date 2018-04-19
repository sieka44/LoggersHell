import com.external.PaymentsService;
import com.internal.DiscountCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        PaymentsService paymentsService = new PaymentsService();
        logger.trace("Program start with:" + String.join(",", args));
        BigDecimal ticketPrice;
        int age;
        int clientId;
        int companyId;
        if (args.length >= 4) {
            ticketPrice = BigDecimal.valueOf(Double.parseDouble(args[0]));
            age = Integer.parseInt(args[1]);
            clientId = Integer.parseInt(args[2]);
            companyId = Integer.parseInt(args[3]);
            BigDecimal price = discountCalculator.calculateDiscount(ticketPrice, age);
            paymentsService.makePayment(clientId, companyId, price);
        } else {
            logger.error("No specify arguments in input. Make sure it's ticketPrice/age/clientId/companyId");
        }
    }
}
