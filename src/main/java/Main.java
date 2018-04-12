import com.external.PaymentsService;
import com.internal.DiscountCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.debug("First module is loading");

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.calculateDiscount(BigDecimal.valueOf(3000), 12);

        logger.debug("first module loaded");
        logger.error("second module is loading");

        PaymentsService paymentsService = new PaymentsService();
        paymentsService.makePayment(123, 1, BigDecimal.valueOf(1000));

        logger.debug("second module loaded");
    }
}
